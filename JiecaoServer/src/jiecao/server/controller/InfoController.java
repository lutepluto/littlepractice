package jiecao.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiecao.server.domain.Image;
import jiecao.server.domain.Program;
import jiecao.server.service.ImageService;
import jiecao.server.service.ProgramService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lutepluto
 * 
 */

@Controller
@RequestMapping(value="/index")
public class InfoController {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ProgramService programService;
	
	//client request to get the newest program and image information
	@RequestMapping(method=RequestMethod.GET, value="/main")
	@ResponseBody
	public Object getNews(){
		Map<String, Object> response = new HashMap<String, Object>();
		
		//直播节目信息
		Program liveProgram = this.programService.getLiveProgram();
		//直播预告信息
		Program upcomingProgram = this.programService.getUpcomingProgram();
		
		//直播节目图片
		Image liveImage = null;
		if(liveProgram != null)
			liveImage = this.imageService.getLiveImage(liveProgram.getProgram_id());
			
		//直播预告图片
		Image upcomingImage = null;
		if(upcomingProgram != null)
			this.imageService.getUpcomingImage(upcomingProgram.getProgram_id());
		
		//往期精选图片集合
		List<Image> selections = this.imageService.getSelectionImageList();
		
		response.put("upcomingProgram", upcomingProgram);
		response.put("upcomingImage", upcomingImage);
		response.put("liveProgram", liveProgram);
		response.put("liveImage", liveImage);
		response.put("selections", selections);
		return response;
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runtimeExceptionHandler(RuntimeException runtimeException){
		return runtimeException.getMessage();
	}
	
}
