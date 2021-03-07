import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Login extends JFrame implements ActionListener
{
	JLabel lblTitle= new JLabel("RAMAN AND KUMAR COSTRUCTION LTD.");
	JLabel lblUser=new JLabel("Enter User Id :");
	JLabel lblPass=new JLabel("Enter Password :");
	JTextField txtUser=new JTextField(20);
	JPasswordField txtPass=new JPasswordField(20);
	JButton btnLogin=new JButton("Login");
	JButton btnCancel=new JButton("Cancel");
	JButton btnPswd=new JButton("Change Password");
	JLabel lblImage=new JLabel(new ImageIcon("logo.jpg"));
	JPanel panel;//=new JPanel();
	JPanel panel1;//=new JPanel();
	static int w,h;
	Font fnt1=new Font("Tahoma",Font.BOLD,14);
	int flag=0;
	
	ChngPaswdWindow1 psd;
	ProgressBarDemo pd;
	Connection con;
	PreparedStatement prs;
	ResultSet rs;
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			//JOptionPane.showMessageDialog(this,"Connected");
		}
		catch(ClassNotFoundException e){System.out.println(e);}
		catch(SQLException r){System.out.println(r);}
		
	}
	
	
	Login()
	{
		super("Login Window");
		setLayout(null);
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		w=(int) d.getWidth();
		h=(int) d.getHeight();
		panel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("0004750.jpg").getImage(),0,0,w,h,null);
			}
		};
		panel1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
			g.fillRect(0,0,880,500);
			g.drawImage(new ImageIcon("logimage.jpg").getImage(),4,4,872,490,null);
				//g.drawImage(new ImageIcon("logimage.jpg").getImage(),0,0,880,500,null);
			}
		};
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		setSize(w,h);
		
		panel.setBounds(0,0,w,h);
		panel1.setBounds(230,100,880,500);
		
		panel.setLayout(null);
		panel1.setLayout(null);
		add(panel);
		panel.add(panel1);
		lblImage.setBounds(10,0,200,150);panel.add(lblImage);
		lblTitle.setBounds(40,60,850,40);
		//lblMessage2.setBounds(50,120,850,25);
		lblUser.setBounds(250,200,200,20);lblUser.setFont(new Font("Arial Black",Font.BOLD,20));
		txtUser.setBounds(450,200,230,25);
		lblPass.setBounds(250,280,200,20);lblPass.setFont(new Font("Arial Black",Font.BOLD,20));
		txtPass.setBounds(450,280,230,25);
		btnLogin.setBounds(285,360,160,30);btnLogin.setFont(fnt1);
		btnCancel.setBounds(495,360,160,30);btnCancel.setFont(fnt1);
		btnPswd.setBounds(385,415,170,30);btnPswd.setFont(fnt1);
		lblTitle.setFont(new Font("Algerian",Font.BOLD,40));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(lblTitle);
		panel1.add(lblUser);panel1.add(txtUser);
		panel1.add(lblPass);panel1.add(txtPass);
		panel1.add(btnLogin);panel1.add(btnCancel);panel1.add(btnPswd);
		panel.setVisible(true);
		panel1.setVisible(true);
		panel.setSize(w,h);
		setVisible(true);
		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		btnPswd.addActionListener(this);
		panel.setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==btnCancel)
			System.exit(0);
		if(e.getSource()==btnPswd)
		{
			psd=new ChngPaswdWindow1();
		}
		if(e.getSource()==btnLogin)
		{
			try{
				prs=con.prepareStatement("select * from login where userid=? and pass=?");
				prs.setString(1,txtUser.getText());
				prs.setString(2,txtPass.getText());
				rs=prs.executeQuery();
				if(rs.next())
				{
					pd=new ProgressBarDemo();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"InValid userid and password=?");
				}
			}
			catch(SQLException ee){}
			//pd=new JProgressDemo();
			
		}
	}
	public static void main(String[]args)
	{
		new Login();
	}
}
