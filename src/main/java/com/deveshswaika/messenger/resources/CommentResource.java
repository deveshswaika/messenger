//this is sub resource from message resource
//responsibility is handed over to this section when messages/comment is encountered
//It will also have get,put,post and delete method
//create a comment model and service as well to complete the project
//likes and shares can also be attached this way
//I am eliminating all those things to reduce complexity
//I already know what rest api is and that should be enough as of now.





package com.deveshswaika.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {
	
	@GET
	public String test() {
		return "new sub resource";
	}
	
	@GET
	@Path("/{commentId}")
	public String test1(@PathParam("commentId") long commentId,
			            @PathParam("messageId") long messageId) {
		return "Method to return comment "+commentId+ " for message id "+messageId;
	}

}
