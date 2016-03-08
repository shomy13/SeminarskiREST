package rs.telnet.projekat.DAO;

import javax.sql.DataSource;

import rs.telnet.projekat.model.Proizvod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DAOProizvodi {
	
	private DataSource ds;
	
	private static String RETURNALL = "SELECT * FROM proizvod";
	
	  public DAOProizvodi(){
			try {
				InitialContext cxt = new InitialContext();
				if ( cxt == null ) { 
				} 
				ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" ); 
				if ( ds == null ) { 
				} 		
				} catch (NamingException e) {
				}
			}
	  
	  public ArrayList<Proizvod> returnall(){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
			ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
			Proizvod fm = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNALL);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				
				pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
					// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
					fm = new Proizvod();
					// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
					fm.setVrsta(rs.getString("vrsta"));
					fm.setProizvodjac(rs.getString("proizvodjac"));
					fm.setModel(rs.getString("model"));
					fm.setSlika(rs.getString("slika"));
					fm.setTip(rs.getString("tip"));
					fm.setKapacitet(rs.getString("kapacitet"));
					fm.setSocket(rs.getString("socket"));
					fm.setTakt(rs.getString("takt"));
					fm.setAkcija(rs.getByte("akcija"));
					fm.setDijagonala(rs.getBigDecimal("dijagonala"));
					fm.setCena(rs.getBigDecimal("cena"));
					fm.setGarancija(rs.getInt("garancija"));
					fm.setId(rs.getInt("id"));
					// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
					lo.add(fm);
				}
	//****KRAJ OBRADE ResultSet-a	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
			return lo; 
		}
}
