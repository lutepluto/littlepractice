package jiecao.server.domain;

import java.io.Serializable;
import java.sql.Date;

public class Item implements Serializable {

	private static final long serialVersionUID = -1760536511246336955L;
	
	private int item_id;
	private int item_pid;
	private int item_hid;
	private int item_listener_count;
	private int item_red_count;
	private int item_blue_count;
	private Date item_date;
	private int item_collection;
	
	private Program program;
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_pid() {
		return item_pid;
	}
	public void setItem_pid(int item_pid) {
		this.item_pid = item_pid;
	}
	public int getItem_hid() {
		return item_hid;
	}
	public void setItem_hid(int item_hid) {
		this.item_hid = item_hid;
	}
	public int getItem_listener_count() {
		return item_listener_count;
	}
	public void setItem_listener_count(int item_listener_count) {
		this.item_listener_count = item_listener_count;
	}
	public int getItem_red_count() {
		return item_red_count;
	}
	public void setItem_red_count(int item_red_count) {
		this.item_red_count = item_red_count;
	}
	public int getItem_blue_count() {
		return item_blue_count;
	}
	public void setItem_blue_count(int item_blue_count) {
		this.item_blue_count = item_blue_count;
	}
	public Date getItem_date() {
		return item_date;
	}
	public void setItem_date(Date item_date) {
		this.item_date = item_date;
	}
	public int getItem_collection() {
		return item_collection;
	}
	public void setItem_collection(int item_collection) {
		this.item_collection = item_collection;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
}
