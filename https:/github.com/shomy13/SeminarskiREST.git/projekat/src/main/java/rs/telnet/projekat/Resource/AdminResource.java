package rs.telnet.projekat.Resource;





import java.util.Date;

import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import rs.telnet.projekat.model.Korisnk;
import rs.telnet.projekat.services.AdminService;
import rs.telnet.projekat.authentication.Credentials;
import rs.telnet.projekat.authentication.Token;
@Path("/admin")


public class AdminResource {
	AdminService as = new AdminService();
		
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Token existAdmin( Credentials korisnik){
		if(as.daLiPostoji(korisnik.getEmail(), korisnik.getPass())){
			Token t = new Token(Jwts.builder()
					.setSubject(korisnik.getEmail())
					.signWith(SignatureAlgorithm.HS256, "kljucic")
					.setIssuedAt(new Date())
					.setExpiration(new Date(new Date().getTime()+ 1L *60L*1000L))
					.compact());
			return t;}
			else{
				
			return null;
	}}
	
/*	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAdmin(@QueryParam("pass") String pass,
			@QueryParam("user") String user,
			@QueryParam("passpr") String passpr){
		if(as.daLiPostoji(user, pass)){
		as.updateAdmin(passpr, user);
		return "uspesna promena";}
		else
			return "greska u podacima";
		
	}*/
	
	

}
