package com.deveshswaika.messenger.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.deveshswaika.messenger.model.Message;
import com.deveshswaika.messenger.service.MessageService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;


@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
	                                 @QueryParam("start") int start,
	                                 @QueryParam("size") int size) {
		
		/*
		 * You can replace All the multiple query param using beam param and defining a class for same
		 * getMessages(@BeamParam MessageFilterBean filterBean) {
		 *     if(filterBean.getYear()>0)
		 *     remaining will be done accordingly
		 * }
		 */
		if(year>0)
			return messageService.getAllMessagesForYear(year);
		if(start>=0 && size>0)
			return messageService.getAllMessagesPaginated(start,size);
		return messageService.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message removeMessage(@PathParam("messageId") long id) {
		return messageService.removeMessage(id);
	}
	
    @GET                  
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id,
    		                  @Context UriInfo uriInfo) {
    	
    	Message message =  messageService.getMessage(id);
    	String uri =uriInfo.getBaseUriBuilder()      
    	       .path(MessageResource.class)                      //you can use profileResource.class to get path of profile
    	       .path(Long.toString(message.getId()))
    	       .build()
    	       .toString();
    	message.addLink(uri,"self");
    	return message;
    }
	
    @Path("/{messageId}/comments")  //hand over the responsibility
    public CommentResource getCommentResource() {
    	return new CommentResource();
    }
    
    /* Sending status codes and response entity
     * this is use to modify response 
     * use all the different functions and finally use .build();
     * 
     * @POST
	    public Response addMessage(Message message) {
	       Message newMessage = messageService.addMessage(message);
	       return Response.status(Status.CREATED) //Response has many functions you can use
	                      .entity(newMessage)
	                      .build();     
	    }
     * 
     * 
     */

}
