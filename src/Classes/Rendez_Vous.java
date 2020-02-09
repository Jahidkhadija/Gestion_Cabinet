package Classes;


public class Rendez_Vous {
	private int id_rv;
	private String jour;
	private int id_cl;
	private int id_cre;
	public Rendez_Vous(int id_rv, String jour, int id_cl,int id_cre) {
		
		this.id_rv = id_rv;
		this.jour = jour;
		this.id_cl = id_cl;
		this.id_cre=id_cre;
	}
	public int getId_cre() {
		return id_cre;
	}
	public void setId_cre(int id_cre) {
		this.id_cre = id_cre;
	}
	public int getId_rv() {
		return id_rv;
	}
	public void setId_rv(int id_rv) {
		this.id_rv = id_rv;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public int getId_cl() {
		return id_cl;
	}
	public void setId_cl(int id_cl) {
		this.id_cl = id_cl;
	}
	
	
}
