package dao;

public class DAOFactory {

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
