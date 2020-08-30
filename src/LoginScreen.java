import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
public class LoginScreen {
	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frmLogin.setVisible(true);
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
		});
	}
Connection connection = null;
	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
		connection = DbConnection.dbConnector();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(Color.BLACK);
		frmLogin.setTitle("Login");
		frmLogin.setUndecorated(true);
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setLocationRelativeTo(null);  
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 11, 430, 50);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(180, 0, 89, 50);
		panel.add(lblNewLabel);
		
		JButton btnX = new JButton("X");
		btnX.setForeground(SystemColor.inactiveCaptionBorder);
		btnX.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Sure you want to Exit ?","Confirm Exit",
			            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			            System.exit(0);
			}
		});
		btnX.setBackground(Color.RED);
		btnX.setBounds(382, 0, 48, 31);
		panel.add(btnX);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 60, 430, 229);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(173, 149, 111, 43);
		panel_1.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setBounds(63, 19, 132, 41);
		panel_1.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(73, 70, 122, 42);
		panel_1.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 71, 156, 41);
		panel_1.add(passwordField);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField = new JTextField();
		
		textField.setBounds(205, 19, 156, 41);
		panel_1.add(textField);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText().toString();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText().toString();
				String query="select * from users where username=? and password=?";
				ResultSet rs = null; 
				try {
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1, user);
				pst.setString(2, pass);
				 rs = pst.executeQuery();
				int c=0;
				while(rs.next()) {
					c=c+1;
				}
				if(c==1) {
					frmLogin.dispose();
					DashBoard dash = new DashBoard();
					dash.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Wrong Credentials!!!","Login Error",JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
				}
				
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
	}

}
