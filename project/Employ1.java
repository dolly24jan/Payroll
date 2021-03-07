import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Employ1 extends JFrame implements ActionListener
{
	JLabel lblImage=new JLabel(new ImageIcon("logo.jpg"));
	JLabel lblEmployRec=new JLabel("Employ Record");
	JLabel lblName=new JLabel("Emp Name");
    JTextField txtName=new JTextField();
	JLabel lblId=new JLabel("Emp Id");
	JTextField txtId=new JTextField();
	JLabel lblAddress=new JLabel("Address");
	JTextField txtAddress=new JTextField();
	JScrollPane jspAddress=new JScrollPane(txtAddress);
	JLabel lblContacts=new JLabel("Contacts");
	JTextField txtContacts=new JTextField();
	JLabel lblSex=new JLabel("Gender");
	JRadioButton rdFemale=new JRadioButton("Female");
	JRadioButton rdMale=new JRadioButton("Male");
    JLabel lblDOB=new JLabel("DOB");
	JComboBox cmbDate=new JComboBox();
	JComboBox cmbMonth=new JComboBox();
	JComboBox cmbYear=new JComboBox();
	JLabel lblDoj=new JLabel("DOJ");
	JComboBox cmbDate1=new JComboBox();
	JComboBox cmbMonth1=new JComboBox();
	JComboBox cmbYear1=new JComboBox();
	JLabel lblQualification=new JLabel("Qualification");
	JComboBox cmbQualificatin=new JComboBox();
	JLabel lblDesignation=new JLabel("Designation");
	JTextField txtDesignation=new JTextField();
	JLabel lblDepartment=new JLabel("Department");
	JTextField txtDepartment=new JTextField();
	
	JButton btnSearch=new JButton("Search");
	JButton btnUpdate=new JButton("Update");
	JButton btnDelete=new JButton("Delete");
	JButton btnExit=new JButton("Exit");
	JPanel panel;
	JPanel panel1;
	Connection con;//Use For Stablished Connection between front-end and back-end
	PreparedStatement pst;
	{
		
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
		JOptionPane.showMessageDialog(this,"Connected");
		}
		catch(SQLException e){}
		catch(ClassNotFoundException e){}
	}
	static int w,h;
	int flag=0;

	{
		Toolkit t=Toolkit.getDefaultToolkit();
			Dimension d=t.getScreenSize();
			w=(int) d.getWidth();
			h=(int) d.getHeight();
      for(int i=1;i<=31;i++)
         cmbDate.addItem(""+i);
      for(int i=1980;i<=2020;i++)
               cmbYear.addItem(""+i);
               cmbMonth.addItem("January");
               cmbMonth.addItem("February");
               cmbMonth.addItem("March");
               cmbMonth.addItem("April");
               cmbMonth.addItem("May");
               cmbMonth.addItem("June");
               cmbMonth.addItem("July");
               cmbMonth.addItem("August");
               cmbMonth.addItem("September");
               cmbMonth.addItem("October");
               cmbMonth.addItem("November");
               cmbMonth.addItem("December");  
			  for(int j=1;j<=31;j++)
         cmbDate1.addItem(""+j);
      for(int j=1980;j<=2020;j++)
               cmbYear1.addItem(""+j);
               cmbMonth1.addItem("January");
               cmbMonth1.addItem("February");
               cmbMonth1.addItem("March");
               cmbMonth1.addItem("April");
               cmbMonth1.addItem("May");
               cmbMonth1.addItem("June");
               cmbMonth1.addItem("July");
               cmbMonth1.addItem("August");
               cmbMonth1.addItem("September");
               cmbMonth1.addItem("October");
               cmbMonth1.addItem("November");
               cmbMonth1.addItem("December");
			   cmbQualificatin.addItem("Matric");
		       cmbQualificatin.addItem("10+2");
		       cmbQualificatin.addItem("Under Graduation");
		       cmbQualificatin.addItem("Graduate");
			   cmbQualificatin.addItem("MBA");
		  
		}	  
		  Employ1()
		  {
			super("EMPLOYEE UPDATE");
			
			panel1=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					g.fillRect(0,0,880,570);
					g.drawImage(new ImageIcon("Emp.jpg").getImage(),4,4,872,562,null);
				}
			};
			panel=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					g.drawImage(new ImageIcon("BackgroundCheck.jpg").getImage(),0,0,w,h,null);
				}
			};
				setSize(w,h);
				panel.setBounds(0,0,w,h);
				panel1.setBounds(230,70,880,570);
		
				panel.setLayout(null);
				panel1.setLayout(null);
				add(panel);
				panel.add(panel1);
		  lblImage.setBounds(10,0,200,150);panel.add(lblImage);
		    lblEmployRec.setBounds(200,10,400,50);panel1.add(lblEmployRec);
			lblEmployRec.setHorizontalAlignment(JLabel.CENTER);
			lblEmployRec.setFont(new Font("Lucida calligraphy",Font.BOLD,30));
			lblId.setBounds(100,90,300,30);panel1.add(lblId);lblId.setFont(new Font("Arial Black",Font.BOLD,18));
			txtId.setBounds(280,90,300,30);panel1.add(txtId);
			
			lblName.setBounds(100,130,300,30);panel1.add(lblName);lblName.setFont(new Font("Arial Black",Font.BOLD,18));
		    txtName.setBounds(280,130,300,30);panel1.add(txtName);
			lblAddress.setBounds(100,180,300,30);panel1.add(lblAddress);lblAddress.setFont(new Font("Arial Black",Font.BOLD,18));
			jspAddress.setBounds(280,170,300,50);panel1.add(jspAddress);
			lblContacts.setBounds(100,240,300,30);panel1.add(lblContacts);lblContacts.setFont(new Font("Arial Black",Font.BOLD,18));
			txtContacts.setBounds(280,240,300,30);panel1.add(txtContacts);
			lblSex.setBounds(100,290,300,30);panel1.add(lblSex);lblSex.setFont(new Font("Arial Black",Font.BOLD,18));
			rdFemale.setBounds(280,290,110,30);panel1.add(rdFemale);rdFemale.setFont(new Font("Arial Black",Font.BOLD,16));
			rdMale.setBounds(390,290,110,30);panel1.add(rdMale);rdMale.setFont(new Font("Arial Black",Font.BOLD,16));
			rdFemale.setOpaque(false);
			rdMale.setOpaque(false);
		    lblDOB.setBounds(100,340,300,30);panel1.add(lblDOB);lblDOB.setFont(new Font("Arial Black",Font.BOLD,18));
			cmbDate.setBounds(280,340,60,30);panel1.add(cmbDate);
			cmbMonth.setBounds(340,340,100,30);panel1.add(cmbMonth);
			cmbYear.setBounds(440,340,80,30);panel1.add(cmbYear);
			lblDoj.setBounds(100,390,300,30);panel1.add(lblDoj);lblDoj.setFont(new Font("Arial Black",Font.BOLD,18));
			cmbDate1.setBounds(280,390,60,30);panel1.add(cmbDate1);
			cmbMonth1.setBounds(340,390,100,30);panel1.add(cmbMonth1);
			cmbYear1.setBounds(440,390,80,30);panel1.add(cmbYear1);
			lblQualification.setBounds(100,430,300,30);panel1.add(lblQualification);lblQualification.setFont(new Font("Arial Black",Font.BOLD,18));
			cmbQualificatin.setBounds(280,430,300,30);panel1.add(cmbQualificatin);
			lblDesignation.setBounds(100,480,300,30);panel1.add(lblDesignation);lblDesignation.setFont(new Font("Arial Black",Font.BOLD,18));
			txtDesignation.setBounds(280,480,300,30);panel1.add(txtDesignation);
			lblDepartment.setBounds(100,530,300,30);panel1.add(lblDepartment);lblDepartment.setFont(new Font("Arial Black",Font.BOLD,18));
			txtDepartment.setBounds(280,530,300,30);panel1.add(txtDepartment);
			btnSearch.setBounds(920,170,110,25);panel.add(btnSearch);
			btnUpdate.setBounds(920,205,110,25);panel.add(btnUpdate);
			btnDelete.setBounds(920,240,110,25);panel.add(btnDelete);
			btnExit.setBounds(920,275,110,25);panel.add(btnExit);
			btnSearch.addActionListener(this);
			btnUpdate.addActionListener(this);
			btnDelete.addActionListener(this);
			btnExit.addActionListener(this);
			panel1.setVisible(true);
			panel.setVisible(true);
			setSize(w,h);
			panel.setSize(w,h);
			setVisible(true);
			panel.add(panel1);
			panel.setBackground(Color.GREEN);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  }
		       String gen="";
		   public void actionPerformed(ActionEvent e)
		   {
			  if(e.getSource()==btnSearch)
			{
				try
				{
					PreparedStatement ps=con.prepareStatement("select * from empp1 where empid=? order by (Empid)desc");
					ps.setString(1,txtId.getText());
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{

						JOptionPane.showMessageDialog(this,"Your Employee id is"+ rs.getString(1));
						txtName.setText(rs.getString(2));
						txtAddress.setText(rs.getString(3));
						txtContacts.setText(rs.getString(4));
						/*String g=rs.getString(5);
						if(g.equals("Male"))
						{
							rdMale.setSelected(true);
						}
						else
						{
							rdFemale.setSelected(true);
						}*/
						java.util.Date dt=rs.getDate(6);
						cmbDate.setSelectedItem(""+dt.getDate());
						cmbMonth.setSelectedIndex(dt.getMonth());
						cmbYear.setSelectedItem(""+(dt.getYear()+1900));
						java.util.Date dt1=rs.getDate(7);
						cmbDate1.setSelectedItem(""+dt.getDate());
						cmbMonth1.setSelectedIndex(dt.getMonth());
						cmbYear1.setSelectedItem(""+(dt.getYear()+1900));
						cmbQualificatin.setSelectedItem(rs.getString(8));
						txtDesignation.setText(rs.getString(9));
						txtDepartment.setText(rs.getString(10));
						
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Data Not Found");
					}
				}
				catch(SQLException ee){System.out.println(ee);}
			}
			else if(e.getSource()==btnUpdate)
			{
				try{
				pst=con.prepareStatement("update empp1 set empname=?,address=?,contacts=?,gender=?,dob=?,doj=?,qualification=?,desination=?,department=? where empid=?");
				pst.setString(10,txtId.getText());
				pst.setString(1,txtName.getText());
				pst.setString(2,txtAddress.getText());
				pst.setString(3,txtContacts.getText());
				pst.setString(4,gen);
				pst.setString(5,cmbDate.getSelectedItem().toString()+"-"+cmbMonth.getSelectedItem().toString()+"-"+cmbYear.getSelectedItem().toString());
				pst.setString(6,cmbDate1.getSelectedItem().toString()+"-"+cmbMonth1.getSelectedItem().toString()+"-"+cmbYear1.getSelectedItem().toString());
				pst.setString(7,cmbQualificatin.getSelectedItem().toString());
				pst.setString(8,txtDesignation.getText());
				pst.setString(9,txtDepartment.getText());
				if(pst.executeUpdate()>0)
					JOptionPane.showMessageDialog(this,"Data updated");
				else
					JOptionPane.showMessageDialog(this,"Data Not updated");
			}
			catch(SQLException ee){JOptionPane.showMessageDialog(this,ee);}
			}
	         
			else if(e.getSource()==btnDelete)
			{
				int opt=JOptionPane.showConfirmDialog(this,"Do you want to delete");
				if(opt==JOptionPane.YES_OPTION)
				{
					try
					{
					PreparedStatement pst=con.prepareStatement("Delete from empp1 where empid=?");
					pst.setString(1,txtId.getText());
					if(pst.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(this,"Data Deleted");
						txtId.setText("");
						txtName.setText("");
						txtAddress.setText("");
						txtContacts.setText("");
						rdMale.setSelected(false);
						rdFemale.setSelected(false);
						cmbDate.setSelectedItem("1");
						cmbMonth.setSelectedItem("January");
						cmbYear.setSelectedItem("1980");
						cmbDate1.setSelectedItem("1");
						cmbMonth1.setSelectedItem("January");
						cmbYear1.setSelectedItem("1980");
						cmbQualificatin.setSelectedItem("Matric");
						txtDesignation.setText("");
						txtDepartment.setText("");
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Data not Deleted");
					}
				}
				catch(SQLException ee){}
				}
			}
						   else if(e.getSource()==btnExit)
			   {
				   System.exit(0);
			   }
			
		   }
			public static void main(String[]args)
				 {
					new Employ1();
				 }
       
}