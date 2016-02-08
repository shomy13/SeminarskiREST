package rs.telnet.projekat.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import rs.telnet.projekat.model.Admin;
public class DAOAdmin {
	  private DataSource ds;
	  
	  private static String EXISTADMIN = "SELECT * FROM admin where korisnickoime = ? and sifra=?";
	  private static String UPDATEUSER = "UPDATE admin SET sifra = ? WHERE korisnickoime = ?";
	  
	  public DAOAdmin(){
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
	  
	  public boolean existAdmin(String korisnickoime, String sifra){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
			Admin admin = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(EXISTADMIN);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, korisnickoime);
				pstm.setString(2, sifra);
				pstm.execute();

	//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
					admin = new Admin();
					admin.setId(rs.getInt("id"));
					admin.setKorisnickoime(rs.getString("korisnickoime"));
					admin.setSifra(rs.getString("sifra"));
					
					
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
	  
	  public void updateAdmin(String pass, String user ){
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
		}
	  
}
