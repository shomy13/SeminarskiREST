package rs.telnet.projekat.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Korisnk {
	
	private int id;
	private String ime;
	private String prezime;
	private String email;
	private String pass;
	private Byte admin;
	
	public Korisnk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Korisnk(int id, String ime, String prezime, String email, String pass, Byte admin) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.pass = pass;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Byte getAdmin() {
		return admin;
	}

	public void setAdmin(Byte admin) {
		this.admin = admin;
	}
	
	
	
	

	
	
	
	

}
