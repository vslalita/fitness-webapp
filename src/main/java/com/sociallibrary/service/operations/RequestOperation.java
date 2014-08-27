package com.sociallibrary.service.operations;


public class RequestOperation implements BookOperationRequest {
	private int id;
	public RequestOperation(int id){
		this.id=id;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		bo.requestBook(id);
	}

}
