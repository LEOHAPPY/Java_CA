package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Course;
import model.Person;

public class LectureDAOImpl implements PersonDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/jvdb";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";

	public void deletePerson(Person p) throws DAOException {
		String deleteSql = "DELETE FROM Lectures WHERE id='" + p.getId().trim() + "';";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Executing delete: " + deleteSql);
			int rows = st.executeUpdate(deleteSql);
			System.out.println(rows);
			st.close();
		} catch (Exception e) {
			String error = "Error deleting users. Nested Exception is: " + e;
			System.out.println("#$#$#@$#@#@$#@$#@$#$#@");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public ArrayList<Person> findAllPerson() throws DAOException {
		ArrayList<Person> items = new ArrayList<Person>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String selectSql = "SELECT * FROM Lectures;";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Executing select: " + selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				Person oneP = new Person();
				oneP.setId(rs.getString("id"));
				oneP.setName(rs.getString("name"));
				oneP.setPw(rs.getString("pw"));
				oneP.setEmail(rs.getString("email"));
				oneP.setLogin(rs.getString("login"));
				items.add(oneP);
			}
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
		return items;
	}

	public Person findPerson(String id) throws DAOException {
		String selectSql = "SELECT * FROM Lectures WHERE id='" + id.trim() + "';";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Person oneP = new Person();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Executing select: " + selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				oneP.setId(rs.getString("id"));
				oneP.setName(rs.getString("name"));
				oneP.setPw(rs.getString("pw"));
				oneP.setEmail(rs.getString("email"));
				oneP.setLogin(rs.getString("login"));
			}
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
		System.out.println(oneP.toString());
		return oneP;
	}

	public void insertPerson(Person p) throws DAOException {
		String insertSql = "INSERT INTO Lectures VALUES('" + p.getId() + "', '" + p.getName() + "', '" + p.getEmail()
				+ "', '" + p.getPw() + "', '" + p.getLogin() + "');";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Executing insert: " + insertSql);
			int res = st.executeUpdate(insertSql);
			System.out.println(res);
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public void updatePerson(Person p) throws DAOException {
		String updateSql = "UPDATE Lectures SET name = '" + p.getName() + "', email = '" + p.getEmail() + "', pw = '"
				+ p.getPw() + "', login = '" + p.getLogin() + "' WHERE id='" + p.getId() + "';";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Executing update: " + updateSql);
			int res = st.executeUpdate(updateSql);
			System.out.println(res);
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public ArrayList<Course> CourseList(Person person) throws DAOException {
		ArrayList<Course> items = new ArrayList<Course>();
		String getSql = "SELECT * FROM jvdb.courses where LectureID ='" + person.getId().trim() + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Courses Taught: " + getSql);
			ResultSet result = st.executeQuery(getSql);

			while (result.next()) {
				Course valueObject = new Course();
				valueObject.setCourseId(result.getString("CourseID"));
				valueObject.setCourseName(result.getString("CourseName"));
				valueObject.setCourseStart(result.getDate("CourseStart"));
				valueObject.setCourseEnd(result.getDate("CourseEnd"));
				valueObject.setCourseCredit(result.getInt("CourseCredit"));
				valueObject.setCourseMaxSize(result.getInt("CourseMaxSize"));
				valueObject.setCourseDesc(result.getString("CourseDesc"));
				valueObject.setLectureId(result.getString("LectureID"));

				Statement st1 = conn.createStatement();
				ResultSet result1 = st1
						.executeQuery("SELECT COUNT(*) as enrolled FROM jvdb.enrollments where CourseID='"
								+ result.getString("CourseID").trim() + "'");
				if (result1.next())
					valueObject.setEnrolled(result1.getInt("enrolled"));
				st1.close();
				items.add(valueObject);
				// System.out.println(result);
			}
			st.close();
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		return items;
	}

	public ArrayList<Course> studentEnrolled(Person person) throws DAOException {
		ArrayList<Course> items = new ArrayList<Course>();
		String getSql = "SELECT * FROM jvdb.courses where LectureID ='" + person.getId().trim() + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Courses Taught: " + getSql);
			ResultSet result = st.executeQuery(getSql);

			while (result.next()) {
				Statement st1 = conn.createStatement();
				ResultSet result1 = st1.executeQuery("SELECT StudentID, CourseGrade FROM jvdb.enrollments courses where CourseID='"
						+ result.getString("CourseID").trim() + "'");
				while (result1.next()) {
					Statement st2 = conn.createStatement();
					ResultSet result2 = st2.executeQuery(
							"SELECT * FROM jvdb.students where id='" + result1.getString("StudentID").trim() + "'");
					if (result2.next()) {
						Course valueObject = new Course();
						valueObject.setCourseId(result.getString("CourseID"));
						valueObject.setCourseName(result.getString("CourseName"));
						valueObject.setCourseStart(result.getDate("CourseStart"));
						valueObject.setStudentId(result2.getString("id"));
						valueObject.setStudentName(result2.getString("name"));
						valueObject.setStudentEmail(result2.getString("email"));
						valueObject.setStudentGrade(result1.getString("CourseGrade"));
						items.add(valueObject);
					}
				}
				st1.close();
				
//			 System.out.println(items);
			}
			st.close();
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		return items;
	}
	
	@SuppressWarnings("finally")
	public ArrayList<Course> StudentPerformance(Person person) throws DAOException {
		ArrayList<Course> items = new ArrayList<Course>();
		String getSql = "SELECT * FROM jvdb.courses where LectureID ='" + person.getId().trim() + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Courses Taught: " + getSql);
			ResultSet result = st.executeQuery(getSql);

			while (result.next()) {
				Statement st1 = conn.createStatement();
				ResultSet result1 = st1.executeQuery("SELECT  FROM jvdb.enrollments courses where ='"
						+ result.getString("CourseID").trim() + "'");
				while (result1.next()) {
					Statement st2 = conn.createStatement();
					ResultSet result2 = st2.executeQuery(
							"SELECT * FROM jvdb.students where id='" + result1.getString("StudentID").trim() + "'");
					if (result2.next()) {
						Course valueObject = new Course();
						valueObject.setCourseId(result.getString("CourseID"));
						valueObject.setCourseName(result.getString("CourseName"));
						valueObject.setStudentId(result.getString("id"));
						valueObject.setStudentName(result2.getString("name"));
						valueObject.setCourseCredit(result2.getInt("CourseCredit"));
						valueObject.setStudentEmail(result2.getString("email"));
						items.add(valueObject);
					}
				}
				st1.close();
				
			 System.out.println(items);
			}
			st.close();
		} catch (Exception e) {
			throw new DAOException(e);
		} 
		finally 
		{
			try 
			{
				conn.close();
			} 
			catch (Exception e) 
			{
				
			}
		
		return items;
		}
	
		}
	
}
	
		

