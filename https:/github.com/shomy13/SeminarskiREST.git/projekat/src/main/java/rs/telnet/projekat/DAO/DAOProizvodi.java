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
	private static String INSERTPR = "INSERT INTO proizvod(vrsta, proizvodjac, model, cena, garancija, slika, akcija, tip, kapacitet, socket, dijagonala, takt)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	 
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
		
			ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
			Proizvod pr = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNALL);

				pstm.execute();

				rs = pstm.getResultSet();

				while(rs.next()){ 
					pr = new Proizvod();
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
					lo.add(pr);
				}
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
	  
	  public ArrayList<Proizvod> returnRnd(){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
			Proizvod pr = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNRND);

				pstm.execute();


				rs = pstm.getResultSet();

				while(rs.next()){ 
					pr = new Proizvod();
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
					lo.add(pr);
				}
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
			
			while(rs.next()){ 
				pr = new Proizvod();
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
			
			while(rs.next()){ 
				pr = new Proizvod();
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
	
	         try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNBYID);

				pstm.setString(1, id);
				pstm.execute();

				rs = pstm.getResultSet();

				if(rs.next()){ 
					pr = new Proizvod();
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

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pr; 
		}
	  
	
	   
	   public ArrayList<Proizvod> returnByVrsta(String vrsta){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
			Proizvod pr = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNBYVRSTA);

				pstm.setString(1, vrsta);
				pstm.execute();

				rs = pstm.getResultSet();

				while(rs.next()){ 
					pr = new Proizvod();
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
					lo.add(pr);
				}
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
	   
	   public void insertProizvod(Proizvod pr){
		   Connection con = null;
		   PreparedStatement pstm = null;
		   ResultSet rs = null;
		   
		   try {
				con = ds.getConnection();
				pstm = con.prepareStatement(INSERTPR);

				pstm.setString(1, pr.getVrsta());
				pstm.setString(2, pr.getProizvodjac());
				pstm.setString(3, pr.getModel());
				pstm.setBigDecimal(4, pr.getCena());
				pstm.setInt(5, pr.getGarancija());
				pstm.setString(6, pr.getSlika());
				pstm.setByte(7, pr.getAkcija());
				pstm.setString(8, pr.getTip());
				pstm.setString(9, pr.getKapacitet());
				pstm.setString(10, pr.getSocket());
				pstm.setBigDecimal(11, pr.getDijagonala());
				pstm.setString(12, pr.getTakt());
				pstm.execute();

				rs = pstm.getResultSet();

				
			} catch (SQLException e) {
				e.printStackTrace();
			}try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   
	   }
	  
}
