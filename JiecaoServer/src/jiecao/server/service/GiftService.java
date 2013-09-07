package jiecao.server.service;

public interface GiftService {
	public boolean itemAcceptsGift(int iid, int uid, int count, String type);
	
	public boolean resetGiftCount(int iid);
}
