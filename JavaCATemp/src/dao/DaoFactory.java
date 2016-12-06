package dao;

public class DaoFactory {

	public static PersonDAO getStudentDAO() {
		return new StudentDAOImpl();
	}
	
	public static PersonDAO getLectureDAO() {
		return new LectureDAOImpl();
	}
	
	public static PersonDAO getAdminDao() {
		return new AdminDAOImpl();
	}

}
