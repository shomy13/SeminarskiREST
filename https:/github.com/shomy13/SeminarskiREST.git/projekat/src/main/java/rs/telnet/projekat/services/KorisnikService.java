package rs.telnet.projekat.services;

import java.util.ArrayList;

import rs.telnet.projekat.DAO.DAOKorisnik;
import rs.telnet.projekat.model.Korisnk;

public class KorisnikService {
	public KorisnikService() {
		// TODO Auto-generated constructor stub
	}
	DAOKorisnik da = new DAOKorisnik();

	public Korisnk daLiPostoji(String email, String pass ){
		
		return da.existUser(email, pass);
	}
	
	public boolean returnByEmail(String email){
		if(da.returnByEmail(email))
		return true;
		else
			return false;
	}
	
	public void insertKorisnik(Korisnk k){
		da.insertKorisnik(k);
	}
	
	public Korisnk returnById(String id){
		return da.returnById(id);
	}
	
	public void insertAdmin(Korisnk k){
		da.insertAdmin(k);
	}
	
	public ArrayList<Korisnk> returnall(){
		return da.returnAll();
	}
	/*public void updateAdmin(String pass, String user){
		da.updateAdmin(pass, user);
		
	}*/
	
}
