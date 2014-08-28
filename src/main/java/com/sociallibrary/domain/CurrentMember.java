package com.sociallibrary.domain;


public class CurrentMember {

	 private static  Member current_member;
	 private static CurrentMember cm=null;
	 private CurrentMember(Member member){
		 CurrentMember.current_member=member;
	 }
	
	 public static CurrentMember getMemberInstance(Member member){
		 if(cm==null){
			 cm=new CurrentMember(member);
			 return cm;
		 }
		 else{
			 return cm;
		 }
	 }
	 
	 public static Member getMember(){
		 if(cm!=null){
			 return current_member;
		 }
		 else return null;
		
	 }
	
}
