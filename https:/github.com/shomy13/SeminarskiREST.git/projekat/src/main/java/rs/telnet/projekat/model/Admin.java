package rs.telnet.projekat.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Admin {
	
	private int id;
	private String user;
	private String pass;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

	
	
	
	

}
