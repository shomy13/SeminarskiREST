package rs.telnet.projekat.Resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Path("/rnd")
	public ArrayList<Proizvod> getRnd(){
		return proizvodiServise.returnRnd();
	}

	@GET
	@Path("/akcija")
	public ArrayList<Proizvod> getAkcija(){
		return proizvodiServise.returnAkcija();
	}
	
	@GET
	@Path("/akcija/rnd")
	public ArrayList<Proizvod> getAkcijaRnd(){
		return proizvodiServise.returnAkcijaRnd();
	}
	
	@GET
	@Path("/{id}")
	public Proizvod getById(@PathParam("id") String id){
		return proizvodiServise.returnBYid(id);
	}
	
	@GET
	@Path("/p/{vrsta}")
	public ArrayList<Proizvod> getByVrsta(@PathParam("vrsta") String vrsta){
		return proizvodiServise.returnByVrsta(vrsta);
	}
}
