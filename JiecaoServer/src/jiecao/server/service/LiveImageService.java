package jiecao.server.service;

import jiecao.server.domain.LiveImage;

public interface LiveImageService {
	
	public LiveImage getNewestLiveImage(long timestamp);
	
}
