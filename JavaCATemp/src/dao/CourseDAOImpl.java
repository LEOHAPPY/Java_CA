package dao;

import java.sql.*;
import java.util.*;

import exception.NotFoundException;

import java.math.*;

import model.Course;

public class CourseDAOImpl implements CourseDAO {

	@Override
	public Course createValueObject() {
		// TODO Auto-gereturn new Course();
		return new Course();
	}

	@Override
	public Course getObject(Connection conn, String courseId) throws NotFoundException, SQLException {
		// TODO Auto-generated method stub
		Course valueObject = createValueObject();
        valueObject.setCourseId(courseId);
        load(conn, valueObject);
        return valueObject;
	}

	@Override
	public void load(Connection conn, Course valueObject) throws NotFoundException, SQLException {
		
		if (valueObject.getCourseId() == null) {
            //System.out.println("Can not select without Primary-Key!");
            throw new NotFoundException("Can not select without Primary-Key!");
       }

       String sql = "SELECT * FROM courses WHERE (CourseID = ? ) "; 
       PreparedStatement stmt = null;

       try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valueObject.getCourseId()); 

            singleQuery(conn, stmt, valueObject);

       } finally {
           if (stmt != null)
               stmt.close();
       }
		// TODO Auto-generated method stub
		
	}

	@Override
	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM courses ORDER BY CourseID ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
	}

	@Override
	public void create(Connection conn, Course valueObject) throws SQLException {
		 String sql = "";
         PreparedStatement stmt = null;
         ResultSet result = null;

         try {
              sql = "INSERT INTO courses ( CourseName, CourseStart, CourseEnd, "
              + "CourseCredit, CourseMaxSize, CourseDesc, "
              + "LectureID) VALUES (?, ?, ?, ?, ?, ?, ?) ";
              stmt = conn.prepareStatement(sql);

              stmt.setString(1, valueObject.getCourseName()); 
              stmt.setDate(2, valueObject.getCourseStart()); 
              stmt.setDate(3, valueObject.getCourseEnd()); 
              stmt.setInt(4, valueObject.getCourseCredit()); 
              stmt.setInt(5, valueObject.getCourseMaxSize()); 
              stmt.setString(6, valueObject.getCourseDesc()); 
              stmt.setString(7, valueObject.getLectureId()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount != 1) {
                   //System.out.println("PrimaryKey Error when updating DB!");
                   throw new SQLException("PrimaryKey Error when updating DB!");
              }

         } finally {
             if (stmt != null)
                 stmt.close();
         }


         /**
         * The following query will read the automatically generated primary key
         * back to valueObject. This must be done to make things consistent for 
         * upper layer processing logic.
         */
         sql = "SELECT last_insert_id()";

         try {
             stmt = conn.prepareStatement(sql);
             result = stmt.executeQuery();

             if (result.next()) {

                  //valueObject.setCourseId(new String((int)result.getLong(1)));
                  valueObject.setCourseId(result.getString("CourseID"));

             } else {
                  //System.out.println("Unable to find primary-key for created object!");
                  throw new SQLException("Unable to find primary-key for created object!");
             }
         } finally {
             if (result != null)
                 result.close();
             if (stmt != null)
                 stmt.close();
         }
		
	}

	@Override
	public void save(Connection conn, Course valueObject) throws NotFoundException, SQLException {
		String sql = "UPDATE courses SET CourseName = ?, CourseStart = ?, CourseEnd = ?, "
	               + "CourseCredit = ?, CourseMaxSize = ?, CourseDesc = ?, "
	               + "LectureID = ? WHERE (CourseID = ? ) ";
	          PreparedStatement stmt = null;

	          try {
	              stmt = conn.prepareStatement(sql);
	              stmt.setString(1, valueObject.getCourseName()); 
	              stmt.setDate(2, valueObject.getCourseStart()); 
	              stmt.setDate(3, valueObject.getCourseEnd()); 
	              stmt.setInt(4, valueObject.getCourseCredit()); 
	              stmt.setInt(5, valueObject.getCourseMaxSize()); 
	              stmt.setString(6, valueObject.getCourseDesc()); 
	              stmt.setString(7, valueObject.getLectureId()); 

	              stmt.setString(8, valueObject.getCourseId()); 

	              int rowcount = databaseUpdate(conn, stmt);
	              if (rowcount == 0) {
	                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
	                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
	              }
	              if (rowcount > 1) {
	                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
	                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
	              }
	          } finally {
	              if (stmt != null)
	                  stmt.close();
	          }
		
	}

	@Override
	public void delete(Connection conn, Course valueObject) throws NotFoundException, SQLException {
		// TODO Auto-generated method stub
		if (valueObject.getCourseId() == null) {
            //System.out.println("Can not delete without Primary-Key!");
            throw new NotFoundException("Can not delete without Primary-Key!");
       }

       String sql = "DELETE FROM courses WHERE (CourseID = ? ) ";
       PreparedStatement stmt = null;

       try {
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, valueObject.getCourseId()); 

           int rowcount = databaseUpdate(conn, stmt);
           if (rowcount == 0) {
                //System.out.println("Object could not be deleted (PrimaryKey not found)");
                throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
           }
           if (rowcount > 1) {
                //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
           }
       } finally {
           if (stmt != null)
               stmt.close();
       }
	}

	@Override
	public void deleteAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM courses";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            int rowcount = databaseUpdate(conn, stmt);
        } finally {
            if (stmt != null)
                stmt.close();
        }
	}

	@Override
	public int countAll(Connection conn) throws SQLException {
		String sql = "SELECT count(*) FROM courses";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next())
                allRows = result.getInt(1);
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
        return allRows;
	}

	@Override
	public List searchMatching(Connection conn, Course valueObject) throws SQLException {
		List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM courses WHERE 1=1 ");

        if (valueObject.getCourseId() != null) {
            if (first) { first = false; }
            sql.append("AND CourseID LIKE '").append(valueObject.getCourseId()).append("%' ");
        }

        if (valueObject.getCourseName() != null) {
            if (first) { first = false; }
            sql.append("AND CourseName LIKE '").append(valueObject.getCourseName()).append("%' ");
        }

        if (valueObject.getCourseStart() != null) {
            if (first) { first = false; }
            sql.append("AND CourseStart = '").append(valueObject.getCourseStart()).append("' ");
        }

        if (valueObject.getCourseEnd() != null) {
            if (first) { first = false; }
            sql.append("AND CourseEnd = '").append(valueObject.getCourseEnd()).append("' ");
        }

        if (valueObject.getCourseCredit() != 0) {
            if (first) { first = false; }
            sql.append("AND CourseCredit = ").append(valueObject.getCourseCredit()).append(" ");
        }

        if (valueObject.getCourseMaxSize() != 0) {
            if (first) { first = false; }
            sql.append("AND CourseMaxSize = ").append(valueObject.getCourseMaxSize()).append(" ");
        }

        if (valueObject.getCourseDesc() != null) {
            if (first) { first = false; }
            sql.append("AND CourseDesc LIKE '").append(valueObject.getCourseDesc()).append("%' ");
        }

        if (valueObject.getLectureId() != null) {
            if (first) { first = false; }
            sql.append("AND LectureID LIKE '").append(valueObject.getLectureId()).append("%' ");
        }


        sql.append("ORDER BY CourseID ASC ");

        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.
        if (first)
             searchResults = new ArrayList();
        else
             searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
	}

	@Override
	public String getDaogenVersion() {
		return "DaoGen version 2.4.1";
	}

	@Override
	public int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {
		 int result = stmt.executeUpdate();

         return result;
	}

	@Override
	public void singleQuery(Connection conn, PreparedStatement stmt, Course valueObject)
			throws NotFoundException, SQLException {
		ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                 valueObject.setCourseId(result.getString("CourseID")); 
                 valueObject.setCourseName(result.getString("CourseName")); 
                 valueObject.setCourseStart(result.getDate("CourseStart")); 
                 valueObject.setCourseEnd(result.getDate("CourseEnd")); 
                 valueObject.setCourseCredit(result.getInt("CourseCredit")); 
                 valueObject.setCourseMaxSize(result.getInt("CourseMaxSize")); 
                 valueObject.setCourseDesc(result.getString("CourseDesc")); 
                 valueObject.setLectureId(result.getString("LectureID")); 

            } else {
                  //System.out.println("Course Object Not Found!");
                  throw new NotFoundException("Course Object Not Found!");
            }
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
		
	}

	@Override
	public List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {
		ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                 Course temp = createValueObject();

                 temp.setCourseId(result.getString("CourseID")); 
                 temp.setCourseName(result.getString("CourseName")); 
                 temp.setCourseStart(result.getDate("CourseStart")); 
                 temp.setCourseEnd(result.getDate("CourseEnd")); 
                 temp.setCourseCredit(result.getInt("CourseCredit")); 
                 temp.setCourseMaxSize(result.getInt("CourseMaxSize")); 
                 temp.setCourseDesc(result.getString("CourseDesc")); 
                 temp.setLectureId(result.getString("LectureID")); 

                 searchResults.add(temp);
            }

        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }

        return (List)searchResults;
  }
	
	
	
}
