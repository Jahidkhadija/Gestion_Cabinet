package AdminDAO;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import Classes.Medecin;
import ModelDAO.Medecin_Model;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.Font;

public class Gestion_Medicament {

	JFrame frmGestionDesMedicaments;
	private JTextField Id_med;
	private JTextField nom_m;
	private JTextField version_m;
	private JTextField prenom_m;
	private JTextField titre_m;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Medicament window = new Gestion_Medicament();
					window.frmGestionDesMedicaments.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestion_Medicament() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesMedicaments = new JFrame();
		frmGestionDesMedicaments.setTitle("Gestion Des Medicaments");
		frmGestionDesMedicaments.setBounds(100, 100, 734, 581);
		frmGestionDesMedicaments.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesMedicaments.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Id  :");
		label.setBounds(25, 74, 107, 32);
		frmGestionDesMedicaments.getContentPane().add(label);
		
		Id_med = new JTextField();
		Id_med.setColumns(10);
		Id_med.setBounds(97, 77, 122, 26);
		frmGestionDesMedicaments.getContentPane().add(Id_med);
		
		nom_m = new JTextField();
		nom_m.setColumns(10);
		nom_m.setBounds(97, 116, 122, 26);
		frmGestionDesMedicaments.getContentPane().add(nom_m);
		
		JLabel label_1 = new JLabel("Nom :");
		label_1.setBounds(25, 113, 107, 32);
		frmGestionDesMedicaments.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Version :");
		label_2.setBounds(238, 74, 107, 32);
		frmGestionDesMedicaments.getContentPane().add(label_2);
		
		version_m = new JTextField();
		version_m.setColumns(10);
		version_m.setBounds(310, 77, 122, 26);
		frmGestionDesMedicaments.getContentPane().add(version_m);
		
		prenom_m = new JTextField();
		prenom_m.setColumns(10);
		prenom_m.setBounds(310, 116, 122, 26);
		frmGestionDesMedicaments.getContentPane().add(prenom_m);
		
		JLabel label_3 = new JLabel("Prenom :");
		label_3.setBounds(238, 113, 107, 32);
		frmGestionDesMedicaments.getContentPane().add(label_3);
		
		JButton button = new JButton("Modifier");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(Id_med.getText());
				int version =Integer.parseInt(version_m.getText());
				String titre =titre_m.getText();
				Medecin_Model mc=new Medecin_Model();
				String nom=nom_m.getText();
				String prenom=prenom_m.getText();
				String query="update medecins set version = '"+version+"' , titre='"+titre+"' , nom='"+nom+"' , prenom='"+prenom+"'where id_med = '"+id+"'";
				try {
					mc.Modifier(query);
					JOptionPane.showMessageDialog(null,"Medecin bien modifié");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Erreur 3awd");
				}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Actualiser.png"));
		button.setBounds(59, 172, 132, 48);
		frmGestionDesMedicaments.getContentPane().add(button);
		
		JButton button_1 = new JButton("Afficher");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medecin_Model mc=new Medecin_Model();
				String query ="select * from medecins";
				ResultSet s;
				try {
					s=mc.Afficher(query);
					table.setModel(DbUtils.resultSetToTableModel(s));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\afficher.png"));
		button_1.setBounds(211, 172, 132, 48);
		frmGestionDesMedicaments.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Chercher");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medecin_Model mc=new Medecin_Model();
				int id=Integer.parseInt(Id_med.getText());
				String query ="select * from medecins where id_med =?";
				ResultSet s;
				try {
					s=mc.Rechercher(query,id);
					table.setModel(DbUtils.resultSetToTableModel(s));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Rechercher.png"));
		button_2.setBounds(364, 172, 132, 48);
		frmGestionDesMedicaments.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Supprimer");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query ="delete from medecins where id_med= ?";
				Medecin_Model mc=new Medecin_Model();
				int id=Integer.parseInt(Id_med.getText());
				try {
					mc.Supprimer(query, id);
					JOptionPane.showMessageDialog(null,"Medecin Bien Supprimer");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Delete.png"));
		button_3.setBounds(510, 172, 147, 48);
		frmGestionDesMedicaments.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Ajouter");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medecin_Model mc=new Medecin_Model();
				int id=Integer.parseInt(Id_med.getText());
				int version =Integer.parseInt(version_m.getText());
				String titre =titre_m.getText();
				String nom=nom_m.getText();
				String prenom=prenom_m.getText();
				Medecin m=new Medecin(id,version,titre,nom,prenom);
				String query="insert into medecins values ( ? , ? , ? , ?, ? )";
					try {
						mc.Ajouter(query, m);
						JOptionPane.showMessageDialog(null,"Medecin Bien Inseré");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		button_4.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Ajouter.png"));
		button_4.setBounds(510, 113, 147, 48);
		frmGestionDesMedicaments.getContentPane().add(button_4);
		
		titre_m = new JTextField();
		titre_m.setColumns(10);
		titre_m.setBounds(535, 77, 122, 26);
		frmGestionDesMedicaments.getContentPane().add(titre_m);
		
		JLabel label_4 = new JLabel("Titre :");
		label_4.setBounds(463, 74, 107, 32);
		frmGestionDesMedicaments.getContentPane().add(label_4);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Id_Medecins", "Version", "Titre", "Nom", "Prenom"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, Object.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBounds(26, 258, 682, 213);
		frmGestionDesMedicaments.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Admin c=new Login_Admin();
				c.frmEspaceadmin.setVisible(true);
				frmGestionDesMedicaments.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\precedent.jpg"));
		btnNewButton.setBounds(675, 0, 43, 43);
		frmGestionDesMedicaments.getContentPane().add(btnNewButton);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBackground(new Color(255, 255, 255));
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.frmLogin.setVisible(true);
				frmGestionDesMedicaments.setVisible(false);
			}
		});
		btnDeconnexion.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\deconnexion.png"));
		btnDeconnexion.setBounds(14, 482, 177, 48);
		frmGestionDesMedicaments.getContentPane().add(btnDeconnexion);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Medicaments :");
		lblNewLabel.setForeground(new Color(135, 206, 235));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\medicament.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(119, 11, 410, 52);
		frmGestionDesMedicaments.getContentPane().add(lblNewLabel);
		
		JLabel lblIdmedecin = new JLabel("Id_Medecin");
		lblIdmedecin.setBackground(Color.WHITE);
		lblIdmedecin.setBounds(32, 231, 132, 26);
		frmGestionDesMedicaments.getContentPane().add(lblIdmedecin);
		
		JLabel lblVersion = new JLabel("Version");
		lblVersion.setBackground(Color.WHITE);
		lblVersion.setBounds(162, 231, 132, 26);
		frmGestionDesMedicaments.getContentPane().add(lblVersion);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBackground(Color.WHITE);
		lblTitre.setBounds(300, 231, 132, 26);
		frmGestionDesMedicaments.getContentPane().add(lblTitre);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBackground(Color.WHITE);
		lblNom.setBounds(438, 231, 132, 26);
		frmGestionDesMedicaments.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBackground(Color.WHITE);
		lblPrenom.setBounds(576, 231, 132, 26);
		frmGestionDesMedicaments.getContentPane().add(lblPrenom);
	}
}
