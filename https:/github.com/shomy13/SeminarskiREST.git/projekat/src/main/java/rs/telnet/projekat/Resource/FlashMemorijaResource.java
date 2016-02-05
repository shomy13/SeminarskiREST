package rs.telnet.projekat.Resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.telnet.projekat.model.FlashMemorija;
import rs.telnet.projekat.services.FlashMemorijaService;

@Path("/fmemorija")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlashMemorijaResource {

	FlashMemorijaService flashMemorijaService = new FlashMemorijaService();
	
	@GET
	public ArrayList<FlashMemorija> GetAll(){
		return flashMemorijaService.getAllFM();
	}
	
	@GET
	@Path("/{sifra}")
	public FlashMemorija getBySifra(@PathParam("sifra") String sifra){
		 return flashMemorijaService.getById(sifra);
	}
	
	
	@POST
	
	public void insertFlashMemorija( FlashMemorija fm){
		flashMemorijaService.insertFM(fm);
	}
		
	
	@DELETE
	@Path("/{memorija}")
	public void deleteFlashMemorija(@PathParam("memorija") String memorija){
		flashMemorijaService.deleteFM(memorija);
	}

}
