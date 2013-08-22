package jiecao.server.controller;

import java.util.HashMap;

import jiecao.server.domain.LiveImage;
import jiecao.server.service.LiveImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客户端发送json数据格式：
 * {
 * 	"currentTimeStamp":${上次接收到的图片的timestamp}
 * }
 *
 * 服务器返回客户端成功的json数据格式
 * {
 * 	"type":xxx  //1:正在直播，2:直播预告
 * 	"imgUrl":${url}	//图片url
 * }
 * 服务器返回客户端失败的json数据格式
 * {
 * 	"success":"false"
 * }
 * @author Lutepluto
 * 
 */

@Controller
@RequestMapping(value="/index")
public class ImageController {
	
	@Autowired
	private LiveImageService liveImageService;
	
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/main")
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
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runtimeExceptionHandler(RuntimeException runtimeException){
		return runtimeException.getMessage();
	}
	
}
