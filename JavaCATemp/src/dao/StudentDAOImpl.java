package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.HeroDTO;
import model.HeroSearchDTO;
import model.Person;

public class StudentDAOImpl implements PersonDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/jvdb";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";


	public void deletePerson(Person p) throws DAOException {
		String deleteSql = "DELETE FROM students WHERE id='"
				+ p.getId().trim() + "';";
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
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing delete: " + deleteSql);
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
		String selectSql = "SELECT * FROM Students;";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + selectSql);
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
		String selectSql = "SELECT * FROM Students WHERE id='" + id.trim()
				+ "';";
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
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + selectSql);
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
		String insertSql = "INSERT INTO Students VALUES('" + p.getId()
				+ "', '" + p.getName() + "', '" + p.getEmail() 
				+ "', '" + p.getPw() + "', '" + p.getLogin()
				+ "');";
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
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing insert: " + insertSql);
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
		String updateSql = "UPDATE Students SET name = '"
				+ p.getName() + "', email = '" + p.getEmail()
				+ "', pw = '" + p.getPw() + "', login = '" + p.getLogin()
				+ "' WHERE id='" + p.getId() + "';";
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
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing update: " + updateSql);
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
}
