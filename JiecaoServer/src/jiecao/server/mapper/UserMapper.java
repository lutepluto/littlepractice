package jiecao.server.mapper;

import org.apache.ibatis.annotations.*;

import jiecao.server.domain.User;

public interface UserMapper {
	
	//@Select("select * from jiecao_user where sns_id = #{sns_id} and sns_type = #{sns_type}")
	public User getUserBySnsIdAndType(@Param("sns_type") String sns_type, @Param("sns_id") long sns_id);
	
	public int insertUser(User user);
	
	public boolean updateUserSid(User user);
	
	public User getUserBySid(@Param("sid") String sid);
	
}
