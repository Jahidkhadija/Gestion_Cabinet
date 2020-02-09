
package AdminDAO;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Classes.Admin;
import DAO.Connect;
import ModelDAO.Admin_Model;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import java.awt.Color;
import javax.swing.ImageIcon;

public class Login {

	JFrame frmLogin;
	private JTextField nom;
	private JTextField code;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 801, 600);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Application Gestion d'une Cabinet Medicale");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\cabb.png"));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(79, 41, 628, 92);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Utilisateur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(249, 334, 109, 28);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMotDePasse.setBounds(249, 373, 109, 28);
		frmLogin.getContentPane().add(lblMotDePasse);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(390, 338, 137, 26);
		frmLogin.getContentPane().add(nom);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(390, 377, 137, 26);
		frmLogin.getContentPane().add(code);
		
		JButton btnSeConnecter = new JButton("Se Connecter");
		btnSeConnecter.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\se_connecter.png"));
		btnSeConnecter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=nom.getText();
				String mot_passe=code.getText();
				Statement st=null;
				Connect con=null;
				Admin_Model ad=new Admin_Model(con,st);
				Admin d=new Admin(name,mot_passe);
				String query = "select * from admin where nom_utilisateur =? and mot_de_passe =? ";
				try {
					ResultSet set=ad.sign_in(query, d);
					if(set.next())
					{
						Login_Admin x=new Login_Admin();
						x.frmEspaceadmin.setVisible(true);
						frmLogin.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Nom d'utilisateur ou mot de passe Erronée ");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSeConnecter.setBounds(293, 431, 170, 49);
		frmLogin.getContentPane().add(btnSeConnecter);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(318, 284, 85, 38);
		frmLogin.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\me\\eclipse-workspace\\Cabinet_Medical\\src\\cabbb.jpg"));
		lblNewLabel_3.setBounds(0, 0, 785, 561);
		frmLogin.getContentPane().add(lblNewLabel_3);
	}

}
