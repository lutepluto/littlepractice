package jiecao.server.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import jiecao.server.domain.Program;
import jiecao.server.mapper.ProgramMapper;
import jiecao.server.service.ProgramService;

public class ProgramServiceImpl implements ProgramService {
	
	private ProgramMapper programMapper;
	
	public void setProgramMapper(ProgramMapper programMapper){
		this.programMapper = programMapper;
	}
	
	public ProgramMapper getProgramMapper(){
		return this.programMapper;
	}
	
	@Override
	public Program getLiveItem(){
		
		Time time = new Time(Calendar.getInstance().getTimeInMillis());
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		String currentTime = time.toString();
		String currentDate = date.toString();
		
		return this.programMapper.getLiveItemDetailInfo(currentDate, currentTime);
	}
	
	@Override
	public Program getUpcomingItem() {
		
		Time time = new Time(Calendar.getInstance().getTimeInMillis());
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		String currentTime = time.toString();
		String currentDate = date.toString();
		
		return this.programMapper.getUpcomingItemDetailInfo(currentDate, currentTime);
	}
	
	@Override
	public List<Program> getCollectedItemsList(){
		return this.programMapper.getCollectedItems();
	}
	
}
