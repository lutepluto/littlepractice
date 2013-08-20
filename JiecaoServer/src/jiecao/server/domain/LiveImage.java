package jiecao.server.domain;

import java.io.Serializable;

public class LiveImage implements Serializable {

	private static final long serialVersionUID = 288417128978684683L;
	
	private int image_id;
	private String image_url;
	private int image_type;
	private String image_name;
	private long image_timestamp;
	
	public void setImage_id(int image_id){
		this.image_id = image_id;
	}
	
	public int getImage_id(){
		return this.image_id;
	}
	
	public void setImage_url(String image_url){
		this.image_url = image_url;
	}
	
	public String getImage_url(){
		return this.image_url;
	}
	
	public void setImage_type(int image_type){
		this.image_type = image_type;
	}
	
	public int getImage_type(){
		return this.image_type;
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
}
