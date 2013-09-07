package jiecao.server.mapper;

import java.util.List;

import jiecao.server.domain.Item;

public interface ItemMapper {
	
	public Item getLiveItemDetailInfo(String currentDate, String currentTime);
	
	public Item getUpcomingItemDetailInfo(String currentDate, String currentTime);
	
	public List<Item> getCollectedItems();
	
	public int updateItemRedCount(int item_id, int count);
	
	public int updateItemBlueCount(int item_id, int count);

}
