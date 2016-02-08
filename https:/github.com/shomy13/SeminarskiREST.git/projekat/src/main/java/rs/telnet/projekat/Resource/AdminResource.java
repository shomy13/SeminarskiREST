package rs.telnet.projekat.Resource;


import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import rs.telnet.projekat.services.AdminService;

@Path("/admin")


public class AdminResource {
	AdminService as = new AdminService();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String daLiPostojiAdmin(@QueryParam("user") String user, @QueryParam("pass") String pass){
		
		if(as.daLiPostoji(user, pass))
		return "postoji";
		else
		return "Greska pri logovanju";
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
