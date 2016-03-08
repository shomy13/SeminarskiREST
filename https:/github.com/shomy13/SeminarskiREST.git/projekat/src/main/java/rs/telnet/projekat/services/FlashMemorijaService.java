package rs.telnet.projekat.services;


import java.util.ArrayList;

import rs.telnet.projekat.DAO.DAOFlashMemorija;

import rs.telnet.projekat.exceptions.DataNotFoundException;
import rs.telnet.projekat.model.Proizvod;

public class FlashMemorijaService {
	DAOFlashMemorija df = new DAOFlashMemorija();
	
	public FlashMemorijaService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<Proizvod> getAllFM(){
		
		ArrayList<Proizvod> lp = null;
		lp=df.selectflashMemorija();
		return lp;
	
		
	}
	
/*	public void insertFM(Proizvod fm){
		df.insertflashMemorija(fm);
		
	}
	
	public void deleteFM(String string){
		df.deleteFlashMemorija(string);
	}
	
	public Proizvod getById(String string){
		Proizvod flashMemorija = df.getFLASHMemorijaID(string);
		if(flashMemorija == null){
			throw new DataNotFoundException("Memorija sa sifrom " +string+" nije pronadjena!");
		}
		return df.getFLASHMemorijaID(string);
		
	}*/

}
