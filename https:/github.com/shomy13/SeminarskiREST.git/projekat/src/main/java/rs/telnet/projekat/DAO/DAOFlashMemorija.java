package rs.telnet.projekat.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import rs.telnet.projekat.model.Proizvod;

import java.util.ArrayList;

public class DAOFlashMemorija {
	
	 private DataSource ds;
	 	
	   private static String SELECTFLASHMEMORIJA="SELECT *FROM proizvod WHERE vrsta = ?";
	/*   private static String INSERTFLASHMEMORIJA="INSERT INTO flashmemorija(sifra,proizvodjac,model,cena,kapacitet,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?)";
	   private static String DELETEFLASHMEMORIJA = "DELETE  FROM flashmemorija WHERE sifra = ?";
	   private static String GETFLASHMEMORIJAID = "SELECT * FROM flashmemorija WHERE sifra=?";
	   private static String GETRFLASHMEMORIJA=  "SELECT * FROM flashmemorija ORDER BY RAND() LIMIT 1";
	   private static String AKCIJAFLASHMEMORIJA = "SELECT * FROM flashmemorija WHERE akcija='1' ";
	   private static String PRETRAGAFLASHMEMORIJA= "SELECT * FROM flashmemorija where proizvodjac=? OR kapacitet=? OR model=?";*/
	   
	   public DAOFlashMemorija(){
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
	   
	   public ArrayList<Proizvod> selectflashMemorija(){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
			ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
			Proizvod fm = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(SELECTFLASHMEMORIJA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1,"FMem");
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
	   
	/*   public void insertflashMemorija(Proizvod fm){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(INSERTFLASHMEMORIJA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1,fm.getSifra());
				pstm.setString(2,fm.getProizvodjac());
				pstm.setString(3,fm.getModel());
				pstm.setFloat(4,fm.getCena());
				pstm.setString(5,fm.getKapacitet());
				pstm.setString(6,fm.getSlika());
				pstm.setInt(7,fm.getGarancija());
				pstm.setString(8,fm.getAkcija());
				pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

			
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
			
		}
	   
	   public void deleteFlashMemorija(String sifra){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 

			try {
				con = ds.getConnection();
				pstm = con.prepareStatement(DELETEFLASHMEMORIJA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, sifra);
				pstm.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	   
	   public Proizvod getFLASHMemorijaID (String sifra){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			Proizvod fm=null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
			
					
	         try {
				con = ds.getConnection();
				pstm = con.prepareStatement(GETFLASHMEMORIJAID);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, sifra);
				pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
					// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
					fm = new Proizvod();
					// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
					fm.setAkcija(rs.getString("akcija"));
					fm.setSifra(rs.getString("sifra"));
					fm.setProizvodjac(rs.getString("proizvodjac"));
					fm.setModel(rs.getString("model"));
					fm.setKapacitet(rs.getString("kapacitet"));
					fm.setSlika(rs.getString("slika"));
					fm.setCena(rs.getFloat("cena"));
					
					fm.setGarancija(rs.getInt("garancija"));
					
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
			return fm; 
		// DEFINICIJA OSTALIH METODA ... 
		}
		
		public Proizvod getRFlasMemorija(){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			Proizvod fm=null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(GETRFLASHMEMORIJA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				
				pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
					fm=new Proizvod();

					
					fm.setAkcija(rs.getString("akcija"));
					fm.setSifra(rs.getString("sifra"));
					fm.setProizvodjac(rs.getString("proizvodjac"));
					fm.setModel(rs.getString("model"));
					fm.setSlika(rs.getString("slika"));
					fm.setKapacitet(rs.getString("kapacitet"));
					fm.setCena(rs.getFloat("cena"));
					fm.setGarancija(rs.getInt("garancija"));
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
			return fm; 
		}
		public ArrayList<Proizvod> akcijaFlashMemorija(){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
			ArrayList<Proizvod> fles = new ArrayList<Proizvod>();
			Proizvod fm;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(AKCIJAFLASHMEMORIJA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				
				pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();
				while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
					fm = new Proizvod();

					fm.setSifra(rs.getString("sifra"));
					fm.setProizvodjac(rs.getString("proizvodjac"));
					fm.setModel(rs.getString("model"));
					fm.setCena(rs.getFloat("cena"));
					fm.setKapacitet(rs.getString("kapacitet"));
					fm.setSlika(rs.getString("slika"));
					fm.setGarancija(rs.getInt("garancija"));
					fm.setAkcija(rs.getString("akcija"));
					
					fles.add(fm);
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
			return fles; 
		}
		public ArrayList<Proizvod> pretragaFlesMemorija(String search){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
			ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
			Proizvod fm = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(PRETRAGAFLASHMEMORIJA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, search);
				pstm.setString(2, search);
				pstm.setString(3, search);
			
				
				pstm.execute();

	//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
					fm = new Proizvod();

					fm.setSifra(rs.getString("sifra"));
					fm.setProizvodjac(rs.getString("proizvodjac"));
					fm.setModel(rs.getString("model"));
					fm.setCena(rs.getFloat("cena"));
					fm.setKapacitet(rs.getString("kapacitet"));
					fm.setSlika(rs.getString("slika"));
					fm.setGarancija(rs.getInt("garancija"));
					fm.setAkcija(rs.getString("akcija"));
					
					
					lo.add(fm);
				}
	//****KRAJ		KRAJ OBRADE ResultSet-a	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lo; 
		}
		
		*/
		
		
		

}
