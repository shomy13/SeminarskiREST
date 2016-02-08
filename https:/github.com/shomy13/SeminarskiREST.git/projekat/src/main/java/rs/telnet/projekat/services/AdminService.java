package rs.telnet.projekat.services;

import rs.telnet.projekat.DAO.DAOAdmin;

public class AdminService {
	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	DAOAdmin da = new DAOAdmin();

	public boolean daLiPostoji(String string, String string2 ){
		if(da.existAdmin(string, string2))
		return true;
		else 
		return false;
	}
	
	public void updateAdmin(String pass, String user){
		da.updateAdmin(pass, user);
		
	}
	
}
