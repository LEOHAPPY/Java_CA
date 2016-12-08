package dao;

public class DAOFactory {

	public static PersonDAO getPersonDAO() {
		return new PersonDAOImpl();
	}
	

	public static CourseDAO getCourseDao() {
		return new CourseDAOImpl();
	}
	
	public static EnrollmentDAO getEnrollmentDao() {
		return new EnrollmentDAOImpl();
	}
}
