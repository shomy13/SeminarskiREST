package rs.telnet.projekat.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import rs.telnet.projekat.model.Korisnk;
public class DAOKorisnik {
	  private DataSource ds;
	  
	  private static String EXISTADMIN = "SELECT * FROM korisnik where email= ? and pass=?";
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
	  
	  public boolean existAdmin(String email, String pass){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
			Korisnk k = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(EXISTADMIN);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, email);
				pstm.setString(2, pass);
				pstm.execute();

	//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
					k = new Korisnk();
					k.setId(rs.getInt("id"));
					k.setIme(rs.getString("ime"));
					k.setPrezime(rs.getString("prezime"));
					k.setEmail(rs.getString("email"));
					k.setPass(rs.getString("pass"));
					k.setAdmin(rs.getByte("admin"));
					
					
					return true;
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
			return false; 
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
