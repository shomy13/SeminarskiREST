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
	private static String RETURNRND = "SELECT * FROM proizvod ORDER BY RAND() LIMIT 10";
	private static String RETURNAKCIJA = "SELECT * FROM proizvod WHERE akcija = ? ";
	private static String RETURNAKCIJARND = "SELECT * FROM proizvod WHERE akcija = ? ORDER BY RAND() LIMIT 10";
	private static String RETURNBYID = "SELECT * FROM proizvod WHERE id = ?";
	private static String RETURNBYVRSTA = "SELECT * FROM proizvod WHERE vrsta = ?";
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
	  
	  public ArrayList<Proizvod> returnRnd(){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
			ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
			Proizvod fm = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNRND);

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
	  
	  public ArrayList<Proizvod> returnAkcija(){
		  Connection con = null;
		  PreparedStatement pstm = null;
		  ResultSet rs = null;
		  
		  ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
		  Proizvod pr = null;
		  
		  try {
			con = ds.getConnection();
			pstm = con.prepareStatement(RETURNAKCIJA);
			
			pstm.setString(1,"1");
			pstm.execute();
			
			rs = pstm.getResultSet();
			
			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pr = new Proizvod();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pr.setVrsta(rs.getString("vrsta"));
				pr.setProizvodjac(rs.getString("proizvodjac"));
				pr.setModel(rs.getString("model"));
				pr.setSlika(rs.getString("slika"));
				pr.setTip(rs.getString("tip"));
				pr.setKapacitet(rs.getString("kapacitet"));
				pr.setSocket(rs.getString("socket"));
				pr.setTakt(rs.getString("takt"));
				pr.setAkcija(rs.getByte("akcija"));
				pr.setDijagonala(rs.getBigDecimal("dijagonala"));
				pr.setCena(rs.getBigDecimal("cena"));
				pr.setGarancija(rs.getInt("garancija"));
				pr.setId(rs.getInt("id"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(pr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  return lo;
		  
	  }
	  
	  public ArrayList<Proizvod> returnAkcijaRnd(){
		  Connection con = null;
		  PreparedStatement pstm = null;
		  ResultSet rs = null;
		  
		  ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
		  Proizvod pr = null;
		  
		  try {
			con = ds.getConnection();
			pstm = con.prepareStatement(RETURNAKCIJARND);
			
			pstm.setString(1,"1");
			pstm.execute();
			
			rs = pstm.getResultSet();
			
			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pr = new Proizvod();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pr.setVrsta(rs.getString("vrsta"));
				pr.setProizvodjac(rs.getString("proizvodjac"));
				pr.setModel(rs.getString("model"));
				pr.setSlika(rs.getString("slika"));
				pr.setTip(rs.getString("tip"));
				pr.setKapacitet(rs.getString("kapacitet"));
				pr.setSocket(rs.getString("socket"));
				pr.setTakt(rs.getString("takt"));
				pr.setAkcija(rs.getByte("akcija"));
				pr.setDijagonala(rs.getBigDecimal("dijagonala"));
				pr.setCena(rs.getBigDecimal("cena"));
				pr.setGarancija(rs.getInt("garancija"));
				pr.setId(rs.getInt("id"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(pr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  return lo;
		  
	  }
	  
	  public Proizvod returnById (String id){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			Proizvod pr=null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
			
					
	         try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNBYID);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, id);
				pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
					// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
					pr = new Proizvod();
					// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
					pr.setVrsta(rs.getString("vrsta"));
					pr.setProizvodjac(rs.getString("proizvodjac"));
					pr.setModel(rs.getString("model"));
					pr.setSlika(rs.getString("slika"));
					pr.setTip(rs.getString("tip"));
					pr.setKapacitet(rs.getString("kapacitet"));
					pr.setSocket(rs.getString("socket"));
					pr.setTakt(rs.getString("takt"));
					pr.setAkcija(rs.getByte("akcija"));
					pr.setDijagonala(rs.getBigDecimal("dijagonala"));
					pr.setCena(rs.getBigDecimal("cena"));
					pr.setGarancija(rs.getInt("garancija"));
					pr.setId(rs.getInt("id"));
					
					// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
					
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
			return pr; 
		// DEFINICIJA OSTALIH METODA ... 
		}
	  
	
	   
	   public ArrayList<Proizvod> returnByVrsta(String vrsta){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
			ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
			Proizvod pr = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNBYVRSTA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, vrsta);
				pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
					// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
					pr = new Proizvod();
					// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
					pr.setVrsta(rs.getString("vrsta"));
					pr.setProizvodjac(rs.getString("proizvodjac"));
					pr.setModel(rs.getString("model"));
					pr.setSlika(rs.getString("slika"));
					pr.setTip(rs.getString("tip"));
					pr.setKapacitet(rs.getString("kapacitet"));
					pr.setSocket(rs.getString("socket"));
					pr.setTakt(rs.getString("takt"));
					pr.setAkcija(rs.getByte("akcija"));
					pr.setDijagonala(rs.getBigDecimal("dijagonala"));
					pr.setCena(rs.getBigDecimal("cena"));
					pr.setGarancija(rs.getInt("garancija"));
					pr.setId(rs.getInt("id"));
					// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
					lo.add(pr);
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
