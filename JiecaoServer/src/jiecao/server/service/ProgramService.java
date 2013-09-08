package jiecao.server.service;

import java.util.List;

import jiecao.server.domain.Program;

public interface ProgramService {
	
	public Program getLiveItem();
	
	public Program getUpcomingItem();
	
	public List<Program> getCollectedItemsList();

}
