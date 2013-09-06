package jiecao.server.controller;

import java.util.HashMap;

import jiecao.server.domain.Item;
import jiecao.server.domain.User;
import jiecao.server.mapper.UserMapper;
import jiecao.server.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class RestfulTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(method=RequestMethod.GET, value="/test")
	@ResponseBody
	public User getById(){
		User user = userMapper.getUserByUid(4);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/test/item")
	@ResponseBody
	public Item getUpcomingItem(){
		return this.itemService.getUpcomingItem();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/test")
	public @ResponseBody Object addUser(@RequestBody User u){
		
		User user = null;
		user = userMapper.getUserBySnsIdAndType(u.getSns_type(), u.getSns_id());
		
		int result;
		HashMap<String, String> response = new HashMap<String, String>();
		
		if(user != null){
			if(user.getSid() != u.getSid()){
				user.setSid(u.getSid());
				userMapper.updateUserSid(user);
			}
			response.put("success", "true");
			response.put("sid", user.getSid().toString());
			response.put("userType", String.valueOf(user.getUser_type()));
		}else{		
			result = userMapper.insertUser(u);
			if(result == 1){
				response.put("success", "true");
				response.put("sid", u.getSid().toString());
				response.put("userType", String.valueOf(0));
			}
			response.put("success", "false");
		}
		return response;
	}
	
	@RequestMapping
	public String getImage(){
		System.out.println("I've been invoked!");
		return "index";
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runtimeExceptionHandler(RuntimeException runtimeException){
		return runtimeException.getMessage();
	}
}
