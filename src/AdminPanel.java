import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AdminPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField CurrentPass;
	private JPasswordField UNewPass;
	private JPasswordField UCNewPass;
	private JPasswordField NewPass;
	private JPasswordField CnewPass;
	private JTextField NewUser;
	private JTextField AdminUsername;
	private JTextField TxtUserame;
	private JTable SubAdminTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
					String currentDir = System.getProperty("user.dir");
					Image icon = Toolkit.getDefaultToolkit().getImage(""+currentDir+"\\images\\logo.png");  
					frame.setIconImage(icon);  
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPanel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 967, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 951, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin Area");
		lblAdmin.setForeground(new Color(0, 0, 0));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmin.setBounds(10, 11, 931, 63);
		panel.add(lblAdmin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(0, 85, 155, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(165, 96, 776, 346);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel ChangePassword = new JPanel();
		ChangePassword.setBackground(new Color(255, 248, 220));
		layeredPane.add(ChangePassword, "name_710505366819900");
		ChangePassword.setLayout(null);
		
		JLabel lblOldPassword = new JLabel("Admin Password :");
		lblOldPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOldPassword.setBounds(10, 87, 140, 37);
		ChangePassword.add(lblOldPassword);
		
		CurrentPass = new JPasswordField();
		CurrentPass.setBackground(new Color(255, 248, 220));
		CurrentPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		CurrentPass.setBounds(145, 89, 222, 37);
		ChangePassword.add(CurrentPass);
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewPassword.setBounds(414, 87, 120, 37);
		lblNewPassword.setVisible(false);
		ChangePassword.add(lblNewPassword);
		
		UNewPass = new JPasswordField();
		UNewPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		UNewPass.setBackground(new Color(255, 248, 220));
		UNewPass.setBounds(544, 87, 222, 37);
		UNewPass.setVisible(false);
		ChangePassword.add(UNewPass);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmPassword.setBounds(391, 135, 157, 37);
		lblConfirmPassword.setVisible(false);
		ChangePassword.add(lblConfirmPassword);
		
		AdminUsername = new JTextField();
		AdminUsername.setBackground(new Color(255, 248, 220));
		AdminUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		AdminUsername.setBounds(145, 39, 222, 37);
		ChangePassword.add(AdminUsername);
		AdminUsername.setColumns(10);
	
		
		
		
		JLabel lblUser = new JLabel("User Name :");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setBounds(443, 39, 91, 37);
		lblUser.setVisible(false);
		ChangePassword.add(lblUser);
		
		TxtUserame = new JTextField();
		TxtUserame.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtUserame.setColumns(10);
		TxtUserame.setBackground(new Color(255, 248, 220));
		TxtUserame.setBounds(544, 39, 222, 37);
		TxtUserame.setVisible(false);
		ChangePassword.add(TxtUserame);
		
		JPanel AddUsers = new JPanel();
		layeredPane.add(AddUsers, "name_710505378786000");
		AddUsers.setBackground(new Color(255, 248, 220));
		AddUsers.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(218, 55, 84, 37);
		AddUsers.add(lblUsername);
		
	
		
		UCNewPass = new JPasswordField();
		UCNewPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		UCNewPass.setBackground(new Color(255, 248, 220));
		UCNewPass.setBounds(543, 137, 222, 37);
		UCNewPass.setVisible(false);
		ChangePassword.add(UCNewPass);
		
		JButton btnUpdatePassword = new JButton("Update Password");
		btnUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DbConnection.dbConnector();
					@SuppressWarnings("deprecation")
					String NewPassword = UNewPass.getText().trim();
					@SuppressWarnings("deprecation")
					String CNewPassword = UCNewPass.getText().trim();
					String CurrUser = TxtUserame.getText().trim();
					if(!CNewPassword.equals(NewPassword)) {
						JOptionPane.showMessageDialog(null, "Passwords didnt Matched","Error!!!",JOptionPane.ERROR_MESSAGE);
					}else {
						String query = "Update users set password=? where username='"+CurrUser+"'";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, CNewPassword);
						int rowAffected = pst.executeUpdate();
						pst.close();
						connection.close();
						if(rowAffected == 1)
						{
							JOptionPane.showMessageDialog(null, "Password Changed Succesfully","Success",JOptionPane.INFORMATION_MESSAGE);
						}else {
							System.out.println("Error updating passes");
						}
						pst.close();
						connection.close();
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnUpdatePassword.setVisible(false);
		
		btnUpdatePassword.setForeground(new Color(255, 255, 255));
		btnUpdatePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdatePassword.setBackground(new Color(0, 128, 128));
		btnUpdatePassword.setBounds(547, 219, 177, 54);
		ChangePassword.add(btnUpdatePassword);
		
		
		JLabel lblUsername_1 = new JLabel("Admin :");
		lblUsername_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername_1.setBounds(78, 39, 62, 37);
		ChangePassword.add(lblUsername_1);
		
		JButton btnAthenticate = new JButton("Athenticate");
		btnAthenticate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Currentuser = AdminUsername.getText().trim();
				@SuppressWarnings("deprecation")
				String Currentpass = CurrentPass.getText().trim();
				
					try {
						Connection connection = DbConnection.dbConnector();
						String CheckUser = "SELECT * from users WHERE username=? AND password=? AND superAdmin=?";
						PreparedStatement pst  = connection.prepareStatement(CheckUser);
						ResultSet rst = null;
						pst.setString(1, Currentuser);
						pst.setString(2, Currentpass);
						pst.setString(3, "true");
						rst = pst.executeQuery();
						if(!rst.isClosed()) { 
								JOptionPane.showMessageDialog(null,"Athenticated Done!! \nEnter New Passwords");
								TxtUserame.setVisible(true);
								lblUser.setVisible(true);
								lblNewPassword.setVisible(true);
								lblConfirmPassword.setVisible(true);
								UNewPass.setVisible(true);
								UCNewPass.setVisible(true);
								btnUpdatePassword.setVisible(true);
								
						}else {
							JOptionPane.showMessageDialog(null, "Current User and Password not Correct");
						}
						rst.close();
						connection.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			
		});
		btnAthenticate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAthenticate.setBackground(new Color(255, 127, 80));
		btnAthenticate.setBounds(145, 171, 222, 37);
		ChangePassword.add(btnAthenticate);
		NewPass = new JPasswordField();
		NewPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		NewPass.setBackground(new Color(255, 248, 220));
		NewPass.setBounds(312, 115, 222, 37);
		AddUsers.add(NewPass);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(218, 115, 84, 37);
		AddUsers.add(lblPassword);
		
		JLabel lblReEnter = new JLabel("Re Enter :");
		lblReEnter.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReEnter.setBounds(229, 176, 73, 37);
		AddUsers.add(lblReEnter);
		
		CnewPass = new JPasswordField();
		CnewPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		CnewPass.setBackground(new Color(255, 248, 220));
		CnewPass.setBounds(312, 176, 222, 37);
		AddUsers.add(CnewPass);
		
		NewUser = new JTextField();
		NewUser.setBackground(new Color(255, 248, 220));
		NewUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		NewUser.setBounds(312, 57, 222, 37);
		AddUsers.add(NewUser);
		NewUser.setColumns(10);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewUsertxt = NewUser.getText().toString().trim();
				@SuppressWarnings("deprecation")
				String NewPass1 = NewPass.getText().trim();
				@SuppressWarnings("deprecation")
				String NewPass2 = CnewPass.getText().trim();
				
				if(!NewPass1.equals(NewPass2)) {
					JOptionPane.showMessageDialog(null, "Passwords did not matched");
				}else {
					try {
						Connection connection = DbConnection.dbConnector();
						
						String query = "INSERT into users (username, password,superAdmin) VALUES (?,?,?);";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, NewUsertxt);
						pst.setString(2, NewPass2);
						pst.setString(3, "false");
						int rowAffected = pst.executeUpdate();
						pst.close();
						connection.close();
						if(rowAffected == 1)
						{
							JOptionPane.showMessageDialog(null, "New User Added","Success",JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				
			}
		});
		btnCreateUser.setForeground(new Color(255, 255, 255));
		btnCreateUser.setBackground(new Color(0, 128, 128));
		btnCreateUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreateUser.setBounds(254, 253, 202, 66);
		AddUsers.add(btnCreateUser);
		
		JPanel RemoveUsers = new JPanel();
		RemoveUsers.setBackground(new Color(255, 248, 220));
		layeredPane.add(RemoveUsers, "name_710514411747000");
		RemoveUsers.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(165, 47, 395, 179);
		RemoveUsers.add(scrollPane);
		
		SubAdminTable = new JTable();
		scrollPane.setViewportView(SubAdminTable);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Sure you want to Delete Sub Admin ?","Warning!!!",
			            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					int row = SubAdminTable.getSelectedRow();
					if(row<0) {
						JOptionPane.showMessageDialog(null, "Select Sub Admin to Delete\n");
					}else {
		        Object eve =  SubAdminTable.getModel().getValueAt(row, 0);
		        
		        String delRow = "delete from users where id="+eve;
		        try {
		        	Connection connection = DbConnection.dbConnector();
		        	PreparedStatement ps = connection.prepareStatement(delRow);
		            ps.execute();
		            SubAdminTable.addNotify();
		            JOptionPane.showMessageDialog(null, "Deleted SubAdmin Successfully !!");
		            ps.close();
		            connection.close();
		        } catch (Exception e1) {
		            JOptionPane.showMessageDialog(null,  e1.getMessage());
		        }
		        try {
					Connection connection = DbConnection.dbConnector();
					String ViewUsers = "select id,username from users where superAdmin='false'";
					PreparedStatement pst  = connection.prepareStatement(ViewUsers);
					ResultSet rs = pst.executeQuery();
					
					SubAdminTable.setFont(new Font("Tohama", Font.PLAIN , 15));
					SubAdminTable.setModel(DbUtils.resultSetToTableModel(rs));
					JTableHeader tableHeader = SubAdminTable.getTableHeader();
					SubAdminTable.setRowHeight(30);
				      Font headerFont = new Font("Tohama", Font.BOLD, 16);
				      tableHeader.setFont(headerFont);
				      rs.close();
				      pst.close();
				      connection.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
					}
			}
				 
			}
		});
		btnRemoveUser.setForeground(new Color(255, 255, 255));
		btnRemoveUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveUser.setBackground(new Color(165, 42, 42));
		btnRemoveUser.setBounds(290, 268, 135, 37);
		RemoveUsers.add(btnRemoveUser);
		
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(ChangePassword);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 42, 135, 37);
		panel_1.add(btnNewButton);
		
		JButton btnAddUsers = new JButton("Add Users");
		btnAddUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(AddUsers);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnAddUsers.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddUsers.setBackground(new Color(255, 160, 122));
		btnAddUsers.setBounds(10, 102, 135, 37);
		panel_1.add(btnAddUsers);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			AdminPanel.this.dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBackground(new Color(255, 160, 122));
		btnExit.setBounds(10, 320, 135, 37);
		panel_1.add(btnExit);
		
		JButton btnRemoveUsers = new JButton("Remove Users");
		btnRemoveUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(RemoveUsers);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				try {
					Connection connection = DbConnection.dbConnector();
					String ViewUsers = "select id,username from users where superAdmin='false'";
					PreparedStatement pst  = connection.prepareStatement(ViewUsers);
					ResultSet rs = pst.executeQuery();
					
					SubAdminTable.setFont(new Font("Tohama", Font.PLAIN , 15));
					SubAdminTable.setModel(DbUtils.resultSetToTableModel(rs));
					JTableHeader tableHeader = SubAdminTable.getTableHeader();
					SubAdminTable.setRowHeight(30);
				      Font headerFont = new Font("Tohama", Font.BOLD, 16);
				      tableHeader.setFont(headerFont);
				      rs.close();
				      pst.close();
				      connection.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		btnRemoveUsers.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveUsers.setBackground(new Color(255, 160, 122));
		btnRemoveUsers.setBounds(10, 166, 135, 37);
		panel_1.add(btnRemoveUsers);
		
	
		
	
	}
}
