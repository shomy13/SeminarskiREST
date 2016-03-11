package rs.telnet.projekat.authentication;

public class Token {
	
	private String token;
	private Byte admin;
	private int id;
	Token(){
		
	}
	
	

	public Token(String token, Byte admin, int id) {
		super();
		this.token = token;
		this.admin = admin;
		this.id = id;
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



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
