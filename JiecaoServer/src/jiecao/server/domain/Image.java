package jiecao.server.domain;

import java.io.Serializable;

public class Image implements Serializable {

	private static final long serialVersionUID = 288417128978684683L;
	
	private int image_id;
	private int image_iid;
	private String image_url;
	private String image_name;
	
	public void setImage_id(int image_id){
		this.image_id = image_id;
	}
	
	public int getImage_id(){
		return this.image_id;
	}
	
	public void setImage_iid(int image_iid){
		this.image_iid = image_iid;
	}
	
	public int getImage_iid(){
		return this.image_iid;
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
}
