package rs.telnet.projekat.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Proizvod {
	
		private String vrsta;
		private String proizvodjac;
		private String model;
		private String slika;
		private String tip;
		private String kapacitet;
		private String socket;
		private String takt;
		private Byte akcija;
		private BigDecimal dijagonala;
		private BigDecimal cena;
		private int id;
		private int garancija;
		
		public Proizvod() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Proizvod(String vrsta, String proizvodjac, String model, String slika, String tip, String kapacitet,
				String socket, String takt, Byte akcija, BigDecimal dijagonala, BigDecimal cena, int id ,int garancija) {
			super();
			this.vrsta = vrsta;
			this.proizvodjac = proizvodjac;
			this.model = model;
			this.slika = slika;
			this.tip = tip;
			this.kapacitet = kapacitet;
			this.socket = socket;
			this.takt = takt;
			this.akcija = akcija;
			this.dijagonala = dijagonala;
			this.cena = cena;
			this.id = id;
			this.garancija = garancija;
		}

		public String getVrsta() {
			return vrsta;
		}

		public void setVrsta(String vrsta) {
			this.vrsta = vrsta;
		}

		public String getProizvodjac() {
			return proizvodjac;
		}

		public void setProizvodjac(String proizvodjac) {
			this.proizvodjac = proizvodjac;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getSlika() {
			return slika;
		}

		public void setSlika(String slika) {
			this.slika = slika;
		}

		public String getTip() {
			return tip;
		}

		public void setTip(String tip) {
			this.tip = tip;
		}

		public String getKapacitet() {
			return kapacitet;
		}

		public void setKapacitet(String kapacitet) {
			this.kapacitet = kapacitet;
		}

		public String getSocket() {
			return socket;
		}

		public void setSocket(String socket) {
			this.socket = socket;
		}

		public String getTakt() {
			return takt;
		}

		public void setTakt(String takt) {
			this.takt = takt;
		}

		public Byte getAkcija() {
			return akcija;
		}

		public void setAkcija(Byte akcija) {
			this.akcija = akcija;
		}

		public BigDecimal getDijagonala() {
			return dijagonala;
		}

		public void setDijagonala(BigDecimal dijagonala) {
			this.dijagonala = dijagonala;
		}

		public BigDecimal getCena() {
			return cena;
		}

		public void setCena(BigDecimal cena) {
			this.cena = cena;
		}

		public int getGarancija() {
			return garancija;
		}

		public void setGarancija(int garancija) {
			this.garancija = garancija;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		
}
