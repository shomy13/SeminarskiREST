package rs.telnet.projekat.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.telnet.projekat.DAO.DAOProizvodi;
import rs.telnet.projekat.model.Proizvod;


public class ProizvodiService {
	DAOProizvodi dp = new DAOProizvodi();
	
	
	public ArrayList<Proizvod>returnAll(){
		ArrayList<Proizvod> pr = null;
		pr=dp.returnall();
		return pr;
		
	}

}
