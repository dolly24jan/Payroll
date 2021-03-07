import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Allowance extends JFrame implements FocusListener,ActionListener
{
	JLabel lblTitle= new JLabel("Salary Allowance");
	JLabel lblId=new JLabel("Emp_id:");
	JLabel lblBasic=new JLabel("Basic:");
	JTextField txtId=new JTextField();
	JTextField txtBasic=new JTextField();
	JButton btnCal=new JButton("CALCULATE ALLOWANCE");
	JLabel lblImage=new JLabel(new ImageIcon("logo.jpg"));
	//JLabel lblImg=new JLabel(new ImageIcon("payroll_img.jpg"));
	Font fnt1=new Font("Tahoma",Font.BOLD,14);
	JPanel panel;
	JPanel panel1;
	static int w,h;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	{
			try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:project","system","ORACLE");
		}
		catch(Exception ee){}
	}
    		
	int sal;
	Allowance()
	{
		
		super("Allowance");
		setLayout(null);
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		w=(int) d.getWidth();
		h=(int) d.getHeight();
		panel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("payroll_bg.jpg").getImage(),0,0,w,h,null);
			}
		};
		panel1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
			g.fillRect(0,0,880,500);
			g.drawImage(new ImageIcon("payroll_img.jpg").getImage(),4,4,872,490,null);
				
			}
		};
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		setSize(w,h);
		panel.setBounds(0,0,w,h);
		panel1.setBounds(230,100,880,500);
		panel.setLayout(null);
		panel1.setLayout(null);
		add(panel);
		panel.add(panel1);
		lblImage.setBounds(10,0,200,150);panel.add(lblImage);
		//lblImg.setBounds(10,120,312,485);panel.add(lblImg);
		lblTitle.setBounds(40,60,850,40);panel1.add(lblTitle);
		lblTitle.setFont(new Font("Castellar",Font.BOLD,40));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setForeground(new Color(0,0,255));
		lblId.setBounds(250,200,200,25);panel1.add(lblId);lblId.setFont(new Font("Arial Black",Font.BOLD,20));
		txtId.setBounds(450,200,230,30);panel1.add(txtId);
		lblBasic.setBounds(250,280,200,25);panel1.add(lblBasic);lblBasic.setFont(new Font("Arial Black",Font.BOLD,20));
		txtBasic.setBounds(450,280,230,30);panel1.add(txtBasic);
		btnCal.setBounds(585,360,220,30);panel1.add(btnCal);btnCal.setFont(fnt1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setVisible(true);
		panel1.setVisible(true);
		panel.setSize(w,h);
		setVisible(true);
		txtId.addFocusListener(this);
		btnCal.addActionListener(this);
	}
	public void focusGained(FocusEvent f){}
	public void focusLost(FocusEvent f)
	{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			PreparedStatement pst=con.prepareStatement("select salary from sal where desid=(select desig_id from desig where desig_name=( select desination from empp1 where empid=?))"); 
			pst.setString(1,txtId.getText());
			ResultSet rst=pst.executeQuery();
			if (rst.next())
			{
				txtBasic.setText(rst.getInt(1)+"");
			}
		}
		catch(Exception ee){System.out.println(ee);}
	}
	public void actionPerformed(ActionEvent e)
	{
		try{
			float s=Integer.parseInt(txtBasic.getText());
			float da=0,hra=0,med=0,ta=0,pf=0;
			da=(10*s)/100;
			hra=(10*s)/100;
			med=(8*s)/100;
			ta=(8*s)/100;
			pf=(12*s)/100;
			ps=con.prepareStatement("insert into allowance values(?,?,?,?,?,?,sysdate)");
		    ps.setString(1,txtId.getText());
			ps.setFloat(2,da);
			ps.setFloat(3,hra);
			ps.setFloat(4,med);
			ps.setFloat(5,ta);
			ps.setFloat(6,pf);
			int n=ps.executeUpdate();
			if(n>0)
			{JOptionPane.showMessageDialog(this,"Data Inserted");}
			else
			{JOptionPane.showMessageDialog(this,"Data Not Inserted");}
		}
		catch(Exception ee){}
	}
		
	public static void main(String[]args)
	{
	new Allowance();
	}
}