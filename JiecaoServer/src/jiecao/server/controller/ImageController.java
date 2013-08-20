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
 * �ͻ��˷��͵�json���ݸ�ʽΪ��
 * {
 * 	"currentTimeStamp":${�ϴλ�ȡֱ��ͼƬʱ�õ���ͼƬ��timestamp}
 * }
 * ���������������ѯ����ͼƬ��timestamp���������ͼƬ��timestamp
 * ���ڿͻ��˴��͹�����timestamp����������������������µ�ͼƬ����Ҫ��
 * �Ϳͻ��ˣ����ؿͻ��˵�json���ݸ�ʽΪ��
 * {
 * 	"type":xxx  //1:����ֱ����2:ֱ��Ԥ��
 * 	"imgUrl":${url}	//ͼƬurl
 * }
 * ���û�����µ�ͼƬ���򷵻ص�json���ݸ�ʽΪ��
 * {
 * 	"success":"false"
 * }
 * ���ص�json���ݾ�Ϊ�ַ���
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
