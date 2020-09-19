import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashBoard extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel TimeLabel;
	private JTextField FullName;
	private JTextField TotalAmt;
	private JTextField AdvPaid;
	private JTextField DueAmt;
	private JTextField txtMobile;
	private JTextField Fprice;
	private JTextField Fqty;
	private JTextField Gprice;
	private JTextField Gqty;
	private JTextField txtSun;
	private JTextField SQty;
	private JTextField OtherPrice;
	private String OtherReason="";
	private String p1="";
	private String p1price="";
	private String p1qty="";
	private String p1total="";
	private String p2="";
	private String p2price="";
	private String p2qty="";
	private String p2total="";
	private String p3="";
	private String p3price="";
	private String p3qty="";
	private String p3total="";
	private String p4="";
	private String p4price="";
	private String fname;
	private String Mobile;
	private String p4total="";
	private String FrameCheck;
	private String GlassCheck;
	private String SunCheck;
	private String OtherCheck;
	private String formattedDate;
	private int TockenNumber;
	private int TotalAfterDiscount;
	private int Total;
	private int TotalBeforeDiscount;
	private String Advpaid;
	private String Duepaid;
	private JTextField searchTocken;
	private JTable table;
	private JTable AllOrders;
	private JTextField SearchOrder;
	private JTextField RtxtSph;
	private JTextField RtxtCyl;
	private JTextField RtxtAxis;
	private JTextField RtxtNear;
	private JTextField LtxtSph;
	private JTextField LtxtCyl;
	private JTextField LtxtAxis;
	private JTextField LtxtNear;
	private JTextField OtherTxt;
	private JTextField Discount;
	private String Frametype="";
	private String RSph="";
	private String RCyl="";
	private String RAxis="";
	private String RNear="";
	private String LSph="";
	private String LCyl="";
	private String LAxis="";
	private String LNear="";
	private String TxtDiscount="";
	private String TxtDiscountPrice="";
	int DiscountAmt;
	int P1Total;
	int P2Total;
	int P3Total;
	int P4Total;
	private int AddedToDb=0;
	private JTable ReportTable;
	private JTextField CustomerFullTotal;
	 Object eve;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
					ImageIcon img = new ImageIcon("logo.png");
					frame.setIconImage(img.getImage());
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

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar calendar= new GregorianCalendar();
						sleep(1000);
						int second = calendar.get(Calendar.SECOND);
						int minute = calendar.get(Calendar.MINUTE);
						int hour = calendar.get(Calendar.HOUR);
						TimeLabel.setText("|  "+hour+" : "+minute+" : "+second+"  |\n");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}
	
	
	/**
	 * Create the frame.
	 */
	public DashBoard() {
		
		clock();
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(189, 64, 1179, 654);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel NewOrder = new JPanel();
		NewOrder.setBackground(new Color(255, 248, 220));
		layeredPane.add(NewOrder, "name_115969661674500");
		NewOrder.setLayout(null);
		
		JLabel lblPanel = new JLabel("Full Name :");
		lblPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPanel.setBounds(6, 11, 77, 34);
		NewOrder.add(lblPanel);
		
		
		
		
		JLabel lblLeftEye = new JLabel("Left Eye ");
		lblLeftEye.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeftEye.setBounds(379, 347, 77, 34);
		NewOrder.add(lblLeftEye);
		lblLeftEye.setVisible(false);
		
		
		JLabel lblRightEye = new JLabel("Right Eye ");
		lblRightEye.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRightEye.setBounds(92, 347, 89, 34);
		NewOrder.add(lblRightEye);
		lblRightEye.setVisible(false);
		
		JLabel lblSun = new JLabel("SunGoggle Price :");
		lblSun.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSun.setBounds(6, 263, 122, 33);
		NewOrder.add(lblSun);
		lblSun.setVisible(false);
		txtSun = new JTextField();
		txtSun.setBackground(new Color(255, 248, 220));
		txtSun.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSun.setBounds(138, 263, 77, 33);
		NewOrder.add(txtSun);
		txtSun.setColumns(10);
		txtSun.setVisible(false);
		
		JLabel SunQty = new JLabel("Quantity :");
		SunQty.setFont(new Font("Tahoma", Font.BOLD, 14));
		SunQty.setBounds(225, 262, 77, 33);
		NewOrder.add(SunQty);
		SunQty.setVisible(false);
		
		
		
		JCheckBox chckbxSunGlasses = new JCheckBox("Sun Glasses");
		chckbxSunGlasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxSunGlasses.isSelected()) {
					lblSun.setVisible(true);
					txtSun.setVisible(true);
					SQty.setVisible(true);
					SQty.setText("1");
					SunQty.setVisible(true);
					p3="Sun Glass";
				}else {
					p3="";
					p3price="";
					p3qty="";
					p3total="";
					lblSun.setVisible(false);
					txtSun.setVisible(false);
					SQty.setVisible(false);
					SunQty.setVisible(false);
				}
			}
		});
		chckbxSunGlasses.setBackground(new Color(255, 248, 220));
		chckbxSunGlasses.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxSunGlasses.setBounds(190, 97, 115, 23);
		NewOrder.add(chckbxSunGlasses);
		
		JLabel lblTotalAmt = new JLabel("Total Amt :");
		lblTotalAmt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalAmt.setBounds(6, 449, 89, 34);
		NewOrder.add(lblTotalAmt);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(595, 34, 484, 529);
		NewOrder.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 484, 529);
		panel_3.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		
		JTextArea PrintArea = new JTextArea();
		PrintArea.setBounds(53, 11, 388, 507);
		panel_2.add(PrintArea);
		PrintArea.setFont(new Font("Arial", Font.PLAIN, 11));
		PrintArea.setVisible(false);
		
		
		FullName = new JTextField();
		FullName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(FullName.getText().toString().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Insert Full name");
					FullName.requestFocusInWindow();
					
				}
			}
		});
		FullName.setBackground(new Color(255, 248, 220));
		FullName.setToolTipText("name\r\n");
		FullName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FullName.setBounds(104, 12, 407, 34);
		NewOrder.add(FullName);	
		FullName.setColumns(10);
		
		
		SQty = new JTextField();
		SQty.setBackground(new Color(255, 248, 220));
		SQty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SQty.setBounds(310, 262, 77, 34);
		NewOrder.add(SQty);
		SQty.setColumns(10);
		SQty.setVisible(false);
		
		JLabel lblOther = new JLabel("Price : ");
		lblOther.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOther.setBounds(290, 307, 46, 33);
		NewOrder.add(lblOther);
		lblOther.setVisible(false);
		
		OtherPrice = new JTextField();
		OtherPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		OtherPrice.setBackground(new Color(255, 248, 220));
		OtherPrice.setBounds(339, 309, 77, 33);
		NewOrder.add(OtherPrice);
		OtherPrice.setVisible(false);
		OtherPrice.setColumns(10);
		
		
		JLabel lblOtherTxt = new JLabel("Other :");
		lblOtherTxt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOtherTxt.setBounds(16, 308, 49, 31);
		NewOrder.add(lblOtherTxt);
		lblOtherTxt.setVisible(false);
		
		OtherTxt = new JTextField();
		OtherTxt.setFont(new Font("Tahoma", Font.BOLD, 14));
		OtherTxt.setBackground(new Color(255, 248, 220));
		OtherTxt.setBounds(75, 309, 197, 32);
		NewOrder.add(OtherTxt);
		OtherTxt.setColumns(10);
		OtherTxt.setVisible(false);
		
		
		
		Gprice = new JTextField();
		Gprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Gprice.setColumns(10);
		Gprice.setBackground(new Color(255, 248, 220));
		Gprice.setBounds(138, 217, 77, 34);
		NewOrder.add(Gprice);
		Gprice.setVisible(false);
		Gqty = new JTextField();
		Gqty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Gqty.setColumns(10);
		Gqty.setBackground(new Color(255, 248, 220));
		Gqty.setBounds(310, 217, 77, 34);
		Gqty.setText("1");
		NewOrder.add(Gqty);
		Gqty.setVisible(false);
		
		JLabel lblGlassPrice = new JLabel("Glass Price :");
		lblGlassPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGlassPrice.setBounds(6, 216, 89, 34);
		NewOrder.add(lblGlassPrice);
		lblGlassPrice.setVisible(false);
		
		
		JLabel lblGQty = new JLabel("Quantity :");
		lblGQty.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGQty.setBounds(225, 216, 77, 34);
		NewOrder.add(lblGQty);
		lblGQty.setVisible(false);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 248, 220));
		panel_5.setBounds(6, 380, 262, 58);
		NewOrder.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel RlblSph = new JLabel("Sph");
		RlblSph.setHorizontalAlignment(SwingConstants.CENTER);
		RlblSph.setFont(new Font("Tahoma", Font.BOLD, 14));
		RlblSph.setBounds(0, 1, 55, 23);
		panel_5.add(RlblSph);
		
		JLabel RlblCyl = new JLabel("Cyl");
		RlblCyl.setHorizontalAlignment(SwingConstants.CENTER);
		RlblCyl.setFont(new Font("Tahoma", Font.BOLD, 14));
		RlblCyl.setBounds(69, 2, 55, 21);
		panel_5.add(RlblCyl);
		
		JLabel RlblAxis = new JLabel("Axis");
		RlblAxis.setHorizontalAlignment(SwingConstants.CENTER);
		RlblAxis.setFont(new Font("Tahoma", Font.BOLD, 14));
		RlblAxis.setBounds(139, 2, 55, 21);
		RlblAxis.setVisible(false);
		panel_5.add(RlblAxis);
		
		JLabel RlblNear = new JLabel("Near");
		RlblNear.setHorizontalAlignment(SwingConstants.CENTER);
		RlblNear.setFont(new Font("Tahoma", Font.BOLD, 14));
		RlblNear.setBounds(204, 3, 55, 19);
		panel_5.add(RlblNear);
		
		RtxtSph = new JTextField();
		RtxtSph.setBackground(new Color(255, 248, 220));
		RtxtSph.setBounds(0, 27, 55, 31);
		panel_5.add(RtxtSph);
		RtxtSph.setColumns(10);
		
		RtxtCyl = new JTextField();
		
		RtxtCyl.setBackground(new Color(255, 248, 220));
		RtxtCyl.setColumns(10);
		RtxtCyl.setBounds(69, 27, 55, 31);
		panel_5.add(RtxtCyl);
		
		RtxtAxis = new JTextField();
		RtxtAxis.setBackground(new Color(255, 248, 220));
		RtxtAxis.setColumns(10);
		RtxtAxis.setBounds(139, 27, 55, 31);
		RtxtAxis.setVisible(false);
		panel_5.add(RtxtAxis);
		
		RtxtNear = new JTextField();
		RtxtNear.setBackground(new Color(255, 248, 220));
		RtxtNear.setColumns(10);
		RtxtNear.setBounds(204, 27, 55, 31);
		panel_5.add(RtxtNear);

		RlblSph.setVisible(false);
		RlblCyl.setVisible(false);
		RlblAxis.setVisible(false);
		RlblNear.setVisible(false);
		RtxtSph.setVisible(false);
		RtxtCyl.setVisible(false);
		RtxtAxis.setVisible(false);
		RtxtNear.setVisible(false);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(255, 248, 220));
		panel_6.setBounds(291, 380, 262, 58);
		NewOrder.add(panel_6);
		
		JLabel LlblSph = new JLabel("Sph");
		LlblSph.setHorizontalAlignment(SwingConstants.CENTER);
		LlblSph.setFont(new Font("Tahoma", Font.BOLD, 14));
		LlblSph.setBounds(0, 1, 55, 23);
		panel_6.add(LlblSph);
		
		JLabel LlblCyl = new JLabel("Cyl");
		LlblCyl.setHorizontalAlignment(SwingConstants.CENTER);
		LlblCyl.setFont(new Font("Tahoma", Font.BOLD, 14));
		LlblCyl.setBounds(69, 2, 55, 21);
		panel_6.add(LlblCyl);
		
		JLabel LlblAxis = new JLabel("Axis");
		LlblAxis.setHorizontalAlignment(SwingConstants.CENTER);
		LlblAxis.setFont(new Font("Tahoma", Font.BOLD, 14));
		LlblAxis.setBounds(139, 2, 55, 21);
		panel_6.add(LlblAxis);
		
		JLabel LlblNear = new JLabel("Near");
		LlblNear.setHorizontalAlignment(SwingConstants.CENTER);
		LlblNear.setFont(new Font("Tahoma", Font.BOLD, 14));
		LlblNear.setBounds(204, 3, 55, 19);
		panel_6.add(LlblNear);
		
		LtxtSph = new JTextField();
		LtxtSph.setColumns(10);
		LtxtSph.setBackground(new Color(255, 248, 220));
		LtxtSph.setBounds(0, 27, 55, 31);
		panel_6.add(LtxtSph);
		
		LtxtCyl = new JTextField();
		LtxtCyl.setColumns(10);
		LtxtCyl.setBackground(new Color(255, 248, 220));
		LtxtCyl.setBounds(69, 27, 55, 31);
		panel_6.add(LtxtCyl);
		
		LtxtAxis = new JTextField();
		LtxtAxis.setColumns(10);
		LtxtAxis.setBackground(new Color(255, 248, 220));
		LtxtAxis.setBounds(139, 27, 55, 31);
		panel_6.add(LtxtAxis);
		
		LtxtNear = new JTextField();
		LtxtNear.setColumns(10);
		LtxtNear.setBackground(new Color(255, 248, 220));
		LtxtNear.setBounds(204, 27, 55, 31);
		panel_6.add(LtxtNear);
		
		LlblSph.setVisible(false);
		LlblCyl.setVisible(false);
		LlblAxis.setVisible(false);
		LlblNear.setVisible(false);
		LtxtSph.setVisible(false);
		LtxtCyl.setVisible(false);
		LtxtAxis.setVisible(false);
		LtxtNear.setVisible(false);

		
		JCheckBox chckbxGlass = new JCheckBox("Glass");
		chckbxGlass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxGlass.isSelected()) {
					lblGlassPrice.setVisible(true);
					Gqty.setVisible(true);
					Gprice.setVisible(true);
					lblGQty.setVisible(true);
					lblRightEye.setVisible(true);
					lblLeftEye.setVisible(true);
					p2="Glass";
					RlblSph.setVisible(true);
					RlblCyl.setVisible(true);
					RlblAxis.setVisible(true);
					RlblNear.setVisible(true);
					RtxtSph.setVisible(true);
					RtxtCyl.setVisible(true);
					RtxtAxis.setVisible(true);
					RtxtNear.setVisible(true);
					LlblSph.setVisible(true);
					LlblCyl.setVisible(true);
					LlblAxis.setVisible(true);
					LlblNear.setVisible(true);
					LtxtSph.setVisible(true);
					LtxtCyl.setVisible(true);
					LtxtAxis.setVisible(true);
					LtxtNear.setVisible(true);
				}else {
					p2="";
					p2price="";
					p2qty="";
					p2total="";
					lblGQty.setVisible(false);
					Gprice.setVisible(false);
					lblGlassPrice.setVisible(false);
					Gqty.setVisible(false);
					lblRightEye.setVisible(false);
					lblLeftEye.setVisible(false);
					
					RlblSph.setVisible(false);
					RlblCyl.setVisible(false);
					RlblAxis.setVisible(false);
					RlblNear.setVisible(false);
					RtxtSph.setVisible(false);
					RtxtCyl.setVisible(false);
					RtxtAxis.setVisible(false);
					RtxtNear.setVisible(false);
					LlblSph.setVisible(false);
					LlblCyl.setVisible(false);
					LlblAxis.setVisible(false);
					LlblNear.setVisible(false);
					LtxtSph.setVisible(false);
					LtxtCyl.setVisible(false);
					LtxtAxis.setVisible(false);
					LtxtNear.setVisible(false);
				}
			}
		});
		
		
		JLabel lblFramePrice = new JLabel("Frame Price :");
		lblFramePrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFramePrice.setBounds(6, 163, 89, 34);
		NewOrder.add(lblFramePrice);
		lblFramePrice.setVisible(false);
		
		Fprice = new JTextField();
		Fprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Fprice.setColumns(10);
		Fprice.setBackground(new Color(255, 248, 220));
		Fprice.setBounds(138, 163, 77, 34);
		NewOrder.add(Fprice);
		Fprice.setVisible(false);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(225, 162, 77, 34);
		NewOrder.add(lblQuantity);
		lblQuantity.setVisible(false);
		
		
		JCheckBox chckbxFrameFull = new JCheckBox("Full");
		chckbxFrameFull.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxFrameFull.setBackground(new Color(255, 248, 220));
		chckbxFrameFull.setBounds(6, 123, 63, 23);
		NewOrder.add(chckbxFrameFull);
		chckbxFrameFull.setVisible(false);
		
		JCheckBox chckbxFrame3Piece = new JCheckBox("3 Piece");
		chckbxFrame3Piece.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxFrame3Piece.setBackground(new Color(255, 248, 220));
		chckbxFrame3Piece.setBounds(75, 123, 84, 23);
		NewOrder.add(chckbxFrame3Piece);
		chckbxFrame3Piece.setVisible(false);
		
		JCheckBox chckbxFrameSupra = new JCheckBox("Supra");
		chckbxFrameSupra.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxFrameSupra.setBackground(new Color(255, 248, 220));
		chckbxFrameSupra.setBounds(162, 123, 84, 23);
		NewOrder.add(chckbxFrameSupra);
		chckbxFrameSupra.setVisible(false);
		
		
		
		JCheckBox chckbxFrame = new JCheckBox("Frame");
		chckbxFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxFrame.isSelected()) {
					p1="Frame";
					chckbxFrameFull.setVisible(true);
					chckbxFrame3Piece.setVisible(true);
					chckbxFrameSupra.setVisible(true);
					Fprice.setVisible(true);
					lblFramePrice.setVisible(true);
					lblQuantity.setVisible(true);
					Fqty.setVisible(true);
				}else  {
					p1="";
					p1price="";
					p1qty="";
					p1total="";
					chckbxFrameFull.setVisible(false);
					chckbxFrame3Piece.setVisible(false);
					chckbxFrameSupra.setVisible(false);
					Fqty.setVisible(false);
					lblQuantity.setVisible(false);
					lblFramePrice.setVisible(false);
					Fprice.setVisible(false);
				}
				
			}
		});
		chckbxFrame.setBackground(new Color(255, 248, 220));
		chckbxFrame.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxFrame.setBounds(6, 97, 84, 23);
		NewOrder.add(chckbxFrame);
		
		

		chckbxGlass.setBackground(new Color(255, 248, 220));
		chckbxGlass.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxGlass.setBounds(104, 97, 84, 23);
		NewOrder.add(chckbxGlass);
		
		JCheckBox chckbxOther = new JCheckBox("Other");
		chckbxOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxOther.isSelected()) {
					lblOther.setVisible(true);
					OtherPrice.setVisible(true);
					lblOtherTxt.setVisible(true);
					OtherTxt.setVisible(true);
				}else {
					lblOtherTxt.setVisible(false);
					OtherTxt.setVisible(false);
					lblOther.setVisible(false);
					OtherPrice.setVisible(false);
					p4total="";
					p4price = "";
					p4="";
				}
			}
		});
		chckbxOther.setBackground(new Color(255, 248, 220));
		chckbxOther.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxOther.setBounds(329, 97, 84, 23);
		NewOrder.add(chckbxOther);
		
		
		
		
		
		
		
		
		TotalAmt = new JTextField();
		TotalAmt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				int FramePrice = 0;
				int FrameQuantity=0;
				int GlassPrice = 0;
				int GlassQuantity = 0;
				int SunPrice = 0;
				int SunQuantity = 0;
				int OtherPrice = 0;
				if(chckbxFrame.isSelected()) {
					
					FramePrice =  Integer.parseInt(Fprice.getText().trim());
					FrameQuantity =  Integer.parseInt(Fqty.getText().trim());
					p1price=Integer.toString(FramePrice);
					
					P1Total=FramePrice*FrameQuantity;
					p1total=Integer.toString(P1Total);
					p1qty = Integer.toString(FrameQuantity);
					
				}
				if(chckbxFrameFull.isSelected()) {
					Frametype = "   Full";
				}
				if(chckbxFrame3Piece.isSelected()) {
					 Frametype = "3 Piece";
				}
				if(chckbxFrameSupra.isSelected()) {
					 Frametype = "Supra";
				}
				if(chckbxGlass.isSelected()) {
					p2="Glass";
					GlassPrice =  Integer.parseInt(Gprice.getText().trim());
					GlassQuantity = Integer.parseInt(Gqty.getText().trim());
					RSph = RtxtSph.getText().toString().trim();
					if(RSph.equals("")) {
						RSph="-";
					}
					if(RSph.length()<=3) {
						RSph="      "+RSph;
					}
					RCyl = RtxtCyl.getText().toString().trim();
					if(RCyl.equals("")) {
						RCyl="-";
					}
					if(RCyl.length()<=3) {
						RCyl="      "+RCyl;
					}
					
					RAxis = RtxtAxis.getText().toString().trim();
					if(RAxis.equals("")) {
						RAxis="-";
					}
					if(RAxis.length()<=3) {
						RAxis="      "+RAxis;
					}
					RNear = RtxtNear.getText().toString().trim();
					if(RNear.equals("")) {
						RNear="-";
					}
					if(RNear.length()<=3) {
						RNear="      "+RNear;
					}
					LSph = LtxtSph.getText().toString().trim();
					if(LSph.equals("")) {
						LSph="-";
					}
					if(LSph.length()<=3) {
						LSph="      "+LSph;
					}
					LCyl = LtxtCyl.getText().toString().trim();
					if(LCyl.equals("")) {
						LCyl="-";
					}
					if(LCyl.length()<=3) {
						LCyl="    "+LCyl;
					}
					LAxis = LtxtAxis.getText().toString().trim();
					if(LAxis.equals("")) {
						LAxis="-";
					}
					if(LAxis.length()<=3) {
						LAxis="      "+LAxis;
					}
					LNear = LtxtNear.getText().toString().trim();
					if(LNear.equals("")) {
						LNear="-";
					}
					if(LNear.length()<=3) {
						LNear="      "+LNear;
					}
					P2Total = GlassPrice*GlassQuantity;
					p2price=Integer.toString(GlassPrice);
					p2qty = Integer.toString(GlassQuantity);
					p2total = Integer.toString(P2Total);
				}
				if(chckbxSunGlasses.isSelected()) {
					p3="SunGlasses";
					SunPrice = Integer.parseInt(txtSun.getText().trim());
					SunQuantity = Integer.parseInt(SQty.getText().trim());
					P3Total = SunPrice*SunQuantity;
					p3price=Integer.toString(SunPrice);
					p3qty = Integer.toString(SunQuantity);
					p3total = Integer.toString(P3Total);
					
				}
				if(chckbxOther.isSelected()) {
					p4="Other";
					OtherReason = OtherTxt.getText().toString().trim();
					OtherPrice = Integer.parseInt(DashBoard.this.OtherPrice.getText().trim());
					P4Total=(OtherPrice);
					p4total = Integer.toString(OtherPrice);
				}
				Total =( P1Total+P2Total+P3Total+P4Total);
				TotalAmt.setText(Integer.toString( Total));
				TotalBeforeDiscount=Total;
				TotalAfterDiscount=Total;
			}
			
		});
		TotalAmt.setBackground(new Color(255, 248, 220));
		TotalAmt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TotalAmt.setColumns(10);
		TotalAmt.setBounds(104, 450, 118, 34);
		NewOrder.add(TotalAmt);
		
		
		
		
		
		
		
		
		JLabel lblAdvancePaid = new JLabel("Advance :");
		lblAdvancePaid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdvancePaid.setBounds(6, 495, 87, 34);
		NewOrder.add(lblAdvancePaid);
		
		AdvPaid = new JTextField();
		AdvPaid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					for (int i = 0; i < AdvPaid.getText().length(); i++) {
						if (Character.isDigit(AdvPaid.getText().charAt(i)) == false) { 
					            
							JOptionPane.showMessageDialog(null, "Please enter a Number","Input Error",JOptionPane.ERROR_MESSAGE);
							AdvPaid.requestFocusInWindow();
							break;
						} 
					} 
				} catch (Exception er) {
					// TODO: handle exception
					System.out.println(er);
				}
			}
		});
		AdvPaid.setBackground(new Color(255, 248, 220));
		AdvPaid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AdvPaid.setColumns(10);
		AdvPaid.setBounds(104, 494, 118, 34);
		NewOrder.add(AdvPaid);
		
		JLabel lblDueAmt = new JLabel("Balance :");
		lblDueAmt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDueAmt.setBounds(6, 540, 77, 34);
		NewOrder.add(lblDueAmt);
		

		JCheckBox chckbxDiscount = new JCheckBox("Disc");
		chckbxDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxDiscount.isSelected()) {
					Discount.setVisible(true);
					TxtDiscount="Discount";
				}else {
					Discount.setVisible(false);
					Discount.setText("");
				}
			}
		});
		
		
		
		Discount = new JTextField();
		Discount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(chckbxDiscount.isSelected()) {
					TotalBeforeDiscount =  Total;
					DiscountAmt = Integer.parseInt(Discount.getText());
					TotalAfterDiscount = (Total-DiscountAmt);
					TotalAmt.setText(Integer.toString(TotalAfterDiscount));
					JOptionPane.showMessageDialog(null, "discount Added");
				}
			}
		});
		Discount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Discount.setBackground(new Color(255, 248, 220));
		Discount.setBounds(290, 451, 102, 34);
		NewOrder.add(Discount);
		Discount.setColumns(10);
		Discount.setVisible(false);
		
		chckbxDiscount.setBackground(new Color(255, 248, 220));
		chckbxDiscount.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxDiscount.setBounds(228, 455, 56, 23);
		NewOrder.add(chckbxDiscount);
		
		DueAmt = new JTextField();
		DueAmt.setBackground(new Color(255, 248, 220));
		DueAmt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					int Total =Integer.parseInt(TotalAmt.getText());
					int Adv =Integer.parseInt(AdvPaid.getText());
					int Due = (Total - Adv);
					if(Due==0) {
						DueAmt.setText("nill");
					}else {
					DueAmt.setText(""+Due+"");
					}
				} catch (NumberFormatException e1) {
					System.out.println(e1);
				}
				
			}
		});
		DueAmt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DueAmt.setColumns(10);
		DueAmt.setBounds(104, 541, 118, 34);
		NewOrder.add(DueAmt);
		
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setForeground(new Color(240, 255, 255));
		btnGenerate.setBackground(new Color(46, 139, 87));
		btnGenerate.addActionListener(new ActionListener() {
			private SimpleDateFormat SimpleDateFormat;

			public void actionPerformed(ActionEvent e) {
				PrintArea.setVisible(true);
				fname = FullName.getText().toUpperCase().trim();
				Mobile = txtMobile.getText().trim();
//				String PrintTotal = TotalAmt.getText().trim();
				TxtDiscountPrice = Discount.getText().trim();
				 Advpaid = AdvPaid.getText().trim();
				 Duepaid = DueAmt.getText().trim();
				Random rand = new Random(); 
				TockenNumber = rand.nextInt(1000000); 
				Date now = new Date();
				SimpleDateFormat = new SimpleDateFormat("EEEE");
				String txtDay = SimpleDateFormat.format(now).toUpperCase();
				 LocalDateTime myDateObj = LocalDateTime.now();
				 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				    formattedDate = myDateObj.format(myFormatObj);
				PrintArea.setText("   ------------------------------ RAJ OPTICALS.--------------------------  \n"
						+"DATE : "+formattedDate+"                                                   DAY : "+txtDay+"  \n"
						+ "*********************************************************************************\n*"
					+ " NAME : "+fname+"           Token No. : "+TockenNumber+"       \n"
					+" MOBILE : "+Mobile+" \n"
					+"------------------------------------------------------------------------------------------------\n"
					+"PRODUCT                       | PRICE |              |  QTY  |            | TOTAL |\n"
					+""+p1+"-"+Frametype+"                    "+p1price+"                        "+p1qty+"                      "+p1total+"     \n"
					+""+p2+"                                 "+p2price+"                        "+p2qty+"                       "+p2total+"     \n"
					+""+p3+"                       "+p3price+"                        "+p3qty+"                      "+p3total+"     \n"
					+""+OtherReason+"                       "+p4price+"                                                 "+p4total+"     \n"
					+"\n"
					+"	|     Sph     |     Cyl     |     Axis     |     Near     |\n"
					+" RIGHT             "+RSph+"       "+RCyl+"       "+RAxis+"         "+RNear+"        \n"
					+" LEFT               "+LSph+"         "+LCyl+"       "+LAxis+"         "+LNear+"      \n"
					+"\n\n\n"
					+"-------------------------------------------------------------------------------------------\n"
					+"Total                                                                                       "+TotalBeforeDiscount+"\n"
					+""+TxtDiscount+"                                                                                 "+TxtDiscountPrice+"\n"
					+"-------------------------------------------------------------------------------------------\n"
					+"Grand Total                                                                            "+TotalAfterDiscount+"\n"
					+"-------------------------------------------------------------------------------------------\n"
					+"Advance Paid                                                                         "+Advpaid+"     \n"
					+"Balance                                                                                    "+Duepaid+"     \n"
					+"-------------------------------------------------------------------------------------------\n"
					+"\n\n* This is Computer generated bill, no required of Signature\n"
						        + "*****************************************************************************************\n"
						        +"-----tear from here-------------------------------------------------------------------\n"
						        + "                 Token No.  "+TockenNumber+"         "
						        +"\n--------------------------------------------------------------------------------------------");
			}
		});
		btnGenerate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGenerate.setBounds(92, 585, 158, 58);
		NewOrder.add(btnGenerate);
		
		
		
		
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBackground(new Color(46, 139, 87));
		btnPrint.setForeground(new Color(240, 248, 255));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FullName.setText("");
					txtMobile.setText("");
					PrintArea.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrint.setBounds(760, 585, 158, 58);
		NewOrder.add(btnPrint);
		
		JLabel lblPreview = new JLabel("Preview");
		lblPreview.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreview.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPreview.setBounds(776, 0, 122, 34);
		NewOrder.add(lblPreview);
		
		JLabel lblMobile = new JLabel("Mobile :");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobile.setBounds(6, 56, 77, 34);
		NewOrder.add(lblMobile);
		
		txtMobile = new JTextField();
		txtMobile.setBackground(new Color(255, 248, 220));
		txtMobile.setToolTipText("Mobile");
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMobile.setColumns(10);
		txtMobile.setBounds(104, 57, 407, 34);
		NewOrder.add(txtMobile);
		
		
		
		Fqty = new JTextField();
		Fqty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Fqty.setColumns(10);
		Fqty.setBackground(new Color(255, 248, 220));
		Fqty.setBounds(310, 162, 77, 34);
		NewOrder.add(Fqty);
		Fqty.setText("1");
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)  {
				
				Connection connection = DbConnection.dbConnector();
				if(p1.length()==0){
					FrameCheck="false";
				}else {
					FrameCheck=Frametype;
				}
				if(p2.length()==0){
					GlassCheck="false";
				}else {
					GlassCheck="true";
				}
				if(p3.length()==0){
					SunCheck="false";
				}else {
					SunCheck="true";
				}
				if(p4.length()==0){
					OtherCheck="false";
				}else {
					OtherCheck="true";
				}
				if(fname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill All Fields","Input Error",JOptionPane.ERROR_MESSAGE);
				}else if(AddedToDb==1) {
					JOptionPane.showMessageDialog(null, "Already added");
				}
				else {
					AddedToDb=1;
				try {
						String CustomerQuery= "INSERT INTO Orders (FullName,Mobile,Frame,RSph,RCyl,RAxis,"
							+ "RNear,LSph,LCyl,LAxis,LNear,FramePrice,FrameQuantity,Glass,GlassPrice,"
							+ "GlassQuantity,SunGlass,SunGlassQty,SunGlassPrice,Other,OtherReason,OtherPrice,TotalPrice,"
							+ "AdvancePaid,AmountDue,OrderDate,TockenNo,Status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(CustomerQuery);
					pst.setString(1, fname);
					pst.setString(2, Mobile);
					pst.setString(3, FrameCheck);
					pst.setString(4, RSph);
					pst.setString(5, RCyl);
					pst.setString(6, RAxis);
					pst.setString(7, RNear);
					pst.setString(8, LSph);
					pst.setString(9, LCyl);
					pst.setString(10, LAxis);
					pst.setString(11, LNear);
					pst.setString(12, p1price);
					pst.setString(13, p1qty);
					pst.setString(14, GlassCheck);
					pst.setString(15, p2price);
					pst.setString(16, p2qty);
					pst.setString(17, SunCheck);
					pst.setString(18, p3qty);
					pst.setString(19, p3price);
					pst.setString(20, OtherCheck);
					pst.setString(21, OtherReason);
					pst.setString(22, p4price);
					pst.setString(23, Integer.toString( TotalAfterDiscount));
					pst.setString(24, Advpaid);
					pst.setString(25, Duepaid);
					pst.setString(26, formattedDate.toString());
					pst.setString(27, Integer.toString(TockenNumber));
					pst.setString(28, "false");
					int rowAffected = pst.executeUpdate();
					pst.close();
					connection.close();
					if(rowAffected == 1)
					{
						JOptionPane.showMessageDialog(null, "Added to Database","Success",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();	
				}finally {
					try {
						connection.close();
					} catch (Exception e2) {
						e2.printStackTrace();				
						}
				}
				}
			}
		});
		btnAdd.setForeground(new Color(240, 255, 255));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(new Color(46, 139, 87));
		btnAdd.setBounds(391, 585, 120, 58);
		NewOrder.add(btnAdd);
		
		
		
		
		
				
		
		Fqty.setVisible(false);
	
		
		
		
		
		JPanel NotComplete = new JPanel();
		NotComplete.setBackground(new Color(255, 250, 205));
		layeredPane.add(NotComplete, "name_115969683979100");
		NotComplete.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 1159, 59);
		panel_4.setBackground(new Color(255, 250, 205));
		NotComplete.add(panel_4);
		panel_4.setLayout(null);
		
		
	
		
		JLabel TockenNo = new JLabel("");
		TockenNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		TockenNo.setBounds(107, 137, 257, 33);
		NotComplete.add(TockenNo);
		
		JLabel lablname = new JLabel("");
		lablname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lablname.setBounds(107, 181, 257, 33);
		NotComplete.add(lablname);
		
		JLabel TockenStatus = new JLabel("");
		TockenStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		TockenStatus.setBounds(107, 227, 257, 33);
		NotComplete.add(TockenStatus);
		

		JButton cancelOrder = new JButton("Cancel Order");
		cancelOrder.setVisible(false);
		cancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Sure you want to Delete the Record ?","Alert!!!",
			            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					try {
//						JOptionPane.showMessageDialog(null, "DELETE FROM Orders WHERE TockenNo='"+searchTocken.getText()+"';");
						Connection connection = DbConnection.dbConnector();
						String deleteQuery="DELETE FROM Orders WHERE TockenNo='"+searchTocken.getText()+"'";
						PreparedStatement pst  = connection.prepareStatement(deleteQuery);
						int rowAffected = pst.executeUpdate();
						if(rowAffected==1) {
							JOptionPane.showMessageDialog(null, "Deleted");
						}
						pst.close();
						connection.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
//					JOptionPane.showMessageDialog(null, "DELETE FROM Orders WHERE TockenNo='844519';");
			}
		});
		cancelOrder.setForeground(new Color(255, 255, 255));
		cancelOrder.setBackground(new Color(165, 42, 42));
		cancelOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancelOrder.setBounds(124, 396, 156, 49);
		NotComplete.add(cancelOrder);
		
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(27, 181, 70, 33);
		NotComplete.add(lblName);
		
		JLabel lblTockenNo = new JLabel("Tocken No. :");
		lblTockenNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTockenNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTockenNo.setBounds(10, 137, 87, 33);
		NotComplete.add(lblTockenNo);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(27, 225, 70, 33);
		NotComplete.add(lblStatus);
		
		JButton TockenButton = new JButton("Set Order Complete");
		TockenButton.setVisible(false);
		TockenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DbConnection.dbConnector();
					String UpdateOrder = "UPDATE Orders SET Status='true'  WHERE TockenNo='"+searchTocken.getText()+"'";
					PreparedStatement pst  = connection.prepareStatement(UpdateOrder);
					int rowAffected = pst.executeUpdate();
//					JOptionPane.showMessageDialog(null, "DOne");
					pst.close();
					connection.close();
					if(rowAffected==1) {
						JOptionPane.showMessageDialog(null, "Order set to Completed");
						TockenStatus.setText("True");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
//				JOptionPane.showMessageDialog(null, searchTocken);	
			}
		});
		
		TockenButton.setBackground(new Color(0, 128, 128));
		TockenButton.setForeground(new Color(255, 255, 255));
		TockenButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		TockenButton.setBounds(10, 305, 179, 46);
		NotComplete.add(TockenButton);
		
		JButton btnSetOrderNot = new JButton("Set Order Not Complete");
		btnSetOrderNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection connection = DbConnection.dbConnector();
					String UpdateOrder = "UPDATE Orders SET Status='false'  WHERE TockenNo='"+searchTocken.getText()+"'";
					PreparedStatement pst  = connection.prepareStatement(UpdateOrder);
					int rowAffected = pst.executeUpdate();
//					JOptionPane.showMessageDialog(null, "DOne");
					pst.close();
					connection.close();
					if(rowAffected==1) {
						JOptionPane.showMessageDialog(null, "Order set to Not Completed");
						TockenStatus.setText("false");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
//				JOptionPane.showMessageDialog(null, searchTocken);	
			
			}
		});
		btnSetOrderNot.setForeground(new Color(255, 255, 255));
		btnSetOrderNot.setBackground(new Color(255, 140, 0));
		btnSetOrderNot.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSetOrderNot.setBounds(199, 306, 210, 45);
		btnSetOrderNot.setVisible(false);
		NotComplete.add(btnSetOrderNot);
		
		
		searchTocken = new JTextField("Search Tocken number here...");
		searchTocken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection connection = DbConnection.dbConnector();
					if(searchTocken.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Enter Tocken Number!!!","Tocken Error",JOptionPane.ERROR_MESSAGE);
					}
					for (int i = 0; i < searchTocken.getText().length(); i++) {
						if (Character.isDigit(searchTocken.getText().charAt(i)) == false) { 
					            
							JOptionPane.showMessageDialog(null, "Please enter a Number","Input Error",JOptionPane.ERROR_MESSAGE);
							searchTocken.requestFocusInWindow();
							break;
						} 
					}
					String TockenName = searchTocken.getText().trim();	
					String SearchQuery="SELECT FullName,TotalPrice,AdvancePaid,"
							+ "AmountDue,TockenNo,Status as Dilevery FROM Orders WHERE TockenNo="+TockenName+"  ORDER BY OrderId DESC";
					PreparedStatement pst  = connection.prepareStatement(SearchQuery);
					ResultSet rs = pst.executeQuery();
					if(rs.isClosed()) {
						JOptionPane.showMessageDialog(null, "Wrong Tocken Number!!!","Tocken Error",JOptionPane.ERROR_MESSAGE);
					}else {
						lblTockenNo.setVisible(true);
						TockenNo.setVisible(true);
						TockenStatus.setVisible(true);
						lblName.setVisible(true);
						lablname.setVisible(true);
						lblStatus.setVisible(true);
						TockenButton.setVisible(true);
						cancelOrder.setVisible(true);
						btnSetOrderNot.setVisible(true);
					}
					lablname.setText(rs.getString(1));
					TockenNo.setText(rs.getString(5));
					TockenStatus.setText(rs.getString(6));
					table.setFont(new Font("Tohama", Font.BOLD , 17));
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.getColumnModel().getColumn(0).setPreferredWidth(180);
					
					
//					int c = table.getRowCount();
					
					rs.close();
					connection.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		searchTocken.setFont(new Font("Tahoma", Font.BOLD, 16));
		searchTocken.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if (searchTocken.getText().equals("Search Tocken number here...")) {
					searchTocken.setText("");
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (searchTocken.getText().isEmpty()) {
					searchTocken.setText("Search Tocken number here...");
		        }
			}
		});
		
		searchTocken.setBackground(new Color(255, 248, 220));
		searchTocken.setBounds(254, 11, 591, 37);
		panel_4.add(searchTocken);
		searchTocken.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(419, 108, 734, 524);
		NotComplete.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		JLabel label = new JLabel("");
		label.setBounds(321, 415, 46, 14);
		NotComplete.add(label);
		
		
		JPanel ViewOrders = new JPanel();
		ViewOrders.setBackground(new Color(255, 248, 220));
		layeredPane.add(ViewOrders, "name_115975718483800");
		ViewOrders.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 250, 205));
		panel_7.setBounds(10, 166, 1145, 477);
		ViewOrders.add(panel_7);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		scrollPane_1.setBounds(0, 11, 1145, 455);
		panel_7.add(scrollPane_1);
		
		
		
		JLabel CustomerFullname = new JLabel("name");
		CustomerFullname.setFont(new Font("Tahoma", Font.BOLD, 15));
		CustomerFullname.setBounds(25, 96, 277, 34);
		ViewOrders.add(CustomerFullname);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(449, 96, 47, 34);
		ViewOrders.add(lblTotal);
		
		CustomerFullTotal = new JTextField();
		CustomerFullTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		CustomerFullTotal.setBounds(506, 91, 80, 42);
		ViewOrders.add(CustomerFullTotal);
		CustomerFullTotal.setColumns(10);
		
		
		JLabel lblOrderDate = new JLabel("Order date");
		lblOrderDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderDate.setBounds(312, 96, 127, 34);
		ViewOrders.add(lblOrderDate);
		
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(46, 139, 87));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fname = CustomerFullname.getText().toString();
				int TotalToUpdate =Integer.parseInt( CustomerFullTotal.getText());
				String OrderedDate = lblOrderDate.getText();
				try {
					Connection connection = DbConnection.dbConnector();
					String SearchQuery="UPDATE Orders SET TotalPrice="+TotalToUpdate+" WHERE FullName='"+fname+"' AND OrderDate='"+OrderedDate+"';";
					PreparedStatement pst  = connection.prepareStatement(SearchQuery);
					int rowAffected = pst.executeUpdate();
					pst.close();
					connection.close();
					if(rowAffected==1) {
						JOptionPane.showMessageDialog(null, "Record Updated Successfully!!!");
						TockenStatus.setText("True");
					}
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(615, 91, 91, 42);
		ViewOrders.add(btnUpdate);
	
		
		AllOrders = new JTable();
		AllOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = AllOrders.getSelectedRow();
					  eve =  AllOrders.getModel().getValueAt(row, 0);
					 
					
					 
					 
					String name = AllOrders.getValueAt(AllOrders.getSelectedRow(),1).toString();
					String orderedDate =  AllOrders.getValueAt(AllOrders.getSelectedRow(), 2).toString();
					String Total =  AllOrders.getValueAt(AllOrders.getSelectedRow(), 3).toString();
					
					CustomerFullname.setText(name);
					CustomerFullTotal.setText(Total);
					lblOrderDate.setText(orderedDate);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					String name = AllOrders.getValueAt(AllOrders.getSelectedRow(), 1).toString();
					Connection connection = DbConnection.dbConnector();
					String SearchQuery="SELECT OrderId,FullName,OrderDate,TotalPrice,Frame,RSph,RCyl,"
							+ "RAxis,RNear,LSph,LCyl,LAxis,LNear FROM Orders WHERE FullName like '"+name+"%'";
					PreparedStatement pst  = connection.prepareStatement(SearchQuery);
					ResultSet rs = pst.executeQuery();
					AllOrders.setFont(new Font("Tohama", Font.BOLD , 17));
					AllOrders.setModel(DbUtils.resultSetToTableModel(rs));
//					AllOrders.getColumnModel().getColumn(0).setPreferredWidth(0);
//					AllOrders.removeColumn(AllOrders.getColumnModel().getColumn(0));
					AllOrders.getColumnModel().getColumn(0).setPreferredWidth(0);
					AllOrders.getColumnModel().getColumn(1).setPreferredWidth(250);
					AllOrders.getColumnModel().getColumn(2).setPreferredWidth(100);
					AllOrders.getColumnModel().getColumn(3).setPreferredWidth(100);
					
					
					rs.close();
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		scrollPane_1.setViewportView(AllOrders);
		
		SearchOrder = new JTextField();
		SearchOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SearchOrder.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Input Field cannot be Empty!!!","Input Error",JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						Connection connection = DbConnection.dbConnector();
						String SearchQuery="SELECT OrderId,FullName,OrderDate,TotalPrice,Frame,RSph,RCyl,RAxis,RNear,"
								+ "LSph,LCyl,LAxis,LNear FROM Orders"
								+ " WHERE Status='true'  AND FullName like ? OR Mobile=? ";
						PreparedStatement pst  = connection.prepareStatement(SearchQuery);
						pst.setString(1, "%"+SearchOrder.getText().trim()+"%");
						pst.setString(2, SearchOrder.getText().trim());
						ResultSet rs = pst.executeQuery();
						AllOrders.setFont(new Font("Tohama", Font.BOLD , 17));
						AllOrders.setModel(DbUtils.resultSetToTableModel(rs));
//						AllOrders.getColumnModel().getColumn(0).setPreferredWidth(0);
//						AllOrders.removeColumn(AllOrders.getColumnModel().getColumn(0));
//						AllOrders.getColumnModel().getColumn(0).setPreferredWidth(180);
						AllOrders.getColumnModel().getColumn(0).setPreferredWidth(0);
						AllOrders.getColumnModel().getColumn(1).setPreferredWidth(250);
						AllOrders.getColumnModel().getColumn(2).setPreferredWidth(100);
						rs.close();
						connection.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		SearchOrder.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (SearchOrder.getText().equals("Search Name or Mobile here...")) {
					SearchOrder.setText("");
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (SearchOrder.getText().isEmpty()) {
					SearchOrder.setText("Search Name or Mobile here...");
		        }
			}
		});
		SearchOrder.setText("Search Name or Mobile here...");
		SearchOrder.setBackground(new Color(255, 248, 220));
		SearchOrder.setFont(new Font("Tahoma", Font.BOLD, 17));
		SearchOrder.setBounds(297, 23, 541, 34);
		ViewOrders.add(SearchOrder);
		SearchOrder.setColumns(10);
		
		JButton btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null,"Sure you want to Delete Record ?","Warning",
			            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					
				
					try {
						Connection connection = DbConnection.dbConnector();
						String SearchQuery="DELETE FROM Orders  WHERE OrderId='"+eve+"';";
						PreparedStatement pst  = connection.prepareStatement(SearchQuery);
						int rowAffected = pst.executeUpdate();
						pst.close();
						connection.close();
						if(rowAffected==1) {
							JOptionPane.showMessageDialog(null, "Record Deleted");
							TockenStatus.setText("True");
						}
						connection.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			           
				
			}
		});
		btnDeleteRecord.setForeground(Color.WHITE);
		btnDeleteRecord.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteRecord.setBackground(new Color(139, 0, 0));
		btnDeleteRecord.setBounds(736, 91, 156, 42);
		ViewOrders.add(btnDeleteRecord);
		
		
		
		
		
		
		JPanel Report = new JPanel();
		Report.setBackground(new Color(255, 248, 220));
		layeredPane.add(Report, "name_115994530574700");
		Report.setLayout(null);
		
		JDateChooser FromdateChooser = new JDateChooser();
		FromdateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		FromdateChooser.setBackground(new Color(255, 248, 220));
		
		FromdateChooser.setBounds(381, 29, 118, 23);
		Report.add(FromdateChooser);
		
		
		JDateChooser TodateChooser = new JDateChooser();
		TodateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 14));
		TodateChooser.setBackground(new Color(255, 248, 220));
		TodateChooser.setBounds(650, 29, 118, 23);
		Report.add(TodateChooser);
		
		
		JLabel lblTotalSale = new JLabel("Total Sale :");
		lblTotalSale.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalSale.setBounds(408, 506, 84, 29);
		Report.add(lblTotalSale);
		lblTotalSale.setVisible(false);
		
		JLabel lblTotalAdvance = new JLabel("T. Advance :");
		lblTotalAdvance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalAdvance.setBounds(408, 546, 94, 29);
		Report.add(lblTotalAdvance);
		lblTotalAdvance.setVisible(false);
		
		JLabel lblTotalBalance = new JLabel("T. Balance :");
		lblTotalBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalBalance.setBounds(408, 586, 94, 29);
		Report.add(lblTotalBalance);
		lblTotalBalance.setVisible(false);
		
		JLabel txtTotalSale = new JLabel("");
		txtTotalSale.setForeground(new Color(0, 100, 0));
		txtTotalSale.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTotalSale.setBounds(515, 506, 94, 29);
		Report.add(txtTotalSale);
		
		JLabel txtTotalAdvance = new JLabel("");
		txtTotalAdvance.setForeground(new Color(139, 0, 0));
		txtTotalAdvance.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTotalAdvance.setBounds(515, 546, 94, 29);
		Report.add(txtTotalAdvance);
		
		JLabel txtTotalBalance = new JLabel("");
		txtTotalBalance.setForeground(new Color(255, 140, 0));
		txtTotalBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTotalBalance.setBounds(515, 586, 94, 29);
		Report.add(txtTotalBalance);
		
		
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				try {
					SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
					String FromDate = sdf.format(FromdateChooser.getDate());
					String ToDate = sdf.format(TodateChooser.getDate());
					Connection connection = DbConnection.dbConnector();
					String ReportQuery="SELECT FullName,OrderDate,TockenNo as BillNo,TotalPrice as Total_Sale, Status as Delivery  from Orders WHERE"
							+ " ( OrderDate BETWEEN '"+FromDate+"' AND '"+ToDate+"'+ ' 23:59:59')";
					
					
					String TotalQuery="SELECT SUM(TotalPrice) as 'Total Sale', SUM(AdvancePaid) as 'Total Advance',SUM(AmountDue) as 'Total Balance' FROM Orders where"
							+ " ( OrderDate BETWEEN '"+FromDate+"' AND '"+ToDate+"'+ ' 23:59:59')";
					PreparedStatement pst  = connection.prepareStatement(ReportQuery);
					
					PreparedStatement pst1  = connection.prepareStatement(TotalQuery);
					ResultSet rs = pst.executeQuery();
					ResultSet rs1 = pst1.executeQuery();
					ReportTable.setFont(new Font("Tohama", Font.BOLD , 17));
					ReportTable.setModel(DbUtils.resultSetToTableModel(rs));
					ReportTable.setRowHeight(35);
					JTableHeader tableHeader = ReportTable.getTableHeader();
				      Font headerFont = new Font("Tohama", Font.BOLD, 18);
				      tableHeader.setFont(headerFont);
				      
					ReportTable.getColumnModel().getColumn(0).setPreferredWidth(180);
					ReportTable.getColumnModel().getColumn(1).setPreferredWidth(100);
					ReportTable.getColumnModel().getColumn(2).setPreferredWidth(100);
					lblTotalSale.setVisible(true);
					lblTotalAdvance.setVisible(false);
					lblTotalBalance.setVisible(false);
					txtTotalSale.setText(rs1.getString(1));
					txtTotalAdvance.setVisible(false);
					txtTotalBalance.setVisible(false);
					rs.close();
					connection.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please Select From and to date...");
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(807, 22, 66, 36);
		Report.add(btnNewButton);
		
		JLabel lblFrom = new JLabel("From :");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFrom.setBounds(318, 29, 53, 23);
		Report.add(lblFrom);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setBounds(613, 29, 27, 23);
		Report.add(lblTo);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 63, 1147, 415);
		Report.add(scrollPane_2);
		
		ReportTable = new JTable();
		scrollPane_2.setViewportView(ReportTable);
		
		JButton btnTodaysReport = new JButton("Today's Report");
		btnTodaysReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					 LocalDateTime myDateObj = LocalDateTime.now();
					 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					    formattedDate = myDateObj.format(myFormatObj);
					Connection connection = DbConnection.dbConnector();
					String ReportQuery="SELECT FullName,TockenNo as BillNo,TotalPrice as Sale, AdvancePaid as Advance, AmountDue as Balance,Status as Delivery  from Orders where"
							+ " (  OrderDate='"+formattedDate+"')";
					String TotalQuery="SELECT SUM(TotalPrice) as 'Total Sale', SUM(AdvancePaid) as 'Total Advance',SUM(AmountDue) as 'Total Balance' FROM Orders where"
							+ " ( OrderDate='"+formattedDate+"')";
					PreparedStatement pst  = connection.prepareStatement(ReportQuery);
					
					PreparedStatement pst1  = connection.prepareStatement(TotalQuery);
					ResultSet rs = pst.executeQuery();
					ResultSet rs1 = pst1.executeQuery();
					ReportTable.setFont(new Font("Tohama", Font.BOLD , 17));
					ReportTable.setModel(DbUtils.resultSetToTableModel(rs));
					ReportTable.setRowHeight(35);
					JTableHeader tableHeader = ReportTable.getTableHeader();
				      Font headerFont = new Font("Tohama", Font.BOLD, 18);
				      tableHeader.setFont(headerFont);
				      
					ReportTable.getColumnModel().getColumn(0).setPreferredWidth(180);
					ReportTable.getColumnModel().getColumn(1).setPreferredWidth(100);
					ReportTable.getColumnModel().getColumn(2).setPreferredWidth(100);
					lblTotalSale.setVisible(true);
					lblTotalAdvance.setVisible(true);
					lblTotalBalance.setVisible(true);
					txtTotalSale.setVisible(true);
					txtTotalAdvance.setVisible(true);
					txtTotalBalance.setVisible(true);
					txtTotalSale.setText(rs1.getString(1));
					txtTotalAdvance.setText(rs1.getString(2));
					txtTotalBalance.setText(rs1.getString(3));
					rs.close();
					connection.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please Select From and to date...");
					e2.printStackTrace();
				}
			}
		});
		btnTodaysReport.setForeground(Color.WHITE);
		btnTodaysReport.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTodaysReport.setBackground(new Color(178, 34, 34));
		btnTodaysReport.setBounds(71, 22, 181, 36);
		Report.add(btnTodaysReport);
		

	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(0, 0, 1368, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAbcComp = new JLabel("Raj Opticals");
		lblAbcComp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbcComp.setFont(new Font("Roboto Mono Medium", Font.BOLD, 18));
		lblAbcComp.setBounds(10, -1, 1358, 64);
		panel.add(lblAbcComp);
		
		TimeLabel = new JLabel("New label");
		TimeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		TimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Date date = new Date(); 
		DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		String time = timeFormat.format(date);
		
		TimeLabel.setText(time);
		
		TimeLabel.setBounds(1232, 2, 115, 62);
		panel.add(TimeLabel);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(10, 0, 78, 64);
		panel.add(logo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(0, 64, 191, 654);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnPanel = new JButton("New Order");
		btnPanel.setBackground(new Color(255, 127, 80));
		btnPanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPanel.setBounds(10, 53, 160, 44);
		panel_1.add(btnPanel);
		
		JButton btnPanel_1 = new JButton("Not Complete");
		btnPanel_1.setBackground(new Color(255, 127, 80));
		btnPanel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPanel_1.setBounds(10, 130, 161, 44);
		panel_1.add(btnPanel_1);
		
		JButton btnPanel_2 = new JButton("View Orders");
		btnPanel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DbConnection.dbConnector();
					String Viewquery = "SELECT OrderId,FullName,OrderDate,TotalPrice as Total,Mobile,Frame,Glass,"
							+ "SunGlass,TotalPrice as Total, AmountDue as Balance FROM Orders where Status='true' ORDER BY OrderDate DESC";
					PreparedStatement pst  = connection.prepareStatement(Viewquery);
					ResultSet rs = pst.executeQuery();
					
					AllOrders.setFont(new Font("Tohama", Font.PLAIN , 16));
					AllOrders.setModel(DbUtils.resultSetToTableModel(rs));
					 Dimension dim = new Dimension(2,2);
					 AllOrders.setRowHeight(35);
					 AllOrders.setIntercellSpacing(new Dimension(dim));
					 JTableHeader tableHeader = AllOrders.getTableHeader();
				      Font headerFont = new Font("Tohama", Font.BOLD, 18);
				      tableHeader.setFont(headerFont);
//				      AllOrders.removeColumn(AllOrders.getColumnModel().getColumn(0));
//					AllOrders.getColumnModel().getColumn(0).setPreferredWidth(0);
					AllOrders.getColumnModel().getColumn(0).setPreferredWidth(1);
					AllOrders.getColumnModel().getColumn(1).setPreferredWidth(250);
					rs.close();
					connection.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
				layeredPane.removeAll();
				layeredPane.add(ViewOrders);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnPanel_2.setBackground(new Color(255, 127, 80));
		btnPanel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPanel_2.setBounds(10, 209, 160, 44);
		panel_1.add(btnPanel_2);
		
		JButton btnPanel_3 = new JButton("Report");
		btnPanel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Report);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnPanel_3.setBackground(new Color(255, 127, 80));
		btnPanel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPanel_3.setBounds(10, 291, 161, 44);
		panel_1.add(btnPanel_3);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 160, 122));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Sure you want to Exit ?","Raj Opticals",
			            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			            System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(10, 571, 160, 44);
		panel_1.add(btnExit);
		
		JButton btnPanel_4 = new JButton("Admin Settings");
		btnPanel_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPanel ad = new AdminPanel();
				ad.setVisible(true);
			}
		});
		btnPanel_4.setBackground(new Color(255, 127, 80));
		btnPanel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPanel_4.setBounds(10, 516, 160, 44);
		panel_1.add(btnPanel_4);
		
		btnPanel_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Connection connection = DbConnection.dbConnector();
				
				lblTockenNo.setVisible(false);
				lblName.setVisible(false);
				lblStatus.setVisible(false);
				TockenNo.setVisible(false);
				TockenStatus.setVisible(false);
				lblName.setVisible(false);
				TockenButton.setVisible(false);
				cancelOrder.setVisible(false);
				lablname.setVisible(false);
				btnSetOrderNot.setVisible(false);
				layeredPane.removeAll();
				layeredPane.add(NotComplete);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				try {
					String Viewquery = "SELECT TockenNo,FullName,OrderDate,TotalPrice as Total,"
							+ "AdvancePaid as Advance,AmountDue as Balance,Status as Dilevery FROM "
							+ "Orders where Status='false' ORDER BY OrderDate DESC";
					PreparedStatement pst  = connection.prepareStatement(Viewquery);
					ResultSet rs = pst.executeQuery();
					
					table.setFont(new Font("Tohama", Font.PLAIN , 15));
					table.setModel(DbUtils.resultSetToTableModel(rs));
					JTableHeader tableHeader = table.getTableHeader();
				      Font headerFont = new Font("Tohama", Font.BOLD, 16);
				      tableHeader.setFont(headerFont);
					table.setRowHeight(35);
					table.getColumnModel().getColumn(0).setPreferredWidth(60);
					table.getColumnModel().getColumn(1).setPreferredWidth(170);
					table.getColumnModel().getColumn(5).setPreferredWidth(50);
					table.getColumnModel().getColumn(6).setPreferredWidth(40);
					rs.close();
					connection.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		btnPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Total=0;
				FullName.setText("");
				txtMobile.setText("");
				Fqty.setText("1");
				Fprice.setText("");
				Gprice.setText("");
				Gqty.setText("1");
				txtSun.setText("");
				SunQty.setVisible(false);
				OtherPrice.setText("");
				TotalAmt.setText("");
				AdvPaid.setText("");
				DueAmt.setText("");
				Discount.setText("");
				OtherTxt.setText("");
				TxtDiscountPrice="";
				TxtDiscount="";
				p1price="";
				p1qty="";
				p1total="";
				p1="";
				p2price="";
				p2qty="";
				p2total="";
				p2="";
				p3price="";
				p3qty="";
				p3total="";
				p3="";
				p4price="";
				p4total="";
				p4="";
				OtherReason="";
				DiscountAmt=0;
				AddedToDb=0;
				TotalBeforeDiscount=0;
				TotalAfterDiscount=0;
				Discount.setText("");
				 RSph="";
				 RCyl="";
				 RAxis="";
				 RNear="";
				 LSph="";
				 LCyl="";
				 LAxis="";
				 LNear="";
				 RtxtSph.setText("");
				 RtxtCyl.setText("");
				 RtxtAxis.setText("");
				 RtxtNear.setText("");
				 LtxtSph.setText("");
				 LtxtCyl.setText("");
				 LtxtAxis.setText("");
				 LtxtNear.setText("");
				PrintArea.setText("");
				Frametype="";
				PrintArea.setVisible(false);
				lblOtherTxt.setVisible(false);
				OtherTxt.setVisible(false);
				Discount.setVisible(false);
				chckbxDiscount.setSelected(false);
				LtxtNear.setVisible(false);
				chckbxFrameFull.setSelected(false);
				chckbxFrame3Piece.setSelected(false);
				chckbxFrameSupra.setSelected(false);
				chckbxFrameFull.setVisible(false);
				chckbxFrameSupra.setVisible(false);
				chckbxFrame3Piece.setVisible(false);
				chckbxFrame.setSelected(false);
				chckbxGlass.setSelected(false);
				chckbxOther.setSelected(false);
				chckbxSunGlasses.setSelected(false);
				lblFramePrice.setVisible(false);
				lblGlassPrice.setVisible(false);
				lblLeftEye.setVisible(false);
				lblSun.setVisible(false);
				lblOther.setVisible(false);
				lblQuantity.setVisible(false);
				lblGQty.setVisible(false);
				OtherPrice.setVisible(false);
				lblRightEye.setVisible(false);
				lblLeftEye.setVisible(false);
				txtSun.setVisible(false);
				Fprice.setVisible(false);
				Gprice.setVisible(false);
				SQty.setVisible(false);
				Fqty.setVisible(false);
				Gqty.setVisible(false);
				RlblSph.setVisible(false);
				RtxtSph.setVisible(false);
				RlblCyl.setVisible(false);
				RtxtCyl.setVisible(false);
				RlblAxis.setVisible(false);
				RtxtAxis.setVisible(false);
				RlblNear.setVisible(false);
				RtxtNear.setVisible(false);
				LlblSph.setVisible(false);
				LtxtSph.setVisible(false);
				LlblCyl.setVisible(false);
				LtxtCyl.setVisible(false);
				LlblAxis.setVisible(false);
				LtxtAxis.setVisible(false);
				LlblNear.setVisible(false);
				P1Total=0;
				P2Total=0;
				P3Total=0;
				P4Total=0;
				
				layeredPane.removeAll();
				layeredPane.add(NewOrder);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
	}
}
