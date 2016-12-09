package dao;

import java.util.ArrayList;

import model.Person;

public interface PersonDAO {
	public Person findPerson(String heroName) throws DAOException;
    public ArrayList<Person> findAllPerson() throws DAOException;
    public void insertPerson(Person hero) throws DAOException;
    public void updatePerson(Person hero) throws DAOException;
    public void deletePerson(Person hero) throws DAOException;
}
