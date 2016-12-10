package dao;

import java.sql.*;
import java.util.*;

import exception.NotFoundException;
import model.Enrollment;

import java.io.IOException;
import java.math.*;



public class EnrollmentDAOImpl implements EnrollmentDAO{

	protected Connection conn;

	private void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/javacadatabase?autoReconnect=true&useSSL=false", "root", "password");
	}

	private void closeConnection() throws SQLException {

		this.conn.close();
	}
	
	@Override
	public int updateEnrollment(Enrollment c) throws ClassNotFoundException, SQLException {
		openConnection();
		PreparedStatement st = conn.prepareStatement("UPDATE javacadatabase.enrollments SET StudentID=?, CourseID=?, CourseGrade=? WHERE EnrollmentID=?;");
		st.setString(1,c.getStudentId());
		//System.out.println("Good");
		st.setString(2,c.getCourseId());
		st.setString(3,c.getCourseGrade());
		st.setInt(4,c.getEnrollmentId());
		int result=st.executeUpdate();
		//System.out.println("Update over");
		closeConnection();
		return result;
	}


	@Override
	public ArrayList<Enrollment> findAllEnrollments() throws ClassNotFoundException, SQLException, IOException {
		openConnection();
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM javacadatabase.enrollments;");
		ArrayList<Enrollment> eList = new ArrayList<Enrollment>();
		while (rs.next()) {

				Enrollment e = new Enrollment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				eList.add(e);
		}
		closeConnection();
		return eList;
	}

	@Override
	public Enrollment findById(String enrollmentID) throws ClassNotFoundException, SQLException {
		Enrollment e = new Enrollment();
		openConnection();
		PreparedStatement st = conn.prepareStatement("SELECT * FROM javacadatabase.enrollments WHERE EnrollmentID =?");
		st.setString(1,enrollmentID);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			e = new Enrollment(rs.getInt("EnrollmentID"), rs.getString("StudentID"), rs.getString("CourseID"),rs.getNString("CourseGrade"));
		}
		closeConnection();
		return e;
	}

	@Override
	public ArrayList<Enrollment> findEnrollmentsByCourse(String courseID)
			throws ClassNotFoundException, SQLException, IOException {
		openConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM javacadatabase.enrollments WHERE courseID=?;");
		ps.setString(1, courseID);
		ResultSet rs = ps.executeQuery();
		ArrayList<Enrollment> eList = new ArrayList<Enrollment>();
		while (rs.next()) {
			Enrollment e = new Enrollment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			eList.add(e);
		}
		closeConnection();
		return eList;
	}

	
	@Override
	public Enrollment createValueObject() {
		return new Enrollment();
	}

	@Override
	public Enrollment getObject(Connection conn, int enrollmentId) throws NotFoundException, SQLException {
		Enrollment valueObject = createValueObject();
        valueObject.setEnrollmentId(enrollmentId);
        load(conn, valueObject);
        return valueObject;
	}

	@Override
	public void load(Connection conn, Enrollment valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM enrollments WHERE (EnrollmentID = ? ) "; 
        PreparedStatement stmt = null;

        try {
             stmt = conn.prepareStatement(sql);
             stmt.setInt(1, valueObject.getEnrollmentId()); 

             singleQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null)
                stmt.close();
        }
		
	}

	@Override
	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM enrollments ORDER BY EnrollmentID ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
	}

	@Override
	public void create(Connection conn, Enrollment valueObject) throws SQLException {
		try {
			openConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
             sql = "INSERT INTO enrollments ( EnrollmentID, StudentID, CourseID, "
             + "CourseGrade) VALUES (?, ?, ?, ?) ";
             stmt = conn.prepareStatement(sql);

             stmt.setInt(1, valueObject.getEnrollmentId()); 
             stmt.setString(2, valueObject.getStudentId()); 
             stmt.setString(3, valueObject.getCourseId()); 
             stmt.setString(4, valueObject.getCourseGrade()); 

             int rowcount = databaseUpdate(conn, stmt);
             if (rowcount != 1) {
                  //System.out.println("PrimaryKey Error when updating DB!");
                  throw new SQLException("PrimaryKey Error when updating DB!");
             }

        } finally {
            if (stmt != null)
                stmt.close();
            closeConnection();
        }

		
	}

	@Override
	public void save(Connection conn, Enrollment valueObject) throws NotFoundException, SQLException {
		String sql = "UPDATE enrollments SET StudentID = ?, CourseID = ?, CourseGrade = ? WHERE (EnrollmentID = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valueObject.getStudentId()); 
            stmt.setString(2, valueObject.getCourseId()); 
            stmt.setString(3, valueObject.getCourseGrade()); 

            stmt.setInt(4, valueObject.getEnrollmentId()); 

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
	public void delete(Connection conn, Enrollment valueObject) throws NotFoundException, SQLException {
		String sql = "DELETE FROM enrollments WHERE (EnrollmentID = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getEnrollmentId()); 

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
		String sql = "DELETE FROM enrollments";
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
		 String sql = "SELECT count(*) FROM enrollments";
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
	public List searchMatching(Connection conn, Enrollment valueObject) throws SQLException {
		List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM enrollments WHERE 1=1 ");

        if (valueObject.getEnrollmentId() != 0) {
            if (first) { first = false; }
            sql.append("AND EnrollmentID = ").append(valueObject.getEnrollmentId()).append(" ");
        }

        if (valueObject.getStudentId() != null) {
            if (first) { first = false; }
            sql.append("AND StudentID LIKE '").append(valueObject.getStudentId()).append("%' ");
        }

        if (valueObject.getCourseId() != null) {
            if (first) { first = false; }
            sql.append("AND CourseID LIKE '").append(valueObject.getCourseId()).append("%' ");
        }

        if (valueObject.getCourseGrade() != null) {
            if (first) { first = false; }
            sql.append("AND CourseGrade LIKE '").append(valueObject.getCourseGrade()).append("%' ");
        }


        sql.append("ORDER BY EnrollmentID ASC ");

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
	public void singleQuery(Connection conn, PreparedStatement stmt, Enrollment valueObject)
			throws NotFoundException, SQLException {
		ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                 valueObject.setEnrollmentId(result.getInt("EnrollmentID")); 
                 valueObject.setStudentId(result.getString("StudentID")); 
                 valueObject.setCourseId(result.getString("CourseID")); 
                 valueObject.setCourseGrade(result.getString("CourseGrade")); 

            } else {
                  //System.out.println("Enrollment Object Not Found!");
                  throw new NotFoundException("Enrollment Object Not Found!");
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
                 Enrollment temp = createValueObject();

                 temp.setEnrollmentId(result.getInt("EnrollmentID")); 
                 temp.setStudentId(result.getString("StudentID")); 
                 temp.setCourseId(result.getString("CourseID")); 
                 temp.setCourseGrade(result.getString("CourseGrade")); 

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