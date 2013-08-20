package jiecao.server.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import jiecao.server.domain.User;
import jiecao.server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	@ResponseBody
	public Object login(/*HttpSession httpSession,*/@RequestBody User user){
		HashMap<String, String> response = new HashMap<String, String>();
		boolean success = userService.insertUser(user);
		if(success){
			User u = userService.getUserBySnsIdAndType(user.getSns_type(), user.getSns_id());
			response.put("success", "true");
			response.put("sid", u.getSid());
			response.put("userType", String.valueOf(u.getUser_type()));
			//httpSession.setAttribute("user", u);
		}else{
			response.put("success", "false");
		}
		return response;
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runtimeExceptionHandler(RuntimeException runtimeException){
		return runtimeException.getMessage();
	}
}
