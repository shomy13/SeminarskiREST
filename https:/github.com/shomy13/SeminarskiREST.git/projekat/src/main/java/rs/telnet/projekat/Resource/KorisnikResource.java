package rs.telnet.projekat.Resource;

import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import rs.telnet.projekat.model.Korisnk;
import rs.telnet.projekat.services.KorisnikService;
import rs.telnet.projekat.authentication.Credentials;
import rs.telnet.projekat.authentication.Secure;
import rs.telnet.projekat.authentication.SecureAdmin;
import rs.telnet.projekat.authentication.Token;
@Path("/korisnik")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KorisnikResource {
	KorisnikService as = new KorisnikService();
		
	@POST
	public Token existUser( Credentials korisnik){
		if(as.daLiPostoji(korisnik.getEmail(), korisnik.getPass())!=null){
			Token t = new Token(Jwts.builder()
					.setSubject(String.valueOf(as.daLiPostoji(korisnik.getEmail(), korisnik.getPass()).getId()))
					.claim("admin", String.valueOf(as.daLiPostoji(korisnik.getEmail(), korisnik.getPass()).getAdmin()))
					.signWith(SignatureAlgorithm.HS256, "kljucic")
					.setIssuedAt(new Date())
					.setExpiration(new Date(new Date().getTime()+ 15L *60L*1000L))
					.compact(), as.daLiPostoji(korisnik.getEmail(), korisnik.getPass()).getAdmin(), as.daLiPostoji(korisnik.getEmail(), korisnik.getPass()).getId());
			return t;}
			else{
				
			return null;
	}
		
	}
	
	@GET
	@Secure
	@Path("/{id}")
	public Korisnk getById(@PathParam("id") String id){
		return as.returnById(id);
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public boolean insertKorisnik(Korisnk k){
		if(as.returnByEmail(k.getEmail()))
			
		return false;
		
		else{
			as.insertKorisnik(k);
		return true;
	}}
	
	@PUT
	@SecureAdmin
	@Path("/admin")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean insertAdmin(Korisnk k){
		if(as.returnByEmail(k.getEmail()))
			return false;
		else{
			as.insertAdmin(k);
			return true;
		}
	}
	@GET
	//@SecureAdmin
	public ArrayList<Korisnk> getall(){
		return as.returnall();
	}
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
