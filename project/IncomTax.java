import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class IncomTax extends JFrame
{
	 static int w,h;
	 JLabel lblMessage=new JLabel("INCOME TAX");
	 JLabel lblImage=new JLabel(new ImageIcon("logo.jpg"));
	JLabel lblId=new JLabel("EMP_ID");
	JLabel lblId1=new JLabel("");
	JLabel lblNem=new JLabel("Emp_N");
	JLabel lblNem1=new JLabel("");
	JLabel lblAdd=new JLabel("Address");
	JLabel lblAdd1=new JLabel("");
	JLabel lblSal=new JLabel("Salary");
	JLabel lblSal1=new JLabel("");
	JLabel lblAllow=new JLabel("Allowance");
	JLabel lblAllow1=new JLabel("");
	JLabel lblTax=new JLabel("Income Tax");
	JLabel lblTax1=new JLabel("");
	JButton btnPrint=new JButton("Print");
	//ImagePanel panel=new ImagePanel("Attendence.jpg");
	JPanel panel;//=new Panel();
	JPanel panel1;
	
	Connection con;
	PreparedStatement pst;
	ResultSet rst;
	
	IncomTax()
	{
		super("Income Tax");
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension dim=toolkit.getScreenSize();
		h=(int)dim.getHeight();
		w=(int)dim.getWidth();
		panel1=new JPanel()
		{
			
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("MegaPay-1.png").getImage(),0,0,w,h,null);
				
			}
		};
		panel1.setLayout(null);
		
		panel=new JPanel()
		{
			
			public void paintComponent(Graphics g)
			{
				g.fillRect(0,0,680,500);
				g.drawImage(new ImageIcon("Attendence.jpg").getImage(),4,4,672,490,null);
				
			}
		};
		panel.setLayout(null);
	    lblImage.setBounds(10,0,200,150);panel1.add(lblImage);

		lblMessage.setBounds(80,30,500,30);panel.add(lblMessage);
		lblMessage.setHorizontalAlignment(JLabel.CENTER);
		lblMessage.setFont(new Font("Forte",Font.BOLD+Font.ITALIC,35));
		//lblId.setBounds(100,60,100,30);panel.add(lblId);lblId.setFont(new Font("Arial Black",Font.BOLD,14));
		//setLayout(null);
		panel.setBounds(280,100,680,500);
		panel1.setBounds(0,0,w,h);
		add (panel1);
		panel1.add(panel);
		lblId.setBounds(160,100,100,30);panel.add(lblId);lblId.setFont(new Font("Arial Black",Font.BOLD,14));
		lblId1.setBounds(330,100,100,30);panel.add(lblId1);lblId1.setFont(new Font("Arial Black",Font.BOLD,14));
		lblNem.setBounds(160,140,100,30);panel.add(lblNem);lblNem.setFont(new Font("Arial Black",Font.BOLD,14));
		lblNem1.setBounds(330,140,100,30);panel.add(lblNem1);lblNem1.setFont(new Font("Arial Black",Font.BOLD,14));
		lblAdd.setBounds(160,180,100,30);panel.add(lblAdd);lblAdd.setFont(new Font("Arial Black",Font.BOLD,14));
		lblAdd1.setBounds(330,180,100,30);panel.add(lblAdd1);lblAdd1.setFont(new Font("Arial Black",Font.BOLD,14));
		lblSal.setBounds(160,220,100,30);panel.add(lblSal);lblSal.setFont(new Font("Arial Black",Font.BOLD,14));
		lblSal1.setBounds(330,220,100,30);panel.add(lblSal1);lblSal1.setFont(new Font("Arial Black",Font.BOLD,14));
		lblAllow.setBounds(160,260,100,30);panel.add(lblAllow);lblAllow.setFont(new Font("Arial Black",Font.BOLD,14));
		lblAllow1.setBounds(330,260,100,30);panel.add(lblAllow1);lblAllow1.setFont(new Font("Arial Black",Font.BOLD,14));
		lblTax.setBounds(160,300,100,30);panel.add(lblTax);lblTax.setFont(new Font("Arial Black",Font.BOLD,14));
		lblTax1.setBounds(330,300,100,30);panel.add(lblTax1);lblTax1.setFont(new Font("Arial Black",Font.BOLD,14));

		btnPrint.setBounds(420,380,100,30);panel.add(btnPrint);btnPrint.setFont(new Font("Arial Black",Font.BOLD,16));
			panel1.setSize(w,h);
       setSize(w,h); 
          //  panel.setSize(600,600);    

        setVisible(true);
        panel.setVisible(true);
         panel.setBackground(new Color(247,223,179));
         setBackground(Color.blue);
		 	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			try
		{
			String id=JOptionPane.showInputDialog(this,"Enter Employee Id");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			pst=con.prepareStatement("select empname,Address from empp1 where empid=?");
			pst.setString(1,id);
			rst=pst.executeQuery();
			int flag=0;
			if(rst.next())
			{
				lblId1.setText(id);
				lblNem1.setText(rst.getString(1));
				lblAdd1.setText(rst.getString(2));
				flag=1;
			}
			else
				JOptionPane.showMessageDialog(this,"Employee Id Not Found");
			pst=con.prepareStatement("select sum(basic),sum(Allowance) from salary_slip where id=?");
			pst.setString(1,id);
			rst=pst.executeQuery();
			if(rst.next()&&flag==1)
			{
				lblSal1.setText(rst.getInt(1)+"");
				lblAllow1.setText(rst.getInt(2)+"");
			}
			else
			JOptionPane.showMessageDialog(this,"Employee Id Not Found");
			if(flag==1)
			{lblTax1.setText(((Integer.parseInt(lblSal1.getText())+Integer.parseInt(lblAllow1.getText()))*0.12)+"");}
		}
	catch(Exception e){JOptionPane.showMessageDialog(this,e);}
	}
	public static void main(String[]args)
	{
		new IncomTax();
	}
}