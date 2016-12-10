package dao;

public class DAOFactory {

	public static PersonDAOAdmin getPersonDAO() {
		return new PersonDAOImpl();
	}
	
	public static PersonDAO getStudentDAO() {
		return new StudentDAOImpl();
	}
	
	public static PersonDAO getLectureDAO() {
		return new LectureDAOImpl();
	}
	
	public static PersonDAO getAdminDao() {
		return new AdminDAOImpl();
	}
	

	public static CourseDAO getCourseDao() {
		return new CourseDAOImpl();
	}
	
	public static EnrollmentDAO getEnrollmentDao() {
		return new EnrollmentDAOImpl();
	}
}
