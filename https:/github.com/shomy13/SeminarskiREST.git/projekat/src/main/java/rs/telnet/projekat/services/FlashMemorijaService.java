package rs.telnet.projekat.services;

import java.util.ArrayList;

import rs.telnet.projekat.DAO.DAOFlashMemorija;
import rs.telnet.projekat.exceptions.DataNotFoundException;
import rs.telnet.projekat.model.FlashMemorija;

public class FlashMemorijaService {
	DAOFlashMemorija df = new DAOFlashMemorija();
	
	public FlashMemorijaService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<FlashMemorija> getAllFM(){
		ArrayList<FlashMemorija> lp = null;
		lp=df.selectflashMemorija();
		return lp;
	}
	
	public void insertFM(FlashMemorija fm){
		df.insertflashMemorija(fm);
		
	}
	
	public void deleteFM(String string){
		df.deleteFlashMemorija(string);
	}
	
	public FlashMemorija getById(String string){
		FlashMemorija flashMemorija = df.getFLASHMemorijaID(string);
		if(flashMemorija == null){
			throw new DataNotFoundException("Memorija sa sifrom " +string+" nije pronadjena!");
		}
		return df.getFLASHMemorijaID(string);
		
	}

}
