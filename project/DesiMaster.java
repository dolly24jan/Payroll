import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class DesiMaster extends JFrame implements ActionListener

{
	JLabel lblMessage=new JLabel("DESIGNATION MASTER");
	JLabel lblDesign=new JLabel("Designation ");
	JLabel lblDepart=new JLabel("Department");
	JLabel lblDesign1=new JLabel("Enter Additional Designation Name");
	JLabel lblDepart1=new JLabel("Enter Additional Department Name");
	JComboBox cmbDepart=new JComboBox();
	JScrollPane sp1Design;
	DefaultListModel dlst1Design=new DefaultListModel();
	
	JTextField txtDesign1=new JTextField();
	JTextField txtDepart1=new JTextField();
	JButton btnAdd=new JButton("ADD");
	JPanel panel1;
	JPanel panel;
	//JLabel lblImage=new JLabel(new ImageIcon("design.jpg"));
	JLabel lblLogo=new JLabel(new ImageIcon("logo.jpg"));
	JList lstDesign;
	int w,h;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String d_id="";
	
	{	
		cmbDepart.addItem("Select");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			ps=con.prepareStatement("select count(*) from depart");
			rs=ps.executeQuery();
			if(rs.next())
			{
				PreparedStatement ps1=con.prepareStatement("select depart_name from depart");
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next())
				{
					cmbDepart.addItem(rs1.getString(1));
				}
			}
			 else
				 JOptionPane.showMessageDialog(this,"No Department Available");
		}
		catch(Exception e){System.out.println(e);}
	}
	
	DesiMaster()
	{
	int row=0;
		panel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("design.jpg").getImage(),0,0,w,h,null);
			}
		}; 
		panel.setLayout(null);
		panel1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				g.drawImage(new ImageIcon().getImage(),0,0,600,60,null);
			}
		};
		panel1.setLayout(null);		
		add(panel);
		panel.add(panel1);
		
		panel1.setBounds(380,16,900,60);
    	
		panel.setLayout(null);   
			Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		w=(int)d.getWidth();
		h=(int)d.getHeight();
		
		JPanel p=new JPanel();
		
		p.setLayout(null);
		p.setBounds(280,h/2-280,740,400);
		lblMessage.setBounds(0,10,w,80);
		panel.add(lblMessage);
		lblMessage.setHorizontalAlignment(JLabel.CENTER);
		lblMessage.setFont(new Font("Lucida Calligraphy",Font.BOLD,40));
		//lstDesign.setVisibleRowCount(3);
		lstDesign=new JList(dlst1Design);
		sp1Design=new JScrollPane(lstDesign);
		lblDepart.setBounds(380,150,200,30);panel.add(lblDepart);lblDepart.setFont(new Font("Arial Black",Font.BOLD,12));
		cmbDepart.setBounds(380,190,200,30);panel.add(cmbDepart);cmbDepart.setFont(new Font("Arial Black",Font.BOLD,11));
		lblDesign.setBounds(680,150,200,30);panel.add(lblDesign);lblDesign.setFont(new Font("Arial Black",Font.BOLD,12));
		sp1Design.setBounds(680,190,200,100);panel.add(sp1Design);sp1Design.setFont(new Font("Arial Black",Font.BOLD,11));
		lblDepart1.setBounds(310,350,300,30);panel.add(lblDepart1);lblDepart1.setFont(new Font("Arial Black",Font.BOLD,14));
		txtDepart1.setBounds(680,350,280,30);panel.add(txtDepart1);txtDepart1.setFont(new Font("Arial Black",Font.BOLD,10));
		lblDesign1.setBounds(310,400,300,30);panel.add(lblDesign1);lblDesign1.setFont(new Font("Arial Black",Font.BOLD,14));
		txtDesign1.setBounds(680,400,280,30);panel.add(txtDesign1);txtDesign1.setFont(new Font("Arial Black",Font.BOLD,10));
		//lblImage.setBounds(320,10,150,200);panel.add(lblImage);
		lblLogo.setBounds(10,0,200,150);panel.add(lblLogo);
		btnAdd.setBounds(890,450,100,30);panel.add(btnAdd);btnAdd.setFont(new Font("Arial Black",Font.BOLD,14));
		panel.setBounds(0,0,w,h);
		lstDesign.setSelectionBackground(Color.pink);
		add(panel);
		panel.add(p);
		cmbDepart.addActionListener(this);
		btnAdd.addActionListener(this);
		p.setBorder(BorderFactory.createTitledBorder("DESIGNATION LIST"));
		setVisible(true);
		setSize(w,h);
		txtDesign1.setVisible(true);
		txtDepart1.setVisible(true);
		lblDepart1.setVisible(true);
		lblDesign1.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cmbDepart)
		{
				   try
			{
				dlst1Design.removeAllElements();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			ps=con.prepareStatement("select count(*) from desig");
			rs=ps.executeQuery();
			if(rs.next())
			{
				PreparedStatement ps1=con.prepareStatement("select desig_name,depart_id from desig where depart_id=(select depart_id from depart where depart_name=?)");
				ps1.setString(1,cmbDepart.getSelectedItem().toString());
				ResultSet rs1=ps1.executeQuery();
				int i=0;
				while(rs1.next())
				{
					dlst1Design.addElement(rs1.getString(1));
					d_id=rs1.getString(2);
				}
			}
			}
                     catch(Exception ee){System.out.println(ee);}					 
		}
		else if(ae.getSource()==btnAdd)
		{
			 if(txtDesign1.getText().equals(""))
			 {
               JOptionPane.showMessageDialog(this,"Please Enter the value.....");
				txtDesign1.requestFocus();
				return;
			}		
				try{
					ps=con.prepareStatement("insert into Desig values(?,?,desid.nextval)");
					ps.setString(1,d_id);
					ps.setString(2,txtDesign1.getText());
					if(ps.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(this,"Database Updated");
						dlst1Design.addElement(txtDesign1.getText());
						txtDesign1.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Database not Updated");	
					}
				}
				catch(Exception ee){System.out.println(ee);}
		
			/*else 
			{		
			  if(txtDepart1.getText().equals(""))
			  {
				JOptionPane.showMessageDialog(this,"Please Enter the value.....");
				txtDepart1.requestFocus();
				return;
			  } 
			try{
					ps=con.prepareStatement("insert into Depart values(?,'dept_'||id.nextval)");
					ps.setString(1,txtDepart1.getText());
					if(ps.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(this,"Database Updated");
						cmbDepart.addItem(txtDepart1.getText());
						txtDepart1.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Database not Updated");	
					}
			}
			catch(Exception e){System.out.println(e);}
		}
*/
	    }

		
	}
	public static void main(String[]args)
	{
		new DesiMaster();
	}
}