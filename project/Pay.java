import java.awt.*;
import javax.swing.*;
import java.awt.print.*;
import java.awt.event.*;
import java.sql.*;
public class Pay extends JFrame implements ActionListener,Printable
{
	JLabel lblLabel=new JLabel("Payslip");
	JLabel lblId=new JLabel("Emp_id");
	JLabel lblId1=new JLabel("");
	JLabel lblName=new JLabel("Emp_Name");
	JLabel lblName1=new JLabel("");
	JLabel lblDepart=new JLabel("Department");
	JLabel lblDepart1=new JLabel("");
	JLabel lblDesign=new JLabel("Designation");
	JLabel lblDesign1=new JLabel("");
	JLabel lblAddress=new JLabel("Address");
	JLabel lblAddress1=new JLabel("");
	JLabel lblTotWork=new JLabel("Total Work");
	JLabel lblTotWork1=new JLabel("");
	JLabel lblAttend=new JLabel("Total Attendence");
	JLabel lblAttend1=new JLabel("");
	JLabel lblSal=new JLabel("Salary");
	JLabel lblSal1=new JLabel("");
	JLabel lblAllow=new JLabel("Allowance");
	JLabel lblAllow1=new JLabel("");
	JLabel lblPf=new JLabel("PF");
	JLabel lblPf1=new JLabel("");
	JPanel panel=new JPanel();
	JButton btnPrint=new JButton("print",new ImageIcon("print.png"));
	Connection con;
	int p,a,sal;
	{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			PreparedStatement pst=con.prepareStatement("select empid,empname,department,desination,address from empp1 where empid=?");
			pst.setString(1,PaySlp.txtId.getText());
			ResultSet rst=pst.executeQuery();
			if (rst.next())
			{
				lblId1.setText(rst.getString(1));
				lblName1.setText(rst.getString(2));
				lblDepart1.setText(rst.getString(3));
                lblDesign1.setText(rst.getString(4));		
				lblAddress1.setText(rst.getString(5));
			}
			pst=con.prepareStatement("select count(*) from attendance where attendance='Present' and empid=? and to_char(empdate,'Month')=to_char(sysdate,'Month')");
			pst.setString(1,PaySlp.txtId.getText());
			rst=pst.executeQuery();
			if (rst.next())
			{
					p=rst.getInt(1);
			}
			pst=con.prepareStatement("select count(*) from attendance where attendance='Absent' and empid=? and to_char(empdate,'Month')=to_char(sysdate,'Month')");
			pst.setString(1,PaySlp.txtId.getText());
			rst=pst.executeQuery();
			if (rst.next())
			{
					a=rst.getInt(1);
			}
			pst=con.prepareStatement("select salary from sal where desid=(select desig_id from desig where desig_name=( select desination from empp1 where empid=?))"); 
			pst.setString(1,PaySlp.txtId.getText());
			rst=pst.executeQuery();
			if (rst.next())
			{
					sal=rst.getInt(1);
					System.out.println(sal);
			}
			
		}
			catch(Exception ee){System.out.println(ee);}
	}
	Pay()
	{	
		panel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("Leave1.jpg").getImage(),4,4,600,580,null);
			}
		};
		add(panel);
		panel.setLayout(null);
		panel.setBounds(230,100,600,580);
		lblLabel.setBounds(0,0,500,40);panel.add(lblLabel);
		lblLabel.setHorizontalAlignment(JLabel.CENTER);
		lblLabel.setFont(new Font("Forte",Font.BOLD+Font.ITALIC,50));
		lblId.setBounds(100,60,100,20);panel.add(lblId);
		lblId1.setBounds(250,60,100,20);panel.add(lblId1);
		lblName.setBounds(100,100,100,20);panel.add(lblName);
		lblName1.setBounds(250,100,100,20);panel.add(lblName1);
		lblDepart.setBounds(100,140,100,20);panel.add(lblDepart);
		lblDepart1.setBounds(250,140,100,20);panel.add(lblDepart1);
		lblDesign.setBounds(100,180,100,20);panel.add(lblDesign);
		lblDesign1.setBounds(250,180,100,20);panel.add(lblDesign1);
		lblAddress.setBounds(100,220,100,20);panel.add(lblAddress);
		lblAddress1.setBounds(250,220,100,20);panel.add(lblAddress1);
		lblTotWork.setBounds(100,260,100,20);panel.add(lblTotWork);
		lblTotWork1.setBounds(250,260,100,20);panel.add(lblTotWork1);
		lblAttend.setBounds(100,300,100,20);panel.add(lblAttend);
		lblAttend1.setBounds(250,300,100,20);panel.add(lblAttend1);
		lblSal.setBounds(100,340,100,20);panel.add(lblSal);
		lblSal1.setBounds(250,340,200,20);panel.add(lblSal1);
		lblAllow.setBounds(100,380,100,20);panel.add(lblAllow);
		lblAllow1.setBounds(250,380,100,20);panel.add(lblAllow1);
		lblPf.setBounds(100,420,100,20);panel.add(lblPf);
		lblPf1.setBounds(250,420,200,20);panel.add(lblPf1);
		btnPrint.setBounds(200,500,100,30);panel.add(btnPrint);
		
		
		/*lblId1.setText(Employee1.txtId.getText());
		lblName1.setText(Employee1.txtName.getText());
		lblDepart1.setText(Employee1.txtDepartment.getText());
	    lblDesign1.setText(Employee1.txtDesignation.getText());
		lblAddress1.setText(Employee1.txtAddress.getText());*/
		lblAttend1.setText(""+p);
		lblTotWork1.setText(""+(p+a));
		System.out.println(sal/30*a);
		lblSal1.setText(""+(sal-(sal/30*a)));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btnPrint.addActionListener(this);
		setSize(600,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ee)
	{
		PrinterJob pj=PrinterJob.getPrinterJob();
		PageFormat pf=pj.pageDialog(pj.defaultPage());
		pj.setPrintable(this,pf);
		if(pj.printDialog())
		{
			try
			{
				pj.print();
			}
			catch(Exception e)
			{}
		}
	}
	public int print(Graphics g,PageFormat pf,int i) throws PrinterException
		{
			if (i<0)
			{
				return NO_SUCH_PAGE;
			}
			Graphics2D g2d=(Graphics2D)g;
			g2d.translate(pf.getImageableX(),pf.getImageableY());
			printAll(g2d);
			return PAGE_EXISTS;	
		}
}












