package jiecao.server.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jiecao.server.mapper.ProgramMapper;
import jiecao.server.mapper.UserMapper;
import jiecao.server.service.GiftService;

public class GiftServiceImpl implements GiftService {
	
	private UserMapper userMapper;
	private ProgramMapper programMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public ProgramMapper getProgramMapper() {
		return programMapper;
	}

	public void setProgramMapper(ProgramMapper programMapper) {
		this.programMapper = programMapper;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public boolean itemAcceptsGift(int iid, int uid, int count, String type) {
		
		if(type.equals("red")){
			int userResult = this.userMapper.updateUserRedCount(uid, -count);
			int itemResult = this.programMapper.updateItemRedCount(iid, count);
			if(userResult == 1 && itemResult == 1)
				return true;
			return false;
		}else{
			int userResult = this.userMapper.updateUserBlueCount(uid, -count);
			int itemResult = this.programMapper.updateItemBlueCount(iid, count);
			if(userResult == 1 && itemResult == 1)
				return true;
			return false;
		}
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public boolean resetGiftCount(int iid) {
		
		int result = this.programMapper.resetGiftCount(iid);
		if(result == 1)
			return true;
		return false;
	}
	
	
}
