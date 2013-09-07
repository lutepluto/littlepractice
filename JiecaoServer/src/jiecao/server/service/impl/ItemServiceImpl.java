package jiecao.server.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import jiecao.server.domain.Item;
import jiecao.server.mapper.ItemMapper;
import jiecao.server.service.ItemService;

public class ItemServiceImpl implements ItemService {
	
	private ItemMapper itemMapper;
	
	public void setItemMapper(ItemMapper itemMapper){
		this.itemMapper = itemMapper;
	}
	
	public ItemMapper getItemMapper(){
		return this.itemMapper;
	}
	
	@Override
	public Item getLiveItem(){
		
		Time time = new Time(Calendar.getInstance().getTimeInMillis());
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		String currentTime = time.toString();
		String currentDate = date.toString();
		
		return this.itemMapper.getLiveItemDetailInfo(currentDate, currentTime);
	}
	
	@Override
	public Item getUpcomingItem() {
		
		Time time = new Time(Calendar.getInstance().getTimeInMillis());
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		String currentTime = time.toString();
		String currentDate = date.toString();
		
		return this.itemMapper.getUpcomingItemDetailInfo(currentDate, currentTime);
	}
	
	@Override
	public List<Item> getCollectedItemsList(){
		return this.itemMapper.getCollectedItems();
	}
	
}
