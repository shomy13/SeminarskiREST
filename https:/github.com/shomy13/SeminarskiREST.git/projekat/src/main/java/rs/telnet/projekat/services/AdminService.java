package rs.telnet.projekat.services;

import rs.telnet.projekat.DAO.DAOKorisnik;

public class AdminService {
	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	DAOKorisnik da = new DAOKorisnik();

	public boolean daLiPostoji(String string, String string2 ){
		if(da.existAdmin(string, string2))
		return true;
		else 
		return false;
	}
	
	/*public void updateAdmin(String pass, String user){
		da.updateAdmin(pass, user);
		
	}*/
	
}
