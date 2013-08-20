package jiecao.server.controller;

import java.util.HashMap;

import jiecao.server.domain.LiveImage;
import jiecao.server.service.LiveImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lutepluto
 * 客户端发送的json数据格式为：
 * {
 * 	"currentTimeStamp":${上次获取直播图片时得到的图片的timestamp}
 * }
 * 服务器获得请求后查询最新图片的timestamp，如果最新图片的timestamp
 * 大于客户端传送过来的timestamp，则表明服务器存在有最新的图片，需要发
 * 送客户端，返回客户端的json数据格式为：
 * {
 * 	"type":xxx  //1:正在直播，2:直播预告
 * 	"imgUrl":${url}	//图片url
 * }
 * 如果没有最新的图片，则返回的json数据格式为：
 * {
 * 	"success":"false"
 * }
 * 返回的json数据均为字符串
 */

@Controller
public class ImageController {
	
	@Autowired
	private LiveImageService liveImageService;
	
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/index/main")
	@ResponseBody
	public HashMap<String, String> getNewestLiveImage(@RequestBody HashMap<String, Long> order){
		
		HashMap<String, String> response = new HashMap<String, String>();
		long currentTimeStamp = order.get("currentTimeStamp").longValue();
		LiveImage isNew = liveImageService.getNewestLiveImage(currentTimeStamp);
		
		if(isNew != null){
			response.put("type", String.valueOf(isNew.getImage_type()));
			response.put("imgUrl", isNew.getImage_url() + isNew.getImage_name());
		}else{
			response.put("success", "false");
		}
		return response;
	}
	
}
