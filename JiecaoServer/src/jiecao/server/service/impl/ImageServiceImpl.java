package jiecao.server.service.impl;

import java.util.List;

import jiecao.server.domain.Image;
import jiecao.server.mapper.ImageMapper;
import jiecao.server.service.ImageService;

public class ImageServiceImpl implements ImageService {
	
	private ImageMapper imageMapper;
	
	public void setImageMapper(ImageMapper imageMapper){
		this.imageMapper = imageMapper;
	}
	
	public ImageMapper getImageMapper(){
		return this.imageMapper;
	}

	@Override
	public Image getLiveImage(int image_pid) {
		Image liveImage = this.imageMapper.getLiveImage(image_pid);
		return liveImage;
	}
	
	@Override
	public Image getUpcomingImage(int image_pid){
		return this.imageMapper.getUpcomingImage(image_pid);
	}

	@Override
	public List<Image> getSelectionImageList() {
		return this.imageMapper.getSelectionImageList();
	}
	
	
}
