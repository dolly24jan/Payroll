import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class PaySlp extends JFrame implements FocusListener,ActionListener
{
	JLabel lblTitle= new JLabel("Genrate PaySlip");
	JLabel lblId=new JLabel("Emp-ID :");
	JLabel lblNem=new JLabel("Emp_Name :");
	JLabel lblMon=new JLabel("Select Month :");
	JLabel lblYear=new JLabel("Select Year :");
	static JTextField txtId=new JTextField(20);
	JTextField txtNem=new JTextField(20);
	JComboBox cmbMon=new JComboBox();
	JTextField txtYear=new JTextField(20);
	JButton btnPay=new JButton("PaySlip");
	JPanel panel;
	JPanel panel1;
	JLabel lblImage=new JLabel(new ImageIcon("logo.jpg"));
	static int w,h;
	Connection con;
	PreparedStatement pst;
	ResultSet rst;
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
		}
		catch(Exception e){}
		
               cmbMon.addItem("January");
               cmbMon.addItem("February");
               cmbMon.addItem("March");
               cmbMon.addItem("April");
               cmbMon.addItem("May");
               cmbMon.addItem("June");
               cmbMon.addItem("July");
               cmbMon.addItem("August");
               cmbMon.addItem("September");
               cmbMon.addItem("October");
               cmbMon.addItem("November");
               cmbMon.addItem("December");
	}
	PaySlp()
	{
		super("GenPay Window");
		setLayout(null);
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		w=(int) d.getWidth();
		h=(int) d.getHeight();
		panel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("IMG-20150630-WA0010.jpg").getImage(),0,0,w,h,null);
			}
		};
		panel1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
			g.fillRect(0,0,880,500);
			g.drawImage(new ImageIcon("buildng.jpg").getImage(),4,4,872,490,null);
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
		lblTitle.setBounds(15,80,850,60);panel1.add(lblTitle);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setFont(new Font("Lucida calligraphy",Font.BOLD,40));
		lblId.setBounds(180,200,250,20);panel1.add(lblId);lblId.setFont(new Font("Arial Black",Font.BOLD,18));
		lblNem.setBounds(180,240,250,20);panel1.add(lblNem);lblNem.setFont(new Font("Arial Black",Font.BOLD,18));
		lblMon.setBounds(180,280,250,20);panel1.add(lblMon);lblMon.setFont(new Font("Arial Black",Font.BOLD,18));
		lblYear.setBounds(180,320,250,20);panel1.add(lblYear);lblYear.setFont(new Font("Arial Black",Font.BOLD,18));
		txtId.setBounds(460,200,200,25);panel1.add(txtId);
		txtNem.setBounds(460,240,200,25);panel1.add(txtNem);
		cmbMon.setBounds(460,280,200,25);panel1.add(cmbMon);
		txtYear.setBounds(460,320,200,25);panel1.add(txtYear);
		btnPay.setBounds(700,390,100,30);panel1.add(btnPay);		
		panel1.setSize(w,h);
		panel.setVisible(true);
		panel1.setVisible(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		txtId.addFocusListener(this);
		txtNem.setEditable(false);
		btnPay.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
			if(!txtId.getText().equals(""))
		new Pay();
	}
	public void focusGained(FocusEvent f){}
	public void focusLost(FocusEvent f)
	{
	
		if(txtId.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Please insert id");
			return;
		}
		else
		{
		try{
			pst=con.prepareStatement("select empname from empp1 where empid=?");
			pst.setString(1,txtId.getText());
			rst=pst.executeQuery();
			if(rst.next())
			{
				txtNem.setText(rst.getString(1));
				cmbMon.setSelectedItem(new java.util.Date().getMonth());
				txtYear.setText(""+(new java.util.Date().getYear()+1900));
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Employee Id Not found");
			}
		}
		catch(Exception e){}
	}
	}
	public static void main(String[]args)
	{
		new PaySlp();
	}
}