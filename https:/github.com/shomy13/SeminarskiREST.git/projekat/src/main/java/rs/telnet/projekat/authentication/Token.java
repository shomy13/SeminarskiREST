package rs.telnet.projekat.authentication;

public class Token {
	
	private String token;
	private Byte admin;
	Token(){
		
	}
	
	

	public Token(String token, Byte admin) {
		super();
		this.token = token;
		this.admin = admin;
	}



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	public Byte getAdmin() {
		return admin;
	}



	public void setAdmin(Byte admin) {
		this.admin = admin;
	}
	
	
	

}
