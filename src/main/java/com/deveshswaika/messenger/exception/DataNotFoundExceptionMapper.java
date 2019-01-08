package com.deveshswaika.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.deveshswaika.messenger.model.ErrorMessage;


//exceptionMapper comes with jax rs
//it's a generic type exception mapper so you have to define the type of exception
//in this case the type of exception is DataNotFoundException
//then add unimplemented method using eclipse (public response....)


//It register this class in jax rs so that jax rs knows that this class is there
//the messageService throws an exception 
//that gets bubbled up to messageResource and then finally to jax rs
//now jax rs searches for @provider annotations to see if anything can be implemented for that exception
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	
	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage  = new ErrorMessage(ex.getMessage(),404,"http://google.com");
		return Response.status(Status.NOT_FOUND)
				       .entity(errorMessage)
				       .build();
		
	}
	

}
