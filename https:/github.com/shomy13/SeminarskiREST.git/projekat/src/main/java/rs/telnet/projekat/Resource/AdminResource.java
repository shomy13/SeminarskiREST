package rs.telnet.projekat.Resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import rs.telnet.projekat.model.Admin;
import rs.telnet.projekat.services.AdminService;

@Path("/admin")


public class AdminResource {
	AdminService as = new AdminService();
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String daLiPostojiAdmin(@QueryParam("user") String user, @QueryParam("pass") String pass){
		
		if(as.daLiPostoji(user, pass))
		return "succes";
		else
		return "error";
	}
	
	@POST
	@Path("/admin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String existAdmin( Admin admin){
		if(as.daLiPostoji(admin.getUser(), admin.getPass()))
			return "true";
			else
			return "false";
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAdmin(@QueryParam("pass") String pass,
			@QueryParam("user") String user,
			@QueryParam("passpr") String passpr){
		if(as.daLiPostoji(user, pass)){
		as.updateAdmin(passpr, user);
		return "uspesna promena";}
		else
			return "greska u podacima";
		
	}
	
	

}
