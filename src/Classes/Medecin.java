package Classes;

public class Medecin {
	private int id_med;
	private int version;
	public int getId_med() {
		return id_med;
	}
	public void setId_med(int id_med) {
		this.id_med = id_med;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	private String titre;
	private String nom;
	private String prenom;
	public Medecin(int id_med, int version, String titre, String nom, String prenom) {
		
		this.id_med = id_med;
		this.version = version;
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
}
