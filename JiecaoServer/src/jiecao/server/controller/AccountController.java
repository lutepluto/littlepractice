package jiecao.server.controller;

import java.util.HashMap;
import java.util.Map;

import jiecao.server.domain.User;
import jiecao.server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lutepluto
 *
 */

@Controller
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST, value="/setting")
	@ResponseBody
	public Map<String, String> getAccountInfo(@RequestBody Map<String, String> sessionId){
		
		Map<String, String> accountInfo = new HashMap<String, String>();
		User user = userService.getUserBySid(sessionId.get("sid"));
		
		String imgUrl = user.getProfile_image_url();
		String name = user.getNickname();
		long remain  = user.getCaobi_count();
		
		accountInfo.put("imgUrl", imgUrl);
		accountInfo.put("name", name);
		accountInfo.put("remain", String.valueOf(remain));
		return accountInfo;
	}
	
}
