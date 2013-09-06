package jiecao.server.service;

import java.util.List;

import jiecao.server.domain.Item;

public interface ItemService {
	
	public Item getLiveItem();
	
	public Item getUpcomingItem();
	
	public List<Item> getCollectedItemsList();
	
}
