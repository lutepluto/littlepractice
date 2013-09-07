package jiecao.server.domain;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 6650698410091559879L;
	
	private int uid;
	private String sid;
	private long sns_id;
	private String nickname;
	private String description;
	private String profile_image_url;
	private char gender;
	private int user_type;
	private String sns_type;
	private long caobi_count;
	private int red_count;
	private int blue_count;
	
	
	public void setUid(int uid){
		this.uid = uid;
	}
	
	public int getUid(){
		return this.uid;
	}
	
	public void setSid(String sid){
		this.sid = sid;
	}
	
	public String getSid(){
		return this.sid;
	}
	
	public void setSns_id(long sns_id){
		this.sns_id = sns_id;
	}
	
	public long getSns_id(){
		return this.sns_id;
	}
	
	public void setNickname(String nickname){
		this.nickname = nickname;
	}
	
	public String getNickname(){
		return this.nickname;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setProfile_image_url(String profile_image_url){
		this.profile_image_url = profile_image_url;
	}
	
	public String getProfile_image_url(){
		return this.profile_image_url;
	}
	
	public void setGender(char gender){
		this.gender = gender;
	}
	
	public char getGender(){
		return this.gender;
	}
	
	public void setUser_type(int user_type){
		this.user_type = user_type;
	}
	
	public int getUser_type(){
		return this.user_type;
	}
	
	public void setSns_type(String sns_type){
		this.sns_type = sns_type;
	}
	
	public String getSns_type(){
		return this.sns_type;
	}
	
	public void setCaobi_count(long caobi_count){
		this.caobi_count = caobi_count;
	}
	
	public long getCaobi_count(){
		return this.caobi_count;
	}
	
	public void setRed_count(int red_count){
		this.red_count = red_count;
	}
	
	public int getRed_count(){
		return this.red_count;
	}
	
	public void setBlue_count(int blue_count){
		this.blue_count = blue_count;
	}
	
	public int getBlue_count(){
		return this.blue_count;
	}
}
