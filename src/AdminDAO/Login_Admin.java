package AdminDAO;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Classes.Client;
import DAO.Connect;
import ModelDAO.Client_Model;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class Login_Admin {

	JFrame frmEspaceadmin;
	public JFrame getFrame() {
		return frmEspaceadmin;
	}

	public void setFrame(JFrame frame) {
		this.frmEspaceadmin = frame;
	}

	private JTextField Id_cl;
	private JTextField nom_c;
	private JTextField ver_c;
	private JTextField prenom_c;
	private JTextField titre_c;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Admin window = new Login_Admin();
					window.frmEspaceadmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Statement st = null;
		Connect con = null;
		Client_Model mc=new Client_Model(con,st);
		
		frmEspaceadmin = new JFrame();
		frmEspaceadmin.setTitle("Espace_Admin");
		frmEspaceadmin.setBounds(100, 100, 1000, 585);
		frmEspaceadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEspaceadmin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 293, 546);
		frmEspaceadmin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminInterface = new JLabel("Admin Interface");
		lblAdminInterface.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAdminInterface.setBounds(65, 92, 162, 43);
		panel.add(lblAdminInterface);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(292, 0, 692, 546);
		panel_1.setVisible(false);
		
		frmEspaceadmin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lb_medi = new JLabel("Id  :");
		lb_medi.setBounds(10, 141, 107, 32);
		panel_1.add(lb_medi);
		
		Id_cl = new JTextField();
		Id_cl.setBounds(82, 144, 122, 26);
		panel_1.add(Id_cl);
		Id_cl.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 180, 107, 32);
		panel_1.add(lblNom);
		
		nom_c = new JTextField();
		nom_c.setColumns(10);
		nom_c.setBounds(82, 183, 122, 26);
		panel_1.add(nom_c);
		
		JLabel lblVersion = new JLabel("Version :");
		lblVersion.setBounds(223, 141, 107, 32);
		panel_1.add(lblVersion);
		
		ver_c = new JTextField();
		ver_c.setColumns(10);
		ver_c.setBounds(295, 144, 122, 26);
		panel_1.add(ver_c);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(223, 180, 107, 32);
		panel_1.add(lblPrenom);
		
		prenom_c = new JTextField();
		prenom_c.setColumns(10);
		prenom_c.setBounds(295, 183, 122, 26);
		panel_1.add(prenom_c);
		
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setBounds(448, 141, 107, 32);
		panel_1.add(lblTitre);
		
		titre_c = new JTextField();
		titre_c.setColumns(10);
		titre_c.setBounds(520, 144, 122, 26);
		panel_1.add(titre_c);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(Id_cl.getText());
				int version =Integer.parseInt(ver_c.getText());
				String titre =titre_c.getText();
				String nom=nom_c.getText();
				String prenom=prenom_c.getText();
				Client cl=new Client(id,version,titre,nom,prenom);
				String query="insert into client values ( ? , ? , ? , ?, ? )";
					try {
						mc.Ajouter(query, cl);
						JOptionPane.showMessageDialog(null,"Client Bien Inseré");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		ajouter.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Ajouter.png"));
		ajouter.setBounds(495, 180, 147, 48);
		panel_1.add(ajouter);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query ="delete from client where id_cl= ?";
				int id=Integer.parseInt(Id_cl.getText());
				try {
					mc.Supprimer(query, id);
					JOptionPane.showMessageDialog(null,"Client Bien Supprimer");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		supprimer.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Delete.png"));
		supprimer.setBounds(495, 239, 147, 48);
		panel_1.add(supprimer);
		
		JButton modifier = new JButton("Modifier");
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(Id_cl.getText());
				int version =Integer.parseInt(ver_c.getText());
				String titre =titre_c.getText();
				String nom=nom_c.getText();
				String prenom=prenom_c.getText();
				String query="update client set version = '"+version+"' , titre='"+titre+"' , nom='"+nom+"' , prenom='"+prenom+"'where id_cl = '"+id+"'";
				try {
					mc.Modifier(query);
					JOptionPane.showMessageDialog(null,"Client bien modifié");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Erreur 3awd");
				}
			}
		});
		modifier.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Actualiser.png"));
		modifier.setBounds(44, 239, 132, 48);
		panel_1.add(modifier);
		
		JButton chercher = new JButton("Chercher");
		chercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(Id_cl.getText());
				String query ="select * from client where id_cl =?";
				ResultSet s;
				try {
					s=mc.Rechercher(query,id);
					table.setModel(DbUtils.resultSetToTableModel(s));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		chercher.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Rechercher.png"));
		chercher.setBounds(349, 239, 132, 48);
		panel_1.add(chercher);
		JButton afficher = new JButton("Afficher");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query ="select * from client";
				ResultSet s;
				try {
					s=mc.Afficher(query);
					table.setModel(DbUtils.resultSetToTableModel(s));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\afficher.png"));
		afficher.setBounds(196, 239, 132, 48);
		panel_1.add(afficher);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(29, 333, 631, 190);
		panel_1.add(table);
		table.setModel(new DefaultTableModel(
			new String[] {
				"Id_Client", "Version", "Titre", "Nom", "Prenom"
			}, 0
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(652, 0, 40, 43);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\precedent.jpg"));
		
		JLabel lblGestionDesClients = new JLabel("Gestion Des Clients :");
		lblGestionDesClients.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\client.jpg"));
		lblGestionDesClients.setForeground(new Color(135, 206, 235));
		lblGestionDesClients.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGestionDesClients.setBounds(158, 33, 410, 74);
		panel_1.add(lblGestionDesClients);
		
		JLabel lblIdclient = new JLabel("Id_Client");
		lblIdclient.setBackground(Color.WHITE);
		lblIdclient.setBounds(29, 298, 132, 26);
		panel_1.add(lblIdclient);
		
		JLabel label_1 = new JLabel("Version");
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(159, 298, 132, 26);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Titre");
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(297, 298, 132, 26);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Nom");
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(435, 298, 132, 26);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Prenom");
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(573, 298, 132, 26);
		panel_1.add(label_4);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		
		
		
		
		JButton btnNewButton = new JButton("Gestion Des Clients          ");

		btnNewButton.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\client.jpg"));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton.setBounds(0, 146, 293, 63);
		panel.add(btnNewButton);
		
		JButton btnGestionDesRendezvous = new JButton("Gestion Des Rendez-Vous\r\n");
		btnGestionDesRendezvous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestin_Des_Rendez_Vous c=new Gestin_Des_Rendez_Vous();
				c.frmGestionDesRendez.setVisible(true);
				frmEspaceadmin.setVisible(false);
				frmEspaceadmin.setTitle("Gestion Des Rendez Vous");
			}
		});
		btnGestionDesRendezvous.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\rv.png"));
		btnGestionDesRendezvous.setFont(new Font("Calibri", Font.BOLD, 16));
		btnGestionDesRendezvous.setBounds(0, 205, 293, 63);
		panel.add(btnGestionDesRendezvous);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton)
				{
					panel_1.setVisible(true);
					
				}
			}
		});
		
		JButton btnGestionDesMedicaments = new JButton("Gestion Des Medicaments");
		btnGestionDesMedicaments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnGestionDesMedicaments)
				{
					Gestion_Medicament c=new Gestion_Medicament();
					c.frmGestionDesMedicaments.setVisible(true);
					frmEspaceadmin.setVisible(false);
					frmEspaceadmin.setTitle("Gestion_Des Clients");
					
				}
			}
		});
		btnGestionDesMedicaments.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\medicament.png"));
		btnGestionDesMedicaments.setFont(new Font("Calibri", Font.BOLD, 16));
		btnGestionDesMedicaments.setBounds(0, 264, 293, 63);
		panel.add(btnGestionDesMedicaments);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.frmLogin.setVisible(true);
				frmEspaceadmin.setVisible(false);

			}
		});
		btnDeconnexion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeconnexion.setBackground(Color.WHITE);
		btnDeconnexion.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\deconnexion.png"));
		btnDeconnexion.setBounds(0, 503, 152, 43);
		panel.add(btnDeconnexion);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\doc.png"));
		btnNewButton_2.setBounds(109, 17, 53, 63);
		panel.add(btnNewButton_2);
		
		JButton btnGestionDesCreneaux = new JButton("Gestion Des Creneaux      ");
		btnGestionDesCreneaux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion_Des_Creneaux c=new Gestion_Des_Creneaux();
				c.frmGestionDesCreneaux.setVisible(true);
				frmEspaceadmin.setVisible(false);
			}
		});
		btnGestionDesCreneaux.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\creneaux.PNG"));
		btnGestionDesCreneaux.setFont(new Font("Calibri", Font.BOLD, 16));
		btnGestionDesCreneaux.setBounds(0, 324, 293, 63);
		panel.add(btnGestionDesCreneaux);
		
		
		
		
	}
}
