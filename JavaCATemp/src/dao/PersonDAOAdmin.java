package dao;

import java.util.ArrayList;

import model.Person;

public interface PersonDAOAdmin {

	public Person findPerson(String heroName, String role) throws DAOException;

	public ArrayList<Person> findAllPerson(String role) throws DAOException;

	public void insertPerson(Person hero, String role) throws DAOException;

	public void updatePerson(Person hero, String role) throws DAOException;

	public void deletePerson(Person hero, String role) throws DAOException;

	public ArrayList<Person> findAllPerson(
            int offset, 
            int noOfRecords,String role);
	public int getNoOfRecords();
}
