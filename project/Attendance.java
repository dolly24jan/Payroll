import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Attendance extends JFrame implements ActionListener
{
	
     static int w,h;
     JLabel lblMessage=new JLabel("ATTENDANCE FORM");
     JLabel lblEcode =new JLabel("EMP CODE");
     JLabel lblEname=new JLabel ("NAME");
     JLabel lblDesig=new JLabel("DESIGNATION");
	 JLabel lblDate=new JLabel("DATE");
     JLabel lblMark=new JLabel("MARK");
     JLabel lblImage=new JLabel(new ImageIcon("logo.jpg"));
	 JTextField  txtEcode=new JTextField(30);
     JTextField txtEname=new JTextField(30);
     JTextField txtDesig=new JTextField(30);
	  JTextField txtDate=new JTextField(30);
	  
	 JComboBox cmbDet=new JComboBox();
	JComboBox cmbMon=new JComboBox();
	JComboBox cmbYr=new JComboBox();
	
	ButtonGroup bg=new ButtonGroup();
	JRadioButton rdAbsent=new JRadioButton("ABSENT");
    JRadioButton rdPresent=new JRadioButton("PRESENT");
	 JRadioButton rdHoliday=new JRadioButton("HOLIDAY");
	 ButtonGroup bg1=new ButtonGroup();
	JRadioButton rdCl=new JRadioButton("CL");
    JRadioButton rdPl=new JRadioButton("PL");
	 JRadioButton rdSl=new JRadioButton("SL");
	
	
	JButton btnSubmit=new JButton("SUBMIT");
	JButton btnSearch=new JButton("Search");
	Font fnt=new Font("Algerian",Font.BOLD,40);
    JPanel panel;//=new Panel();
	JPanel panel1;
	java.util.Date date=new java.util.Date();
	int dd,mm,yy;
	{
		dd=date.getDate();
		mm=date.getMonth()+1;
		yy=date.getYear()+1900;
	}
	Connection con;//Use For Stablished Connection between front-end and back-end
	PreparedStatement pst;
	ResultSet rst;
	{
		try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
		//JOptionPane.showMessageDialog(this,"Connected");
		}
		catch(Exception e){}
		
	}
		Attendance()
		{
			
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension dim=toolkit.getScreenSize();
		h=(int)dim.getHeight();
		w=(int)dim.getWidth();
		panel1=new JPanel()
		{
			
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("Profile.jpg").getImage(),0,0,w,h,null);
				
			}
		};
		panel1.setLayout(null);
		
		panel=new JPanel()
		{
			
			public void paintComponent(Graphics g)
			{
				//g.drawImage(new ImageIcon("attndnc1.jpg").getImage(),0,0,600,550,null);
				g.fillRect(0,0,880,500);
				g.drawImage(new ImageIcon("attndnc1.jpg").getImage(),4,4,872,490,null);
				
			}
		};
		panel.setLayout(null);
		
		 lblImage.setBounds(10,0,200,150);panel1.add(lblImage);
    lblMessage.setBounds(100,70,410,40);panel.add(lblMessage);
		 
	lblMessage.setFont(fnt);
	lblMessage.setHorizontalAlignment(JLabel.CENTER);
    setTitle("ATTENDANCE FORM");
    setLayout(null);
    //panel.setBounds(w/2-300,h/2-300,600,600);
		panel.setBounds(230,100,880,500);
		panel1.setBounds(0,0,w,h);
	add (panel1);
	panel1.add(panel);
	lblEcode.setBounds(100,150,200,25);panel.add(lblEcode);lblEcode.setFont(new Font("Arial Black",Font.BOLD,18));
	txtEcode.setBounds(310,150,210,30);panel.add(txtEcode);
	btnSearch.setBounds(550,150,100,30);panel.add(btnSearch);btnSearch.setFont(new Font("Arial Black",Font.BOLD,14));
	lblEname.setBounds(100,190,200,25);panel.add(lblEname);lblEname.setFont(new Font("Arial Black",Font.BOLD,18));
	txtEname.setBounds(310,190,210,30);panel.add(txtEname);
	lblDesig.setBounds(100,230,200,25);panel.add(lblDesig);lblDesig.setFont(new Font("Arial Black",Font.BOLD,18));
	txtDesig.setBounds(310,230,210,30);panel.add(txtDesig);
	
	lblDate.setBounds(100,270,200,25);panel.add(lblDate);lblDate.setFont(new Font("Arial Black",Font.BOLD,18));
	
	
cmbDet.setBounds(310,270,50,30);panel.add(cmbDet);
cmbMon.setBounds(360,270,80,30);panel.add(cmbMon);
cmbYr.setBounds(440,270,60,30);panel.add(cmbYr);


 cmbDet.addItem("DD");
		
for(int i=1;i<=31;i++)
 {
	cmbDet.addItem(i);
 }
 	  
	  cmbMon.addItem("MM"); 
      cmbMon.addItem("Jan");  
      cmbMon.addItem("Feb");  
      cmbMon.addItem("Mar");  
      cmbMon.addItem("Apr");  
      cmbMon.addItem("May");  
      cmbMon.addItem("Jun");  
      cmbMon.addItem("Jul");  
      cmbMon.addItem("Aug");  
      cmbMon.addItem("Sep");  
      cmbMon.addItem("Oct");
      cmbMon.addItem("Nov");  
      cmbMon.addItem("Dec");  
	 
	 cmbYr.addItem("YY");
	for(int i=1981;i<=2050;i++)
 {
	cmbYr.addItem(i);
 }
	cmbDet.setSelectedItem(dd);
	cmbMon.setSelectedIndex(mm);
	cmbYr.setSelectedItem(yy);
	lblMark.setBounds(100,310,200,25);panel.add(lblMark);lblMark.setFont(new Font("Arial Black",Font.BOLD,18));
	rdAbsent.setBounds(310,310,130,30);
	rdPresent.setBounds(310,350,130,30);
	rdHoliday.setBounds(310,390,130,30);
	rdCl.setBounds(450,310,200,30);
	rdSl.setBounds(450,350,200,30);
	rdPl.setBounds(450,390,200,30);
	bg.add(rdAbsent);panel.add(rdAbsent);rdAbsent.setFont(new Font("Arial Black",Font.BOLD,12));
	bg.add(rdHoliday);panel.add(rdHoliday);rdHoliday.setFont(new Font("Arial Black",Font.BOLD,12));
	bg.add(rdPresent);panel.add(rdPresent);rdPresent.setFont(new Font("Arial Black",Font.BOLD,12));
	bg1.add(rdCl);panel.add(rdCl);rdCl.setFont(new Font("Arial Black",Font.BOLD,12));
	bg1.add(rdSl);panel.add(rdSl);rdSl.setFont(new Font("Arial Black",Font.BOLD,12));
	bg1.add(rdPl);panel.add(rdPl);rdPl.setFont(new Font("Arial Black",Font.BOLD,12));
	rdAbsent.setOpaque(false);
	rdPresent.setOpaque(false);
	rdHoliday.setOpaque(false);
	rdPl.setOpaque(false);
	rdCl.setOpaque(false);
	rdSl.setOpaque(false);
	btnSearch.addActionListener(this);
		
		btnSubmit.addActionListener(this);
	
	
		btnSubmit.setBounds(685,450,120,35);panel.add(btnSubmit);btnSubmit.setFont(new Font("Arial Black",Font.BOLD,14));
		txtEname.setEditable(false);
		txtDesig.setEditable(false);
		   
		panel1.setSize(w,h);
       setSize(w,h); 
          //  panel.setSize(600,600);    

        setVisible(true);
        panel.setVisible(true);
         panel.setBackground(new Color(247,223,179));
         setBackground(Color.green);
		 	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}
	
	public void actionPerformed(ActionEvent f)
		{
		if(f.getSource()==btnSearch)
		{

		  try{
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			pst=con.prepareStatement("select * from empp1 where empid=?");
			pst.setString(1,txtEcode.getText());
			rst=pst.executeQuery();
			
			if(rst.next())
			{
					     txtEname.setText(rst.getString(2));
						 txtDesig.setText(rst.getString(3));

			}
			else
			{
				JOptionPane.showMessageDialog(this,"Employee Id Not found");
			}
			
		}
		catch(Exception e){System.out.println(e);}
		}
		else if(f.getSource()==btnSubmit)
		{
					  try{
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			pst=con.prepareStatement("insert into attendance values(?,?,?)");
					pst.setString(1,txtEcode.getText());
					if(rdAbsent.isSelected())
					{pst.setString(2,"Absent");}
				else if(rdPresent.isSelected())
					{pst.setString(2,"Present");}
				else if(rdHoliday.isSelected())
				{
				pst.setString(2,"Holiday");}
			    pst.setString(3,cmbDet.getSelectedItem().toString()+"-"+cmbMon.getSelectedItem().toString()+"-"+cmbYr.getSelectedItem().toString());
				int n=pst.executeUpdate();
				if(n>0)
				{JOptionPane.showMessageDialog(this,"Data Inserted");}
				else
				{JOptionPane.showMessageDialog(this,"Data Not Inserted");}
			    }
				catch(Exception ee){System.out.println(ee);}
			
		}
		}
		public static void main(String []args)
		{
			new Attendance();
		}
	
}
