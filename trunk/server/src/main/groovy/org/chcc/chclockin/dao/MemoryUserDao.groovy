package org.chcc.chclockin.dao

import org.chcc.chclockin.model.User

public class MemoryUserDao implements UserDao {
	private Collection<User> users = new ArrayList<User>()
	private static MemoryUserDao instance = null
	
	private MemoryUserDao() {
		
	}
	
	public static MemoryUserDao getInstance() {
		if (null == instance) {
			instance = new MemoryUserDao();
		}
		
		return instance
	}
	
	void addUser(User newUser) throws DaoException {
		for (User user : users) {
			if (user.id == newUser.id) {
				throw new DaoException("Trying to add a user that already exists [${newUser.id}]")
			}
		}
		
		users.add(newUser);
	}
	
	Collection<User> getAllUsers() throws DaoException{
		return users
	}
	
	User getUserById(String id) throws DaoException {
		for (User user : users) {
			if (user.id == id) {
				return user
			}
		}
		
		return null
	}
}
