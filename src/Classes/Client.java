package Classes;

public class Client {
	private int id_cl;
	private int version;
	private String titre;
	private String nom;
	private String prenom;
	public Client (int id_cl,int version,String titre,String nom,String prenom)
	{
		this.id_cl=id_cl;
		this.version=version;
		this.titre=titre;
		this.nom=nom;
		this.prenom=prenom;
	}
	public int getId_cl() {
		return id_cl;
	}
	public void setId_cl(int id_cl) {
		this.id_cl = id_cl;
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
	
}
