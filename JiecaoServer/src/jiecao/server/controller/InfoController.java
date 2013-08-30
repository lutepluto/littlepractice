package jiecao.server.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jiecao.server.domain.Image;
import jiecao.server.domain.Program;
import jiecao.server.service.ImageService;
import jiecao.server.service.ProgramService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lutepluto
 * 
 */

@Controller
public class InfoController {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ProgramService programService;
	
	//client request to get the newest program and image information
	@RequestMapping(method=RequestMethod.GET, value="/index/main")
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
		if(upcomingProgram != null){
			
			upcomingImage = this.imageService.getUpcomingImage(upcomingProgram.getProgram_id());
		}
		
		//往期精选图片集合
		List<Image> selections = this.imageService.getSelectionImageList();
		
		response.put("upcomingProgram", upcomingProgram);
		response.put("upcomingImage", upcomingImage);
		response.put("liveProgram", liveProgram);
		response.put("liveImage", liveImage);
		response.put("selections", selections);
		return response;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/image/{imgName:.*}.{extension:[a-z]*}")
	public ResponseEntity<byte[]> getImagebyName(@PathVariable("imgName") String imgName, 
			@PathVariable("extension") String extension, HttpServletRequest request) throws IOException{
		ServletContext servletContext = request.getSession().getServletContext();
		String realPath = servletContext.getRealPath("/");
		String fileName = imgName + "." + extension;
		String filePath = realPath + "resources\\program\\" + fileName;
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "image/"+extension);
		headers.setContentDispositionFormData("attachment", fileName);
		
		//System.out.println(realPath + " ---- real path!");
		//System.out.println("filename is " + imgName);
		
		//InputStream in = servletContext.getResourceAsStream(filePath);
		File image = FileUtils.getFile(filePath);
		InputStream in = FileUtils.openInputStream(image);
		byte[] data = IOUtils.toByteArray(in);
		headers.setContentLength(data.length);

		ResponseEntity<byte[]> res = new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
		return res;
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runtimeExceptionHandler(RuntimeException runtimeException){
		return runtimeException.getMessage();
	}
	
}
