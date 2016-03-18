package rs.telnet.projekat.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import rs.telnet.projekat.model.Korisnk;
import rs.telnet.projekat.model.Proizvod;

public class DAOKorisnik {
	  private DataSource ds;
	  
	  private static String EXISTUSER = "SELECT * FROM korisnik where email= ? and pass=?";
	  private static String RETURNBYEMAIL = "SELECT * FROM korisnik where email = ?";
	  private static String INSERTUSER = "INSERT INTO korisnik(ime, prezime, email, pass) VALUES(?,?,?,?)";
	  private static String INSERTADMIN = "INSERT INTO korisnik(ime, prezime, email, pass, admin) VALUES(?,?,?,?,?)";
	  private static String RETURNBYID = "SELECT * FROM korisnik where id = ?";
	  private static String RETURNALL = "SELECT * FROM korisnik";
	  private static String UPDATEUSER = "UPDATE admin SET pass = ? WHERE user = ?";
	  
	  public DAOKorisnik(){
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
	  
	  public Korisnk existUser(String email, String pass){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
		
			Korisnk k = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(EXISTUSER);

				pstm.setString(1, email);
				pstm.setString(2, pass);
				pstm.execute();


				rs = pstm.getResultSet();

				if(rs.next()){ 
					k = new Korisnk();
					k.setId(rs.getInt("id"));
					k.setIme(rs.getString("ime"));
					k.setPrezime(rs.getString("prezime"));
					k.setEmail(rs.getString("email"));
					k.setPass(rs.getString("pass"));
					k.setAdmin(rs.getByte("admin"));
					
					
					
				}
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return k; 
		}
	  
	  public Boolean returnByEmail(String email){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
		
			Korisnk k = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNBYEMAIL);

			
				pstm.setString(1, email);
				pstm.execute();


				rs = pstm.getResultSet();

				if(rs.next()){ 
					k = new Korisnk();
					k.setId(rs.getInt("id"));
					k.setIme(rs.getString("ime"));
					k.setPrezime(rs.getString("prezime"));
					k.setEmail(rs.getString("email"));
					k.setPass(rs.getString("pass"));
					k.setAdmin(rs.getByte("admin"));
					
					
					return true;	
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
	  
	  public void insertKorisnik(Korisnk k){
		   Connection con = null;
		   PreparedStatement pstm = null;
		   ResultSet rs = null;
		   
		   try {
				con = ds.getConnection();
				pstm = con.prepareStatement(INSERTUSER);
				pstm.setString(1, k.getIme());
				pstm.setString(2, k.getPrezime());
				pstm.setString(3, k.getEmail());
				pstm.setString(4, k.getPass());
			
			
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
	  public void insertAdmin(Korisnk k){
		   Connection con = null;
		   PreparedStatement pstm = null;
		   ResultSet rs = null;
		   
		   try {
				con = ds.getConnection();
				pstm = con.prepareStatement(INSERTADMIN);
				pstm.setString(1, k.getIme());
				pstm.setString(2, k.getPrezime());
				pstm.setString(3, k.getEmail());
				pstm.setString(4, k.getPass());
				pstm.setByte(5, k.getAdmin());
			
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
	  
	  public Korisnk returnById(String id){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
		
		
			Korisnk k = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNBYID);

				
				pstm.setString(1, id);
				pstm.execute();

				rs = pstm.getResultSet();

				if(rs.next()){ 
					k = new Korisnk();
					k.setId(rs.getInt("id"));
					k.setIme(rs.getString("ime"));
					k.setPrezime(rs.getString("prezime"));
					k.setEmail(rs.getString("email"));
					k.setPass(rs.getString("pass"));
					k.setAdmin(rs.getByte("admin"));
					
					
						
				}
				
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return k; 
		}
	  
	  public ArrayList<Korisnk> returnAll(){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			ArrayList<Korisnk> li = new ArrayList<Korisnk>();
		
			Korisnk k = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(RETURNALL);

				
	
				pstm.execute();

	
				rs = pstm.getResultSet();

				while(rs.next()){ 
					k = new Korisnk();
					k.setId(rs.getInt("id"));
					k.setIme(rs.getString("ime"));
					k.setPrezime(rs.getString("prezime"));
					k.setEmail(rs.getString("email"));
					k.setPass(rs.getString("pass"));
					k.setAdmin(rs.getByte("admin"));
					
					li.add(k);
						
				}
				
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return li; 
		}
	/*  public void updateAdmin(String pass, String user ){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 

			try {
				con = ds.getConnection();
				pstm = con.prepareStatement(UPDATEUSER);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, pass);
				pstm.setString(2, user);
				pstm.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	  
}
