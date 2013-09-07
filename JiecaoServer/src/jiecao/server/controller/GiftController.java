package jiecao.server.controller;

import java.util.HashMap;
import java.util.Map;

import jiecao.server.service.GiftService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GiftController {
	
	@Autowired
	private GiftService giftService;
	
	@RequestMapping(method=RequestMethod.POST, value="/gift/{type}")
	@ResponseBody
	public Object giveGift(@PathVariable String type, @RequestBody Map<String, Object> gift){
		Map<String, Integer> response  = new HashMap<String, Integer>();
		
		int uid = ((Integer)gift.get("uid")).intValue();
		//String sid = (String)gift.get("sid");
		int iid = ((Integer)gift.get("item_id")).intValue();
		int count = ((Integer)gift.get("count")).intValue();
		
		boolean result = this.giftService.itemAcceptsGift(iid, uid, count, type);
		if(result)
			response.put("status", new Integer(0));
		else
			response.put("status", new Integer(1));
		return response;
	}

}
