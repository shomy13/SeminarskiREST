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
		pr = dp.returnall();
		return pr;
		
	}
	
	public ArrayList<Proizvod>returnRnd(){
		ArrayList<Proizvod> pr = null;
		pr = dp.returnRnd();
		return pr;
	}
	
	public ArrayList<Proizvod>returnAkcija(){
		ArrayList<Proizvod> pr = null;
		pr = dp.returnAkcija();
		return pr;
	}
	
	public ArrayList<Proizvod>returnAkcijaRnd(){
		ArrayList<Proizvod> pr = null;
		pr = dp.returnAkcijaRnd();
		return pr;
	}
	
	public Proizvod returnBYid(String id){
		Proizvod pr = new Proizvod();
		pr = dp.returnById(id);
		return pr;
	}
	
	public ArrayList<Proizvod> returnByVrsta(String vrsta){
		ArrayList<Proizvod> pr = null;
		pr = dp.returnByVrsta(vrsta);
		return pr;
	}

}
