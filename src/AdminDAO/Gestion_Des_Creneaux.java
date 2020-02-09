package AdminDAO;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Creneaux;

import ModelDAO.Creneaux_Model;

import net.proteanit.sql.DbUtils;

import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Color;

public class Gestion_Des_Creneaux {

	JFrame frmGestionDesCreneaux;
	private JTextField id_cr;
	private JTextField H_debut;
	private JTextField H_fin;
	private JTextField M_debut;
	private JTable table;
	private JTextField M_fin;
	private JTextField id_medecin;
	private JTextField version;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Des_Creneaux window = new Gestion_Des_Creneaux();
					window.frmGestionDesCreneaux.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Gestion_Des_Creneaux() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesCreneaux = new JFrame();
		frmGestionDesCreneaux.setTitle("Gestion Des  Creneaux");
		frmGestionDesCreneaux.setBounds(100, 100, 790, 581);
		frmGestionDesCreneaux.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesCreneaux.getContentPane().setLayout(null);
		
		JLabel lblIdcreneaux_2 = new JLabel("Id_Creneaux  :");
		lblIdcreneaux_2.setBounds(25, 94, 107, 32);
		frmGestionDesCreneaux.getContentPane().add(lblIdcreneaux_2);
		
		id_cr = new JTextField();
		id_cr.setColumns(10);
		id_cr.setBounds(122, 97, 122, 26);
		frmGestionDesCreneaux.getContentPane().add(id_cr);
		
		H_debut = new JTextField();
		H_debut.setColumns(10);
		H_debut.setBounds(122, 137, 122, 26);
		frmGestionDesCreneaux.getContentPane().add(H_debut);
		
		JLabel lblIdcreneaux = new JLabel("H_debut :\r\n");
		lblIdcreneaux.setBounds(25, 133, 87, 32);
		frmGestionDesCreneaux.getContentPane().add(lblIdcreneaux);
		
		JLabel lblJour = new JLabel("H_Fin :");
		lblJour.setBounds(25, 174, 107, 32);
		frmGestionDesCreneaux.getContentPane().add(lblJour);
		
		H_fin = new JTextField();
		H_fin.setColumns(10);
		H_fin.setBounds(122, 174, 122, 26);
		frmGestionDesCreneaux.getContentPane().add(H_fin);
		
		JButton button = new JButton("Modifier");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_cre=Integer.parseInt(id_cr.getText());
				int ver =Integer.parseInt(version.getText());
				int h_debut=Integer.parseInt(H_debut.getText());
				int m_debut=Integer.parseInt(M_debut.getText());
				int h_fin=Integer.parseInt(H_fin.getText());
				int m_fin=Integer.parseInt(M_fin.getText());
				int id_med = Integer.parseInt(id_medecin.getText());
				String query="update creneaux set version = '"+ver+"' ,h_debut ='"+h_debut+"' , m_debut='"+m_debut+"',h_fin ='"+h_fin+"',m_fin='"+m_fin+"',id_med='"+id_med+"' where id_cr ='"+id_cre+"'";
				Creneaux_Model rm=new Creneaux_Model();
				try {
					rm.Modifier(query);
					JOptionPane.showMessageDialog(null,"Le Creneau a été Modifié Avec Succés");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Actualiser.png"));
		button.setBounds(581, 215, 152, 48);
		frmGestionDesCreneaux.getContentPane().add(button);
		
		JButton button_1 = new JButton("Afficher");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creneaux_Model rv=new Creneaux_Model();
				ResultSet rs=null;
				String query="select * from creneaux";
				try {
					rs=rv.Afficher(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\afficher.png"));
		button_1.setBounds(50, 215, 152, 48);
		frmGestionDesCreneaux.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Chercher");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creneaux_Model rv=new Creneaux_Model();
				String query="select * from creneaux where id_cr =?";
				ResultSet s=null;
				int id_cre=Integer.parseInt(id_cr.getText());
				try
				{
					s=rv.Chercher(query, id_cre);
					table.setModel(DbUtils.resultSetToTableModel(s));
	
				}catch(	SQLException e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Rechercher.png"));
		button_2.setBounds(403, 215, 152, 48);
		frmGestionDesCreneaux.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Supprimer");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creneaux_Model rv=new Creneaux_Model();
				int i=Integer.parseInt(id_cr.getText());
				String query ="delete from creneaux where id_cr =?";
				try {
					rv.Supprimer(query,i);
					JOptionPane.showMessageDialog(null,"Créneaux Supprimé Avec Succés");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Une Erreur Est Survenu");
					e1.printStackTrace();
				}
				
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Delete.png"));
		button_3.setBounds(225, 215, 152, 48);
		frmGestionDesCreneaux.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Ajouter");
		
		button_4.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Ajouter.png"));
		button_4.setBounds(581, 158, 152, 48);
		frmGestionDesCreneaux.getContentPane().add(button_4);
		
		M_debut = new JTextField();
		M_debut.setColumns(10);
		M_debut.setBounds(349, 97, 122, 26);
		frmGestionDesCreneaux.getContentPane().add(M_debut);
		
		JLabel lblIdclient = new JLabel("M_debut :");
		lblIdclient.setBounds(264, 94, 107, 32);
		frmGestionDesCreneaux.getContentPane().add(lblIdclient);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Jour", "Id_Clinet", "Id_Creneaux", "New column", "New column", "New column"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 293, 743, 166);
		frmGestionDesCreneaux.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Admin c=new Login_Admin();
				c.frmEspaceadmin.setVisible(true);
				frmGestionDesCreneaux.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\precedent.jpg"));
		btnNewButton.setBounds(710, 11, 43, 43);
		frmGestionDesCreneaux.getContentPane().add(btnNewButton);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.frmLogin.setVisible(true);
				frmGestionDesCreneaux.setVisible(false);
			}
		});
		btnDeconnexion.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\deconnexion.png"));
		btnDeconnexion.setBounds(25, 482, 177, 48);
		frmGestionDesCreneaux.getContentPane().add(btnDeconnexion);
		
		JLabel lblGestionDesRendez = new JLabel("Gestion Des Creneaux :");
		lblGestionDesRendez.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\creneaux.PNG"));
		lblGestionDesRendez.setForeground(new Color(135, 206, 235));
		lblGestionDesRendez.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGestionDesRendez.setBounds(169, 11, 410, 52);
		frmGestionDesCreneaux.getContentPane().add(lblGestionDesRendez);
		
		JLabel lblIdrv = new JLabel("Id_Creneau");
		lblIdrv.setBackground(Color.WHITE);
		lblIdrv.setBounds(10, 263, 102, 26);
		frmGestionDesCreneaux.getContentPane().add(lblIdrv);
		
		JLabel lblJour_1 = new JLabel("Version");
		lblJour_1.setBackground(Color.WHITE);
		lblJour_1.setBounds(123, 263, 93, 26);
		frmGestionDesCreneaux.getContentPane().add(lblJour_1);
		
		JLabel ll = new JLabel("M_Fin  :");
		ll.setBounds(264, 134, 107, 32);
		frmGestionDesCreneaux.getContentPane().add(ll);
		
		M_fin = new JTextField();
		M_fin.setColumns(10);
		M_fin.setBounds(349, 140, 122, 26);
		frmGestionDesCreneaux.getContentPane().add(M_fin);
		
		id_medecin = new JTextField();
		id_medecin.setColumns(10);
		id_medecin.setBounds(611, 100, 122, 26);
		frmGestionDesCreneaux.getContentPane().add(id_medecin);
		
		JLabel lblId = new JLabel("Id_Medecin:");
		lblId.setBounds(511, 94, 107, 32);
		frmGestionDesCreneaux.getContentPane().add(lblId);
		
		JLabel lblVersion = new JLabel("Version  :");
		lblVersion.setBounds(264, 174, 107, 32);
		frmGestionDesCreneaux.getContentPane().add(lblVersion);
		
		version = new JTextField();
		version.setColumns(10);
		version.setBounds(349, 180, 122, 26);
		frmGestionDesCreneaux.getContentPane().add(version);
		
		JLabel lblHdebut = new JLabel("H_debut");
		lblHdebut.setBackground(Color.WHITE);
		lblHdebut.setBounds(225, 263, 93, 26);
		frmGestionDesCreneaux.getContentPane().add(lblHdebut);
		
		JLabel lblMdebut_1 = new JLabel("M_debut");
		lblMdebut_1.setBackground(Color.WHITE);
		lblMdebut_1.setBounds(332, 263, 93, 26);
		frmGestionDesCreneaux.getContentPane().add(lblMdebut_1);
		
		JLabel lblMdebut = new JLabel("H_fin");
		lblMdebut.setBackground(Color.WHITE);
		lblMdebut.setBounds(447, 263, 93, 26);
		frmGestionDesCreneaux.getContentPane().add(lblMdebut);
		
		JLabel lblMfin = new JLabel("M_fin");
		lblMfin.setBackground(Color.WHITE);
		lblMfin.setBounds(550, 263, 93, 26);
		frmGestionDesCreneaux.getContentPane().add(lblMfin);
		
		JLabel lblIdmedecin = new JLabel("Id_Medecin");
		lblIdmedecin.setBackground(Color.WHITE);
		lblIdmedecin.setBounds(653, 263, 93, 26);
		frmGestionDesCreneaux.getContentPane().add(lblIdmedecin);
	
	//button ajouter :
	button_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String query ="insert into creneaux values (?,?,?,?,?,?,?)";
			try {
				int id_cre=Integer.parseInt(id_cr.getText());
				int ver =Integer.parseInt(version.getText());
				int h_debut=Integer.parseInt(H_debut.getText());
				int m_debut=Integer.parseInt(M_debut.getText());
				int h_fin=Integer.parseInt(H_fin.getText());
				int m_fin=Integer.parseInt(M_fin.getText());
				int id_med = Integer.parseInt(id_medecin.getText());
				Creneaux c=new Creneaux(id_cre,ver,h_debut,m_debut,h_fin,m_fin,id_med);
				Creneaux_Model cr=new Creneaux_Model();
				cr.Ajouter(query, c);
				JOptionPane.showMessageDialog(null,"Créneau Bien Ajouté ");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null,"Une Erreur Est survenu  ");
				e1.printStackTrace();
			}
			
			
		}
	});
}	
}
