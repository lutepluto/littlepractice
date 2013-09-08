package jiecao.server.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import jiecao.server.domain.Host;
import jiecao.server.domain.Image;
import jiecao.server.domain.Item;
import jiecao.server.domain.Program;
import jiecao.server.service.ImageService;
import jiecao.server.service.ProgramService;
import jiecao.server.service.UserService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
	private ProgramService itemService;
	
	@Autowired
	private UserService userSerivce;
	
	//client request to get the newest program and image information
	@RequestMapping(method=RequestMethod.GET, value="/index/main")
	@ResponseBody
	public Object getNews(){
		Map<String, Object> response = new HashMap<String, Object>();
		
		//直播节目信息
		Program liveProgram = this.itemService.getLiveItem();
		//直播预告信息
		Program upcomingProgram = this.itemService.getUpcomingItem();
		//往期精选节目
		List<Program> collectedPrograms = this.itemService.getCollectedItemsList();		
		
		response.put("upcomingProgram", upcomingProgram);
		
		response.put("liveProgram", liveProgram);
		
		response.put("collectedPrograms", collectedPrograms);
	
		return response;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/image/{imgName:.*}.{extension:[a-z]*}")
	public ResponseEntity<byte[]> getImagebyName(@PathVariable("imgName") String imgName, 
			@PathVariable("extension") String extension, HttpServletRequest request) throws IOException{
		ServletContext servletContext = request.getSession().getServletContext();
		String realPath = servletContext.getRealPath("/");
		String fileName = imgName + "." + extension;
		String filePath = realPath + "resources\\item\\" + fileName;
		
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
	
	@RequestMapping(method=RequestMethod.GET, value="/host/{host_id}")
	@ResponseBody
	public Object getHostInfo(@PathVariable int host_id){
		Map<String, Object> response = null;
		
		Host host = this.userSerivce.getHostInfoById(host_id);
		response = new HashMap<String, Object>();
		response.put("host", host);
		return response;
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runtimeExceptionHandler(RuntimeException runtimeException){
		return runtimeException.getMessage();
	}
	
	@ExceptionHandler(IOException.class)
	@ResponseBody
	public String ioExceptionHandler(IOException ioException){
		return ioException.getMessage();
	}
	
}
