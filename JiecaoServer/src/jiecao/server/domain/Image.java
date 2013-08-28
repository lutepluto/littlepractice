package jiecao.server.domain;

import java.io.Serializable;

public class Image implements Serializable {

	private static final long serialVersionUID = 288417128978684683L;
	
	private int image_id;
	private int image_pid;
	private String image_url;
	private String image_name;
	private long image_timestamp;
	private int image_status;
	
	public void setImage_id(int image_id){
		this.image_id = image_id;
	}
	
	public int getImage_id(){
		return this.image_id;
	}
	
	public void setImage_pid(int image_pid){
		this.image_pid = image_pid;
	}
	
	public int getImage_pid(){
		return this.image_pid;
	}
	
	public void setImage_url(String image_url){
		this.image_url = image_url;
	}
	
	public String getImage_url(){
		return this.image_url;
	}
	
	public void setImage_name(String image_name){
		this.image_name = image_name;
	}
	
	public String getImage_name(){
		return this.image_name;
	}
	
	public void setImage_timestamp(long image_timestamp){
		this.image_timestamp = image_timestamp;
	}
	
	public long getImage_timestamp(){
		return this.image_timestamp;
	}
	
	public void setImage_status(int image_status){
		this.image_status = image_status;
	}
	
	public int getImage_status(){
		return this.image_status;
	}
}
