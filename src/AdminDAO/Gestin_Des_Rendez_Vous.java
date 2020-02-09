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


import Classes.Rendez_Vous;
import ModelDAO.Rv_Model;
import net.proteanit.sql.DbUtils;

import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Color;

public class Gestin_Des_Rendez_Vous {

	JFrame frmGestionDesRendez;
	private JTextField id;
	private JTextField id_cre;
	private JTextField jour;
	private JTextField id_cl;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestin_Des_Rendez_Vous window = new Gestin_Des_Rendez_Vous();
					window.frmGestionDesRendez.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestin_Des_Rendez_Vous() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesRendez = new JFrame();
		frmGestionDesRendez.setTitle("Gestion Des Rendez Vous");
		frmGestionDesRendez.setBounds(100, 100, 734, 581);
		frmGestionDesRendez.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesRendez.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Id  :");
		label.setBounds(25, 94, 107, 32);
		frmGestionDesRendez.getContentPane().add(label);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(122, 97, 122, 26);
		frmGestionDesRendez.getContentPane().add(id);
		
		id_cre = new JTextField();
		id_cre.setColumns(10);
		id_cre.setBounds(122, 137, 122, 26);
		frmGestionDesRendez.getContentPane().add(id_cre);
		
		JLabel lblIdcreneaux = new JLabel("Id_Creneaux :");
		lblIdcreneaux.setBounds(25, 133, 87, 32);
		frmGestionDesRendez.getContentPane().add(lblIdcreneaux);
		
		JLabel lblJour = new JLabel(" Jour :");
		lblJour.setBounds(25, 174, 107, 32);
		frmGestionDesRendez.getContentPane().add(lblJour);
		
		jour = new JTextField();
		jour.setColumns(10);
		jour.setBounds(122, 174, 122, 26);
		frmGestionDesRendez.getContentPane().add(jour);
		
		JButton button = new JButton("Modifier");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_rv=Integer.parseInt(id.getText());
				String jour_rv=jour.getText();
				int id_client=Integer.parseInt(id_cl.getText());
				int id_crene=Integer.parseInt(id_cre.getText());
				String query="update rv set jour = '"+jour_rv+"' ,id_cl ='"+id_client+"' , id_cre='"+id_crene+"' where id_rv ='"+id_rv+"'";
				Rv_Model rm=new Rv_Model();
				try {
					rm.Modifier(query);
					JOptionPane.showMessageDialog(null,"Le Rendez Vous a été Modifié Avec Succés");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Actualiser.png"));
		button.setBounds(505, 145, 152, 48);
		frmGestionDesRendez.getContentPane().add(button);
		
		JButton button_1 = new JButton("Afficher");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rv_Model rv=new Rv_Model();
				ResultSet rs=null;
				String query="select * from rv";
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
		button_1.setBounds(319, 145, 152, 48);
		frmGestionDesRendez.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Chercher");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rv_Model rv=new Rv_Model();
				String query="select * from rv where id_rv =?";
				ResultSet s=null;
				int id_rv=Integer.parseInt(id.getText());
				try
				{
					s=rv.Chercher(query, id_rv);
					table.setModel(DbUtils.resultSetToTableModel(s));
	
				}catch(	SQLException e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Rechercher.png"));
		button_2.setBounds(505, 204, 152, 48);
		frmGestionDesRendez.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Supprimer");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rv_Model rv=new Rv_Model();
				int i=Integer.parseInt(id.getText());
				String query ="delete from rv where id_rv =?";
				try {
					rv.Supprimer(query,i);
					JOptionPane.showMessageDialog(null,"Rendez vous Supprimé Avec Succés");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Une Erreur Est Survenu");
					e1.printStackTrace();
				}
				
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Delete.png"));
		button_3.setBounds(319, 204, 152, 48);
		frmGestionDesRendez.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Ajouter");
		
		button_4.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\Ajouter.png"));
		button_4.setBounds(505, 86, 152, 48);
		frmGestionDesRendez.getContentPane().add(button_4);
		
		id_cl = new JTextField();
		id_cl.setColumns(10);
		id_cl.setBounds(349, 97, 122, 26);
		frmGestionDesRendez.getContentPane().add(id_cl);
		
		JLabel lblIdclient = new JLabel("Id_Client :");
		lblIdclient.setBounds(264, 94, 107, 32);
		frmGestionDesRendez.getContentPane().add(lblIdclient);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Id", "Jour", "Id_Clinet", "Id_Creneaux"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 293, 697, 166);
		frmGestionDesRendez.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Admin c=new Login_Admin();
				c.frmEspaceadmin.setVisible(true);
				frmGestionDesRendez.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\precedent.jpg"));
		btnNewButton.setBounds(675, 0, 43, 43);
		frmGestionDesRendez.getContentPane().add(btnNewButton);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.frmLogin.setVisible(true);
				frmGestionDesRendez.setVisible(false);
			}
		});
		btnDeconnexion.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\deconnexion.png"));
		btnDeconnexion.setBounds(25, 482, 177, 48);
		frmGestionDesRendez.getContentPane().add(btnDeconnexion);
		
		JLabel lblGestionDesRendez = new JLabel("Gestion Des Rendez Vous :");
		lblGestionDesRendez.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\rv.png"));
		lblGestionDesRendez.setForeground(new Color(135, 206, 235));
		lblGestionDesRendez.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGestionDesRendez.setBounds(144, 11, 410, 52);
		frmGestionDesRendez.getContentPane().add(lblGestionDesRendez);
		
		JLabel lblIdrv = new JLabel("Id_Rv");
		lblIdrv.setBackground(Color.WHITE);
		lblIdrv.setBounds(32, 263, 132, 26);
		frmGestionDesRendez.getContentPane().add(lblIdrv);
		
		JLabel lblJour_1 = new JLabel("Jour");
		lblJour_1.setBackground(Color.WHITE);
		lblJour_1.setBounds(213, 263, 132, 26);
		frmGestionDesRendez.getContentPane().add(lblJour_1);
		
		JLabel lblIdclient_1 = new JLabel("Id_Client");
		lblIdclient_1.setBackground(Color.WHITE);
		lblIdclient_1.setBounds(388, 263, 132, 26);
		frmGestionDesRendez.getContentPane().add(lblIdclient_1);
		
		JLabel lblIdcreneaux_1 = new JLabel("Id_Creneaux");
		lblIdcreneaux_1.setBackground(Color.WHITE);
		lblIdcreneaux_1.setBounds(546, 263, 132, 26);
		frmGestionDesRendez.getContentPane().add(lblIdcreneaux_1);
	
	//button ajouter :
	button_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Rv_Model r=new Rv_Model();
			int id_rv=Integer.parseInt(id.getText());
			String jr=jour.getText();
			int id_client=Integer.parseInt(id_cl.getText());
			int id_cren=Integer.parseInt(id_cre.getText());
			Rendez_Vous vo=new Rendez_Vous(id_rv,jr,id_client,id_cren);
			String query ="insert into rv values (?,?,?,?)";
			try {
				r.Ajouter(query, vo);
				JOptionPane.showMessageDialog(null,"Rendez Vous Bien Ajouté ");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null,"Une Erreur Est survenu  ");
				e1.printStackTrace();
			}
			
			
		}
	});
}	
}
