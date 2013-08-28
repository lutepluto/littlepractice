package jiecao.server.mapper;

import java.util.List;

import jiecao.server.domain.Image;

public interface ImageMapper {
	
	public Image getLiveImage(int image_pid);
	
	public Image getUpcomingImage(int image_pid);
	
	public List<Image> getSelectionImageList();
	
}
