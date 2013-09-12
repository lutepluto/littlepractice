package jiecao.server.service;

import jiecao.server.domain.Host;
import jiecao.server.domain.User;

public interface UserService {
	
	User getUserBySnsIdAndType(String sns_type, long sns_id);
	
	boolean insertUser(User user);
	
	void updateUser(User user);
	
	void updateUserSid(String newSid, int uid);
	
	User getUserBySid(String sid);
	
	User getUserByUid(int uid);
	
	boolean userLogin(User user);
	
	boolean updateUserRedCount(int uid, int count);
	
	Host getHostInfoById(int hid);
}
