package rs.telnet.projekat.services;

import rs.telnet.projekat.DAO.DAOKorisnik;
import rs.telnet.projekat.model.Korisnk;

public class AdminService {
	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	DAOKorisnik da = new DAOKorisnik();

	public Korisnk daLiPostoji(String email, String pass ){
		
		return da.existAdmin(email, pass);
	}
	
	/*public void updateAdmin(String pass, String user){
		da.updateAdmin(pass, user);
		
	}*/
	
}
