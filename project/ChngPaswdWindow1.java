import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class ChngPaswdWindow1 extends JFrame implements ActionListener
{
	//ImagePanel panel=new ImagePanel("key-lock.jpg");
	JLabel lblTitle= new JLabel("Change Password");
	JLabel lblId=new JLabel("Enter User-ID :");
	JLabel lblOldPass=new JLabel("Enter Old Password :");
	JLabel lblNewPass=new JLabel("Enter New Password :");
	JLabel lblCnfrmPass=new JLabel("Confirm Password :");
	JTextField txtId=new JTextField(20);
	JTextField txtNewPass=new JTextField(20);
	JTextField txtOldPass=new JTextField(20);
	JTextField txtCnfrmPass=new JTextField(20);
	JButton btnSave=new JButton("Save");
	JButton btnDispose=new JButton("Dispose");
	JPanel panel;
	JPanel panel1;
	JLabel lblImage=new JLabel(new ImageIcon("logo.jpg"));
	static int w,h;
	int flag=0;
		Connection con;
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			JOptionPane.showMessageDialog(this,"Do you want to change password?");
			
		}
		catch(SQLException e){}
		catch(ClassNotFoundException e){}
	}
	ChngPaswdWindow1()
	{
		super("Change Password");
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
			g.drawImage(new ImageIcon("key-lock.jpg").getImage(),4,4,872,490,null);
				//g.drawImage(new ImageIcon("key-lock.jpg").getImage(),0,0,880,500,null);
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
		lblTitle.setBounds(15,80,850,40);panel1.add(lblTitle);
	//	lblTitle.setBounds(30,10,400,50);panel.add(lblTitle);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setFont(new Font("Lucida calligraphy",Font.BOLD,40));
		lblId.setBounds(180,200,250,20);panel1.add(lblId);lblId.setFont(new Font("Arial Black",Font.BOLD,18));
		lblOldPass.setBounds(180,240,250,20);panel1.add(lblOldPass);lblOldPass.setFont(new Font("Arial Black",Font.BOLD,18));
		lblNewPass.setBounds(180,280,250,20);panel1.add(lblNewPass);lblNewPass.setFont(new Font("Arial Black",Font.BOLD,18));
		lblCnfrmPass.setBounds(180,320,250,20);panel1.add(lblCnfrmPass);lblCnfrmPass.setFont(new Font("Arial Black",Font.BOLD,18));
		txtId.setBounds(460,200,200,20);panel1.add(txtId);
		txtOldPass.setBounds(460,240,200,20);panel1.add(txtOldPass);
		txtNewPass.setBounds(460,280,200,20);panel1.add(txtNewPass);
		txtCnfrmPass.setBounds(460,320,200,20);panel1.add(txtCnfrmPass);
		btnSave.setBounds(290,360,100,20);panel1.add(btnSave);		
		btnDispose.setBounds(430,360,100,20);panel1.add(btnDispose);
		panel1.setSize(w,h);
		panel.setVisible(true);
		panel1.setVisible(true);
		setVisible(true);
		btnSave.addActionListener(this);
		btnDispose.addActionListener(this);
		panel.setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
public void actionPerformed(ActionEvent e)
	{

	 if(e.getSource()==btnSave)
		{
		
				if(txtNewPass.getText().equals(txtCnfrmPass.getText()))
					{
				try
				{
				PreparedStatement pst;
				pst=con.prepareStatement("update login set pass=? where userid=? and pass=?");
				pst.setString(1,txtNewPass.getText());
				pst.setString(2,txtId.getText());
				pst.setString(3,txtOldPass.getText());

				//pst.setString(4,txtrepassword.getText());
				if(pst.executeUpdate()>0)
					JOptionPane.showMessageDialog(this,"Password Changed");
				else
					JOptionPane.showMessageDialog(this,"Check Your userid and Old Password");
				}	
		    catch(SQLException ee){}
			}
			else
			{JOptionPane.showMessageDialog(this,"Check your Password and Re Enter Password");}
				}
		    else if(e.getSource()==btnDispose)
			{
				dispose();
			}
		
		}
	public static void main(String[]args)
	{
		new ChngPaswdWindow1();
	}
}