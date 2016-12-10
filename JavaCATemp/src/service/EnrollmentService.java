package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOException;
import dao.DAOFactory;
import dao.EnrollmentDAO;
import exception.NotFoundException;
import model.Enrollment;

public class EnrollmentService {
	private EnrollmentDAO udao;
	private Connection conn;

	public EnrollmentService() throws NotFoundException {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jvdb", "root", "password");
			this.udao = DAOFactory.getEnrollmentDao();
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

	public Enrollment findEnrollmentById(int enrollID) throws NotFoundException{
		try {
			return  (this.udao.getObject(this.conn,enrollID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}
		
	
	
	public ArrayList<Enrollment> findEnrollment() throws NotFoundException {
		try {
			return (ArrayList<Enrollment>) (this.udao.loadAll(this.conn));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}

	public void createEnrollment(Enrollment u) throws NotFoundException {
		try {
			this.udao.create(this.conn, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}

	public void updateEnrollment(Enrollment u) throws NotFoundException {
		try {
			this.udao.save(this.conn, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}

	public void deleteEnrollment(int uid) throws NotFoundException {
		try {
			Enrollment u = new Enrollment();
			u.setEnrollmentId(uid);
			this.udao.load(this.conn, u);
			this.udao.delete(this.conn, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}
	
	public int findCourseCountByCourseID(String id) throws NotFoundException, SQLException {
		int count=0;
		ArrayList<Enrollment> e=findEnrollment();
		for (Enrollment enrollment : e) {
			if(enrollment.getCourseId().equals(id))
				count++;
		}
		
		return count;
	}
}


