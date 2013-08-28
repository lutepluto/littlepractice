package jiecao.server.controller;

import java.util.HashMap;
import java.util.Map;

import jiecao.server.domain.User;
import jiecao.server.service.ImageService;
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
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ImageService liveImageService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	@ResponseBody
	public Object login(/*HttpSession httpSession,*/@RequestBody User user){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		boolean isAuthenticated = userService.userLogin(user);
		if(isAuthenticated){

			User u = userService.getUserBySnsIdAndType(user.getSns_type(), user.getSns_id());
			response.put("status", 0);
			response.put("uid", u.getUid());
			response.put("sid", u.getSid());
			
			//List<Image> selections = selectionImageService.getSelectionImageList(); 
			//response.put("selections", selections);
			
			//Image live = liveImageService.getNewestLiveImage(0);
			//response.put("live", live);
			
		}else{
			response.put("status", 1);
			response.put("uid", null);
			response.put("sid", null);
			response.put("selections", null);
			response.put("live", null);
		}
		return response;
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runtimeExceptionHandler(RuntimeException runtimeException){
		return runtimeException.getMessage();
	}
}
