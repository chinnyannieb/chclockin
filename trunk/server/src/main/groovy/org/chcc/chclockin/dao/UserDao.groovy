package org.chcc.chclockin.dao

import org.chcc.chclockin.model.User

public interface UserDao {
	void addUser(User user);
	Collection<User> getAllUsers();
	User getUserById(String id);
}
