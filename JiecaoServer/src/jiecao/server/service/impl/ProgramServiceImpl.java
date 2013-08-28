package jiecao.server.service.impl;

import java.sql.Time;
import java.util.Calendar;

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
	public Program getLiveProgram() {
		
		Time currentTime = new Time(Calendar.getInstance().getTimeInMillis());
		String currentTimeString = currentTime.toString();
		
		return this.programMapper.getLiveProgram(currentTimeString);
	}

	@Override
	public Program getUpcomingProgram() {
		
		Time currentTime = new Time(Calendar.getInstance().getTimeInMillis());
		String currentTimeString = currentTime.toString();
		return this.programMapper.getUpcomingProgram(currentTimeString);
	}

}
