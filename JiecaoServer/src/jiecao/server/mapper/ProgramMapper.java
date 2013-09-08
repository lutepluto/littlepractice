package jiecao.server.mapper;

import java.util.List;

import jiecao.server.domain.Program;

public interface ProgramMapper {
	
	public Program getLiveItemDetailInfo(String currentDate, String currentTime);
	
	public Program getUpcomingItemDetailInfo(String currentDate, String currentTime);
	
	public List<Program> getCollectedItems();
	
	public int updateItemRedCount(int item_id, int count);
	
	public int updateItemBlueCount(int item_id, int count);
	
	public int resetGiftCount(int item_id);

}
