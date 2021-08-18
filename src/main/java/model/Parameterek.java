package model;

public class Parameterek  {
	private String tipus;
	private String nev;
	private int min_magassag;
	private int max_magassag;
	private int min_szelesseg;
	private int max_szelesseg;
	private String expozicio;
	private String talajtipus;
	private String min_viragzas;
	private String max_viragzas;
	private String virag_szine;
	private String extra_szin;
	private int min_ultetesi_zona;
	private int max_ultetesi_zona;
	private String toxicias;
	private String PH;
	private int id;
	String[] novenyek = {"HIBA","Indás fü", "Piros gyüszüvirág"};
	
	
	
	


	public String[] getNovenyek() {
		return novenyek;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public int getMin_magassag() {
		return min_magassag;
	}
	public void setMin_magassag(int min_magassag) {
		this.min_magassag = min_magassag;
	}
	public int getMax_magassag() {
		return max_magassag;
	}
	public void setMax_magassag(int max_magassag) {
		this.max_magassag = max_magassag;
	}
	public int getMin_szelesseg() {
		return min_szelesseg;
	}
	public void setMin_szelesseg(int min_szelesseg) {
		this.min_szelesseg = min_szelesseg;
	}
	public int getMax_szelesseg() {
		return max_szelesseg;
	}
	public void setMax_szelesseg(int max_szelesseg) {
		this.max_szelesseg = max_szelesseg;
	}
	public String getExpozicio() {
		return expozicio;
	}
	public void setExpozicio(String expozicio) {
		this.expozicio = expozicio;
	}
	public String getTalajtipus() {
		return talajtipus;
	}
	public void setTalajtipus(String talajtipus) {
		this.talajtipus = talajtipus;
	}
	public String getMin_viragzas() {
		return min_viragzas;
	}
	public void setMin_viragzas(String min_viragzas) {
		this.min_viragzas = min_viragzas;
	}
	public String getMax_viragzas() {
		return max_viragzas;
	}
	public void setMax_viragzas(String max_viragzas) {
		this.max_viragzas = max_viragzas;
	}
	public String getVirag_szine() {
		return virag_szine;
	}
	public void setVirag_szine(String virag_szine) {
		this.virag_szine = virag_szine;
	}
	public String getExtra_szin() {
		return extra_szin;
	}
	public void setExtra_szin(String extra_szin) {
		this.extra_szin = extra_szin;
	}
	public int getMin_ultetesi_zona() {
		return min_ultetesi_zona;
	}
	public void setMin_ultetesi_zona(int min_ultetesi_zona) {
		this.min_ultetesi_zona = min_ultetesi_zona;
	}
	public int getMax_ultetesi_zona() {
		return max_ultetesi_zona;
	}
	public void setMax_ultetesi_zona(int max_ultetesi_zona) {
		this.max_ultetesi_zona = max_ultetesi_zona;
	}
	public String getToxicias() {
		return toxicias;
	}
	public void setToxicias(String toxicias) {
		this.toxicias = toxicias;
	}
	public String getPH() {
		return PH;
	}
	public void setPH(String pH) {
		PH = pH;
	}

}