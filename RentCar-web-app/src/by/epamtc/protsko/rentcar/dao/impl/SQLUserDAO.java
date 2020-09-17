package by.epamtc.protsko.rentcar.dao.impl;

import java.util.List;

import by.epamtc.protsko.rentcar.bean.User;
import by.epamtc.protsko.rentcar.bean.UserDTO;
import by.epamtc.protsko.rentcar.dao.UserDAO;
import by.epamtc.protsko.rentcar.dao.exception.DAOException;

public class SQLUserDAO implements UserDAO {

	@Override
	public User authentication(String login, String password) throws DAOException {
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registration(UserDTO userDTO) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editUserData(UserDTO userDTO) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userId) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUser(String criteria) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
