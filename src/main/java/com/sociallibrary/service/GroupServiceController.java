package com.sociallibrary.service;
//TODO Create methods for adding removing updating and deleting grps
public class GroupServiceController {
	static GroupServiceController groupServicecontroller=null;
	private GroupServiceController(){
	}
	
	public static GroupServiceController getInstance(){
		if(groupServicecontroller==null){
			groupServicecontroller=new GroupServiceController();
			return groupServicecontroller;
		}
		return groupServicecontroller;
	}
}
