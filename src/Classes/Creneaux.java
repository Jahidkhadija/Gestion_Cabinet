package Classes;

public class Creneaux {
	private int id;
	private int version;
	private int h_debut;
	private int m_debut;
	private int h_fin;
	private int m_fin;
	private int id_med;
	public Creneaux(int id, int version, int h_debut, int m_debut, int h_fin, int m_fin, int id_med) {
		this.id = id;
		this.version = version;
		this.h_debut = h_debut;
		this.m_debut = m_debut;
		this.h_fin = h_fin;
		this.m_fin = m_fin;
		this.id_med = id_med;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getH_debut() {
		return h_debut;
	}
	public void setH_debut(int h_debut) {
		this.h_debut = h_debut;
	}
	public int getM_debut() {
		return m_debut;
	}
	public void setM_debut(int m_debut) {
		this.m_debut = m_debut;
	}
	public int getH_fin() {
		return h_fin;
	}
	public void setH_fin(int h_fin) {
		this.h_fin = h_fin;
	}
	public int getM_fin() {
		return m_fin;
	}
	public void setM_fin(int m_fin) {
		this.m_fin = m_fin;
	}
	public int getId_med() {
		return id_med;
	}
	public void setId_med(int id_med) {
		this.id_med = id_med;
	}

	
}
