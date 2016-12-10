package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.CourseDAO;
import dao.DAOFactory;
import exception.NotFoundException;
import model.Course;
import model.Enrollment;

public class CourseService {
	private CourseDAO udao;
	private Connection conn;
	private Statement stmt;
	private int noOfRecords;

	public CourseService() throws NotFoundException {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jvdb", "root", "password");
			this.udao = DAOFactory.getCourseDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Driver Fault");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("SQL Fault");
		}
	}
	public Course findCourseById(String coursID) throws NotFoundException{
		try {
			return  (this.udao.getObject(this.conn,coursID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}
	
	
	public ArrayList<Course> findCourses() throws NotFoundException {
		try {
			return (ArrayList<Course>) (this.udao.loadAll(this.conn));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}

	public void createCourse(Course u) throws NotFoundException {
		try {
			this.udao.create(this.conn, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}

	public void updateCourse(Course u) throws NotFoundException {
		try {
			this.udao.save(this.conn, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}

	public void deleteCourse(String uid) throws NotFoundException {
		try {
			Course u = new Course();
			u.setCourseId(uid);
			this.udao.load(this.conn, u);
			this.udao.delete(this.conn, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}
	
	public ArrayList<Course> findCourses (
            int offset, 
            int noOfRecords)
{
    String query = "select SQL_CALC_FOUND_ROWS * from courses limit "
             + offset + ", " + noOfRecords;
    ArrayList<Course> list = new ArrayList<Course>();
    Course c = null;
    try {
        
         stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            c = new Course();
            c.setCourseId(rs.getString("CourseID"));
            c.setCourseName(rs.getString("CourseName"));
            c.setCourseStart(rs.getDate("CourseStart"));
            c.setCourseEnd(rs.getDate("CourseEnd"));
            c.setCourseCredit(rs.getInt("CourseCredit"));
            c.setCourseMaxSize(rs.getInt("CourseMaxSize"));
            c.setCourseDesc(rs.getString("CourseDesc"));
            c.setLectureId(rs.getString("LectureID"));
            
            list.add(c);
        }
        rs.close();
         
        rs = stmt.executeQuery("SELECT FOUND_ROWS()");
        if(rs.next())
            this.noOfRecords = rs.getInt(1);
    } catch (SQLException e) {
        e.printStackTrace();
    }finally
    {
        try {
            if(stmt != null)
                stmt.close();
            if(conn != null)
                conn.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return list;
}

	public int getNoOfRecords() {
		return noOfRecords;
	}
	public ArrayList<Course> findAllCourses() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jvdb?autoReconnect=true&useSSL=false", "root", "password");
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM jvdb.courses;");
		ArrayList<Enrollment> eList = new ArrayList<Enrollment>();
		Course c = null;
		ArrayList<Course> cList = new ArrayList<Course>();
        while (rs.next()) {
            c = new Course();
            c.setCourseId(rs.getString("CourseID"));
            c.setCourseName(rs.getString("CourseName"));
            c.setCourseStart(rs.getDate("CourseStart"));
            c.setCourseEnd(rs.getDate("CourseEnd"));
            c.setCourseCredit(rs.getInt("CourseCredit"));
            c.setCourseMaxSize(rs.getInt("CourseMaxSize"));
            c.setCourseDesc(rs.getString("CourseDesc"));
            c.setLectureId(rs.getString("LectureID"));
            
            cList.add(c);
        }
        conn.close();
        return cList;
	}
}



