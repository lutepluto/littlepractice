package jiecao.server.service;

import jiecao.server.domain.Program;

public interface ProgramService {
	
	//获取正在直播的节目信息
	public Program getLiveProgram();
	
	//获取即将播出的节目信息
	public Program getUpcomingProgram();
	
}
