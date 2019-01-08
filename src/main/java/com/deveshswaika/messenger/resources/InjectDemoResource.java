package com.deveshswaika.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

//THIS IS NOT RELATED TO MESSENGER APP JUST FOR DEMO PURPOSE
//DIFFERENT TYPES OF PARAM ARE LISTED IN THIS CLASS

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamUsingAnnotations(@MatrixParam("param") String matrixparam,
			                               @HeaderParam("customheaderparam") String headerparam,
			                               @CookieParam("cookie") String cookie) {
		return "Matrix param: "+matrixparam+" customheaderparam: "+headerparam+ " cookieParam: "+cookie;
	}
	
	//Context param can be applied only to special variables and not premitive data types
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) { //UriInfo is a special class
		String path = uriInfo.getAbsolutePath().toString(); //lot more methods
		String head = headers.getCookies().toString();
		return "Path = "+path+" cookie = "+head;
	}
	
	

}
