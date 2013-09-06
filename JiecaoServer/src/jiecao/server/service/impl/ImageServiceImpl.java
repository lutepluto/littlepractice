package jiecao.server.service.impl;

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
	public Image getImageByItemId(int image_iid) {
		Image liveImage = this.imageMapper.getImageByItemId(image_iid);
		return liveImage;
	}
}
