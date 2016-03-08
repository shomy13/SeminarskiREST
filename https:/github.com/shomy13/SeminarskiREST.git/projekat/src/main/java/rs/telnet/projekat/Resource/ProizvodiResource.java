package rs.telnet.projekat.Resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.telnet.projekat.model.Proizvod;
import rs.telnet.projekat.services.ProizvodiService;

@Path("/proizvodi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProizvodiResource {
	ProizvodiService proizvodiServise = new ProizvodiService();
	
	@GET
	public ArrayList<Proizvod> getall(){
		return proizvodiServise.returnAll();
	}

}
