package jiecao.server.service.impl;

import jiecao.server.domain.LiveImage;
import jiecao.server.mapper.LiveImageMapper;
import jiecao.server.service.LiveImageService;

public class LiveImageServiceImpl implements LiveImageService {
	
	private LiveImageMapper liveImageMapper;
	
	public void setLiveImageMapper(LiveImageMapper liveImageMapper){
		this.liveImageMapper = liveImageMapper;
	}
	
	public LiveImageMapper getLiveImageMapper(){
		return this.liveImageMapper;
	}

	@Override
	public LiveImage getNewestLiveImage(long timestamp) {
		LiveImage liveImage = this.liveImageMapper.getNewestLiveImage();
		System.out.println("return img: " + liveImage.getImage_id());
		if(timestamp >= liveImage.getImage_timestamp())
			return null;
		else 
			return liveImage;
	}
}
