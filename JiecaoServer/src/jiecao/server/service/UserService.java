package jiecao.server.service;

import jiecao.server.domain.User;

public interface UserService {
	
	User getUserBySnsIdAndType(String sns_type, long sns_id);
	
	boolean insertUser(User user);
	
	void updateUser(User user);
	
	void updateUserSid(User user);
	
}
