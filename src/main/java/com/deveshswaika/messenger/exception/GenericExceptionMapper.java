package com.deveshswaika.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import com.deveshswaika.messenger.model.ErrorMessage;


public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),500,"http://google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				       .entity(errorMessage)
				       .build();
	}
	

}
