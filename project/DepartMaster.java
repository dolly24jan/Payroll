import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class DepartMaster extends JFrame implements ActionListener
{
	

	JButton btnDepartmentAdd=new JButton("ADD");
	JLabel lblDepartment=new JLabel("Enter Additional Department");
	JTextField txtDepartment=new JTextField(40);
	JLabel lblMessage=new JLabel("DEPARTMENT MASTER");
	
	
	JScrollPane spDepartment;
	JPanel ImagePanel;
	JPanel panel;
	DefaultListModel dlstDepartment=new DefaultListModel();
	JLabel lblImage=new JLabel(new ImageIcon("desig.jpg"));
	JLabel lblLogo=new JLabel(new ImageIcon("logo.jpg"));
	int w,h;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String depart[];
	{
		try{
		     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		     con=DriverManager.getConnection("Jdbc:Odbc:ORACLE","system","oracle");
			 ps=con.prepareStatement("select count(*) from depart");
			 rs=ps.executeQuery();
			 if(rs.next())
			 {	depart=new String[rs.getInt(1)];
				PreparedStatement ps1=con.prepareStatement("select depart_name from depart");
				ResultSet rs1=ps1.executeQuery();
				int i=0;
				while(rs1.next())
				{
						//depart[i]=rs1.getString(1);
						//i++;
						dlstDepartment.addElement(rs1.getString(1));
				}
			 }
			 else
				 JOptionPane.showMessageDialog(this,"No Department Available");
				}
		catch(Exception e){System.out.println(e);}
	}
	
	JList lstDepartment=new JList(dlstDepartment);
	//spDepartment=new JScrollPane(lstDepartment);
	DepartMaster()
	{
		
		int row=0;
		panel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("depart.jpg").getImage(),0,0,w,h,null);
			}
		}; 
		ImagePanel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				g.drawImage(new ImageIcon().getImage(),0,0,600,60,null);
			}
		}; 
		panel.add(ImagePanel);
		ImagePanel.setBounds(380,16,600,60);
    		
		panel.setLayout(null);   
		
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		w=(int)d.getWidth();
		h=(int)d.getHeight();
		
		lblMessage.setBounds(0,0,w,80);
		
		lblMessage.setBounds(0,0,w,80);
		ImagePanel.add(lblMessage);//panel.add(lblMessage);
		lblMessage.setHorizontalAlignment(JLabel.CENTER);
		lblMessage.setFont(new Font("Lucida Calligraphy",Font.BOLD,40));
		lblMessage.setForeground(Color.white);
		//lstDesignation=new JList(dlstDesig);
		lstDepartment.setVisibleRowCount(3);
		spDepartment=new JScrollPane(lstDepartment);

		JPanel p=new JPanel();
		p.setLayout(null);
		//p.setBackground(Color.yellow);
		p.setBounds(w/2-200,h/2-300,400,500);
		spDepartment.setBounds(100,50,200,160);
		lblDepartment.setBounds(70,260,250,30);p.add(lblDepartment);lblDepartment.setFont(new Font("Arial Black",Font.BOLD,14));
		txtDepartment.setBounds(100,310,200,30);p.add(txtDepartment);txtDepartment.setFont(new Font("Arial Black",Font.BOLD,12));
		btnDepartmentAdd.setBounds(180,410,100,30);p.add(btnDepartmentAdd);btnDepartmentAdd.setFont(new Font("Arial Black",Font.BOLD,14));
		btnDepartmentAdd.addActionListener(this);
		p.setBorder(BorderFactory.createTitledBorder("DEPARTMENT LIST"));p.add(spDepartment);
		lstDepartment.setSelectionBackground(Color.pink);
		lblImage.setBounds(300,140,150,200);panel.add(lblImage);
		lblLogo.setBounds(10,0,200,150);panel.add(lblLogo);
		panel.setBounds(0,0,w,h);
		add(panel);
		panel.add(p);
		setVisible(true);
		setSize(w,h);
	}
		public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnDepartmentAdd)
		{
			if(txtDepartment.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter the value.....");
				txtDepartment.requestFocus();
				return;
			}
			try{
					ps=con.prepareStatement("insert into Depart values(?,'dept_'||id.nextval)");
					ps.setString(1,txtDepartment.getText());
					if(ps.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(this,"Database Updated");
						dlstDepartment.addElement(txtDepartment.getText());
						txtDepartment.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Database not Updated");	
					}
			}
			catch(Exception e){System.out.println(e);}
		}
	}

	
		public static void main(String[]args)
		{
			new DepartMaster();
		}
	
}