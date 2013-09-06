package jiecao.server.domain;

import java.io.Serializable;

public class Host implements Serializable {

	private static final long serialVersionUID = -6853539409901156384L;
	
	private int host_id;
	private int host_uid;
	private int host_pid;
	private String host_name;
	private String host_description;
	
	public int getHost_id() {
		return host_id;
	}
	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}
	public int getHost_uid() {
		return host_uid;
	}
	public void setHost_uid(int host_uid) {
		this.host_uid = host_uid;
	}
	public int getHost_pid() {
		return host_pid;
	}
	public void setHost_pid(int host_pid) {
		this.host_pid = host_pid;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public String getHost_description() {
		return host_description;
	}
	public void setHost_description(String host_description) {
		this.host_description = host_description;
	}

}
