package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CourseDAO;
import dao.DAOFactory;
import exception.NotFoundException;
import model.Course;
import model.Enrollment;

public class CourseService {
	private CourseDAO udao;
	private Connection conn;

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
}



