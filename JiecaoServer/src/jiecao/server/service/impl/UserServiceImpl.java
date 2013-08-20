package jiecao.server.service.impl;

import jiecao.server.domain.User;
import jiecao.server.mapper.UserMapper;
import jiecao.server.service.UserService;

public class UserServiceImpl implements UserService {
	
	
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper){
		this.userMapper = userMapper;
	}
	
	public UserMapper getUserMapper(){
		return this.userMapper;
	}

	@Override
	public User getUserBySnsIdAndType(String sns_type, long sns_id) {
		return userMapper.getUserBySnsIdAndType(sns_type, sns_id);
	}

	@Override
	public boolean insertUser(User user) {
		User u = null;
		u = this.getUserBySnsIdAndType(user.getSns_type(), user.getSns_id());
		if(u != null ){
			if(u.getSns_id() != user.getSns_id()){
				this.updateUserSid(user);
			}
		}else{
			int result = userMapper.insertUser(user);
			if(result == 0)
				return false;
		}
		return true;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserSid(User user) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
