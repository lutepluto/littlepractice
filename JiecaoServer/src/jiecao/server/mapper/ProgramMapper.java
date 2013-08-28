package jiecao.server.mapper;

import jiecao.server.domain.Program;

public interface ProgramMapper {
	
	public Program getLiveProgram(String currentTimeString);
	
	public Program getUpcomingProgram(String currentTimeString);
	
}
