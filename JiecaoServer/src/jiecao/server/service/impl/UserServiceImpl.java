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
	public boolean insertUser(User user){
		
		int isSuccess = userMapper.insertUser(user);
		if(isSuccess == 1){
			return true;
		}
		return false;
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserSid(User user) {
		this.userMapper.updateUserSid(user);
	}
	
	public User getUserBySid(String sid){
		return this.userMapper.getUserBySid(sid);
	}
	
	@Override
	public User getUserByUid(int uid){
		return userMapper.getUserByUid(uid);
	}
	
	@Override
	public boolean userLogin(User user) {
		User u = null;
		System.out.println("---000");
		u = this.getUserBySnsIdAndType(user.getSns_type(), user.getSns_id());
		if(u != null ){
			if(u.getSid() != user.getSid()){
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
	public boolean updateUserRedCount(int uid, int count) {
		int result = this.userMapper.updateUserRedCount(uid, count);
		
		System.out.println("The result code is " + result);
		
		if(result == 1){
			return true;
		}
		return false;
	}
	
}
