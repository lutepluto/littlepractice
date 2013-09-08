package jiecao.server.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

public class Program implements Serializable {

	private static final long serialVersionUID = -3809364505420362487L;
	
	private int program_id;
	private String program_name;
	private String program_description;
	private Time program_stime;
	private Time program_etime;
	
	private List<Item> items;
	
	public void setProgram_id(int program_id){
		this.program_id = program_id;
	}
	
	public int getProgram_id(){
		return this.program_id;
	}
	
	public void setProgram_name(String program_name){
		this.program_name = program_name;
	}
	
	public String getProgram_name(){
		return this.program_name;
	}
	
	public void setProgram_description(String program_description){
		this.program_description = program_description;
	}
	
	public String getProgram_description(){
		return this.program_description;
	}
	
	public void setProgram_stime(Time program_stime){
		this.program_stime = program_stime;
	}
	
	public Time getProgram_stime(){
		return this.program_stime;
	}
	
	public void setProgram_etime(Time program_etime) {
		this.program_etime = program_etime;
	}
	
	public Time getProgram_etime(){
		return this.program_etime;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
}
