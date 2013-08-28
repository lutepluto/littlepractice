package jiecao.server.service;

import java.util.List;

import jiecao.server.domain.Image;

public interface ImageService {
	
	public Image getLiveImage(int image_pid);
	
	public Image getUpcomingImage(int image_pid);
	
	public List<Image> getSelectionImageList();
	
}
