import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Leave1 extends JFrame implements ActionListener
{
	int w,h;
	JLabel lblEmployRec=new JLabel("Leave Form");
	JLabel lblId=new JLabel("Emp Id");
	JTextField txtId=new JTextField(30);
	JComboBox cmbId=new JComboBox();
	JLabel lblName=new JLabel("Emp Name");
    JTextField txtName=new JTextField(30);
	
	JLabel lblDesignation=new JLabel("Designation");
	JTextField txtDesignation=new JTextField(30);

    JLabel lblNLeave=new JLabel("No. Of Leaves");
	JTextField txtNLeaves=new JTextField(30);
	
	 JLabel lblSl=new JLabel("SL");
     JLabel lblCl=new JLabel("CL");
     JLabel lblPl=new JLabel("PL");
	 JTextField txtSl=new JTextField(30);
     JTextField txtCl=new JTextField(20);
	 JTextField txtPl=new JTextField(20);
	 JLabel lblImage=new JLabel(new ImageIcon("logo.jpg"));
	 JLabel lblReasn=new JLabel("REASON");
	 JTextField txtReasn=new JTextField(20);
	
    JLabel lblFrom=new JLabel("From");
	//JTextField txtFrom=new JTextField();
	JLabel lblTo=new JLabel("To");
	//JTextField txtTo=new JTextField();
	JComboBox cmbDate=new JComboBox();
	 JComboBox cmbMonth=new JComboBox();
	 JComboBox cmbYear=new JComboBox();
	 JComboBox cmbDate1=new JComboBox();
	 JComboBox cmbMonth1=new JComboBox();
	 JComboBox cmbYear1=new JComboBox();
	
	JLabel lblAdjust=new JLabel("Adjust");
	//JTextField txtAdjust=new JTextField(30);
	JComboBox cmbAdjust=new JComboBox();
	
	JButton btnSubmit=new JButton("Submit");
	JButton btnExit=new JButton("Exit");
	Font fnt=new Font("Algerian",Font.BOLD,40);
	Font fnt1=new Font("Arial black",Font.BOLD,14);
	JPanel panel;//=new JPanel();
	JPanel panel1;//=new JPanel();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("Jdbc:Odbc:Oracle","system","oracle");
		ps=con.prepareStatement("select empid from empp1" );
		rs=ps.executeQuery();
		 while(rs.next())
					   {
						   cmbId.addItem(rs.getString(1));
					   }
		}
		catch(SQLException e){}
		catch(ClassNotFoundException e){}
	
      for(int i=1;i<=31;i++)
         cmbDate.addItem(""+i);
      for(int i=1980;i<=2020;i++)
               cmbYear.addItem(""+i);
               cmbMonth.addItem("Jan");
               cmbMonth.addItem("Feb");
               cmbMonth.addItem("Mar");
               cmbMonth.addItem("Apr");
               cmbMonth.addItem("May");
               cmbMonth.addItem("Jun");
               cmbMonth.addItem("Jul");
               cmbMonth.addItem("Aug");
               cmbMonth.addItem("Sept");
               cmbMonth.addItem("Oct");
               cmbMonth.addItem("Nov");
               cmbMonth.addItem("Dec");
          }
		  {
			  for(int j=1;j<=31;j++)
         cmbDate1.addItem(""+j);
      for(int j=1980;j<=2020;j++)
               cmbYear1.addItem(""+j);
               cmbMonth1.addItem("Janu");
               cmbMonth1.addItem("Feb");
               cmbMonth1.addItem("Mar");
               cmbMonth1.addItem("Apr");
               cmbMonth1.addItem("May");
               cmbMonth1.addItem("Jun");
               cmbMonth1.addItem("Jul");
               cmbMonth1.addItem("Aug");
               cmbMonth1.addItem("Sept");
               cmbMonth1.addItem("Oct");
               cmbMonth1.addItem("Nov");
               cmbMonth1.addItem("Dec");
		  }
	
		 Leave1()
		  {
			super("Leave Form");
			Toolkit toolkit=Toolkit.getDefaultToolkit();
			Dimension dim=toolkit.getScreenSize();
			h=(int)dim.getHeight();
			w=(int)dim.getWidth();
			java.util.Date dt=new java.util.Date();
			cmbDate.setSelectedItem(""+dt.getDate());
			cmbDate1.setSelectedItem(""+dt.getDate());
			cmbMonth.setSelectedIndex(dt.getMonth()+1);
		    cmbMonth1.setSelectedIndex(dt.getMonth()+1);
		    cmbYear.setSelectedItem(""+(dt.getYear()+1900));
		    cmbYear1.setSelectedItem(""+(dt.getYear()+1900));
		 panel1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("payroll.jpg").getImage(),0,0,w,h,null);
			}
		};
		panel1.setLayout(null);
	
        panel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("Leave1.jpg").getImage(),0,0,750,700,null);
			}
		};
		panel.setLayout(null);

		lblImage.setBounds(10,0,200,150);panel1.add(lblImage);
   
		panel.setLayout(null);
	
    setTitle("LEAVE FORM");
		   setLayout(null);
   panel.setBounds(w/2-400,h/2-300,750,500);
	add(panel1);
	panel1.add(panel);
		    lblEmployRec.setBounds(150,10,360,70);panel.add(lblEmployRec);
			lblEmployRec.setHorizontalAlignment(JLabel.CENTER);
			lblEmployRec.setFont(new Font("Lucida calligraphy",Font.BOLD,50));
			lblId.setBounds(70,150,150,30);panel.add(lblId);lblId.setFont(new Font("Arial Black",Font.BOLD,18));
			cmbId.setBounds(280,150,400,30);panel.add(cmbId);
			
			lblName.setBounds(70,190,150,30);panel.add(lblName);lblName.setFont(new Font("Arial Black",Font.BOLD,18));
		    txtName.setBounds(280,190,400,30);panel.add(txtName);
			lblDesignation.setBounds(70,230,150,30);panel.add(lblDesignation);lblDesignation.setFont(new Font("Arial Black",Font.BOLD,18));
			txtDesignation.setBounds(280,230,400,30);panel.add(txtDesignation);
			lblNLeave.setBounds(70,270,150,30);panel.add(lblNLeave);lblNLeave.setFont(new Font("Arial Black",Font.BOLD,18));
			txtNLeaves.setBounds(280,270,400,30);panel.add(txtNLeaves);
			
			lblPl.setBounds(70,310,50,30);panel.add(lblPl);lblPl.setFont(new Font("Arial Black",Font.BOLD,18));
			txtPl.setBounds(280,310,90,30);panel.add(txtPl);
			lblCl.setBounds(400,310,50,30);panel.add(lblCl);lblCl.setFont(new Font("Arial Black",Font.BOLD,18));
			txtCl.setBounds(450,310,90,30);panel.add(txtCl);
			lblSl.setBounds(560,310,50,30);panel.add(lblSl);lblSl.setFont(new Font("Arial Black",Font.BOLD,18));
	        txtSl.setBounds(590,310,90,30);panel.add(txtSl);
			
			lblReasn.setBounds(70,350,150,30);panel.add(lblReasn);lblReasn.setFont(new Font("Arial Black",Font.BOLD,18));
			txtReasn.setBounds(280,350,400,30);panel.add(txtReasn);
			
		    lblFrom.setBounds(70,390,150,30);panel.add(lblFrom);lblFrom.setFont(new Font("Arial Black",Font.BOLD,18));
			cmbDate.setBounds(280,390,40,30);panel.add(cmbDate);
			cmbMonth.setBounds(330,390,56,30);panel.add(cmbMonth);
			cmbYear.setBounds(400,390,60,30);panel.add(cmbYear);
			
			lblTo.setBounds(465,390,40,30);panel.add(lblTo);lblTo.setFont(new Font("Arial Black",Font.BOLD,18));
			cmbDate1.setBounds(505,390,40,30);panel.add(cmbDate1);
			cmbMonth1.setBounds(555,390,60,30);panel.add(cmbMonth1);
			cmbYear1.setBounds(625,390,60,30);panel.add(cmbYear1);	
			
	
			lblAdjust.setBounds(70,430,150,30);panel.add(lblAdjust);lblAdjust.setFont(new Font("Arial Black",Font.BOLD,18));
			cmbAdjust.setBounds(280,430,400,30);panel.add(cmbAdjust);
			
			cmbAdjust.addItem("Select");
			cmbAdjust.addItem("Pl");  
			cmbAdjust.addItem("Cl");  
			cmbAdjust.addItem("Sl");
			
			btnSubmit.setBounds(300,500,100,30);panel.add(btnSubmit);btnSubmit.setFont(new Font("Arial Black",Font.BOLD,14));
			btnExit.setBounds(450,500,100,30);panel.add(btnExit);btnExit.setFont(new Font("Arial Black",Font.BOLD,14));
			panel1.setSize(w,h);
			setSize(w,h); 
            panel.setSize(780,570);    
			cmbId.addActionListener(this);
			cmbAdjust.addActionListener(this);
			btnSubmit.addActionListener(this);
			btnExit.addActionListener(this);
			cmbDate.addActionListener(this);
		    cmbMonth.addActionListener(this);
		    cmbYear.addActionListener(this);
			cmbDate1.addActionListener(this);
		    cmbMonth1.addActionListener(this);
		    cmbYear1.addActionListener(this);
        setVisible(true);
        panel1.setVisible(true);
         panel1.setBackground(new Color(247,223,179));
		  //setBackground(Color.green);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			
				 
		  }
		 
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cmbDate||e.getSource()==cmbMonth||e.getSource()==cmbYear||e.getSource()==cmbDate1||e.getSource()==cmbMonth1||e.getSource()==cmbYear1)
		{
			try{
					
					ps=con.prepareStatement("Select months_between(?,?)from dual");
					ps.setString(2,cmbDate.getSelectedItem().toString()+"-"+cmbMonth.getSelectedItem().toString()+"-"+cmbYear.getSelectedItem().toString());
					ps.setString(1,cmbDate1.getSelectedItem().toString()+"-"+cmbMonth1.getSelectedItem().toString()+"-"+cmbYear1.getSelectedItem().toString());
					rs=ps.executeQuery();
					float a;
					if(rs.next())
					{
						a=rs.getFloat(1);
						txtNLeaves.setText(""+((int)Math.ceil(a*30)));
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Data not found");
					}
				}
				catch(SQLException ee){JOptionPane.showMessageDialog(this,ee);}
		}
		if(e.getSource()==cmbId)
			   {
				   try{
					   ps=con.prepareStatement("select * from leave_detail where empid=?");
					   ps.setString(1,cmbId.getSelectedItem().toString());
					   rs=ps.executeQuery();
					   if(rs.next())
					   {
			             txtPl.setText(""+rs.getInt(2));   
                         txtCl.setText(""+rs.getInt(3));
				         txtSl.setText(""+rs.getInt(4));
						 txtCl.setEditable(false);
				         txtSl.setEditable(false);
				         txtPl.setEditable(false);
					   }
					}
                     catch(SQLException ee){System.out.println(ee);}
				    try{
					   ps=con.prepareStatement("select * from empp1 where empid=?");
					   ps.setString(1,cmbId.getSelectedItem().toString());
					   rs=ps.executeQuery();
					   if(rs.next())
					   {
			             txtName.setText(rs.getString(2));
						 txtName.setEditable(false);
						 txtDesignation.setText(rs.getString(3));
						 txtDesignation.setEditable(false);
					   }
					}
					catch(SQLException ee){System.out.println(ee);}
			   }
			   else if(e.getSource()==cmbAdjust)
			   {
				   try{
					   ps=con.prepareStatement("select * from leave_detail where empid=?");
					   ps.setString(1,cmbAdjust.getSelectedItem().toString());
					   rs=ps.executeQuery();
					   if(rs.next())
					   {
			             txtPl.setText(""+rs.getInt(2));   
                         txtCl.setText(""+rs.getInt(3));
				         txtSl.setText(""+rs.getInt(4));
						 txtCl.setEditable(false);
				         txtSl.setEditable(false);
				         txtPl.setEditable(false);
					   }
					}
                     catch(SQLException ee){System.out.println(ee);}					 
			   }
			   else if(e.getSource()==btnSubmit)
			   {
				   System.out.println("Submit");
				    int flag=0,res=0;
				  try{
					   ps=con.prepareStatement("insert into ltype values(?,?,?,?,?,?,?,?)");
					   ps.setString(1,txtId.getText());
					   ps.setString(2,txtName.getText());
					   ps.setString(3,txtDesignation.getText());
					   ps.setString(4,txtNLeaves.getText());
					   ps.setString(5,cmbDate.getSelectedItem().toString()+"-"+cmbMonth.getSelectedItem().toString()+"-"+cmbYear.getSelectedItem().toString());
					   ps.setString(6,cmbDate1.getSelectedItem().toString()+"-"+cmbMonth1.getSelectedItem().toString()+"-"+cmbYear1.getSelectedItem().toString());
					   ps.setString(7,txtReasn.getText());
					   ps.setString(8,cmbAdjust.getSelectedItem().toString());
					   if(ps.executeUpdate()>0)
					   {
						   JOptionPane.showMessageDialog(this,"Data Saved");
						   String ss="Emp"+cmbAdjust.getSelectedItem().toString();
						   int no;
							PreparedStatement ps1=con.prepareStatement("Update leave_detail set " + ss + "=? where empid=?"); 
							if(cmbAdjust.getSelectedItem().toString().equalsIgnoreCase("pl"))
								 no=Integer.parseInt(txtPl.getText())-Integer.parseInt(txtNLeaves.getText());
							else if(cmbAdjust.getSelectedItem().toString().equalsIgnoreCase("cl"))
								no=Integer.parseInt(txtCl.getText())-Integer.parseInt(txtNLeaves.getText());
							else
								no=Integer.parseInt(txtSl.getText())-Integer.parseInt(txtNLeaves.getText());
							ps1.setInt(1,7);
							ps1.setString(2,cmbId.getSelectedItem().toString());
			               if(ps1.executeUpdate()>0)
							{
				            JOptionPane.showMessageDialog(this,"Data Updated");
			                }
							else
							{
								JOptionPane.showMessageDialog(this,"Data Not Updated");
							}
					   }
						 
				  }
				  catch(SQLException ee){System.out.println(ee);}
					   
				  }
		if(e.getSource()==btnExit)
		{
		dispose();}
	}

		   public static void main(String[]args)
				 {
					new Leave1();
				 }
       
}