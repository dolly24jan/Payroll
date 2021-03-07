import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class AttendncCal extends JFrame implements ActionListener
{
	JButton btnSearch=new JButton("Search");
	JComboBox cmbSel=new JComboBox();
	JTextField txtSel=new JTextField();
	String heading[]={"Emp_Id","Month","Year","Present","Absent","Total"};
	Object obj[][]=new Object[50][6];
	{
		for(int i=0;i<50;i++)
		for(int j=0;j<6;j++)
		obj[i][j]=" ";
	}
	JTable tab=new JTable(obj,heading);
	JScrollPane jsp=new JScrollPane(tab);
	JPanel panel=new JPanel();
	{
		cmbSel.addItem("Select");
		cmbSel.addItem("All");
		cmbSel.addItem("Emp_Id");
	}
	JButton btnPrint=new JButton("Print");
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
	}
	AttendncCal()
	{
		super("Attendence Calculation");
		add(panel);
		panel.setLayout(null);
		jsp.setBounds(0,80,590,400);panel.add(jsp);
		cmbSel.setBounds(10,10,100,20);panel.add(cmbSel);
		txtSel.setBounds(130,10,100,20);panel.add(txtSel);
		btnSearch.setBounds(350,10,100,20);panel.add(btnSearch);
		btnPrint.setBounds(200,510,100,20);panel.add(btnPrint);
		setSize(600,600);
		setVisible(true);
		setResizable(false);
		txtSel.setVisible(false);
		btnSearch.setVisible(false);
		cmbSel.addActionListener(this);
		btnSearch.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cmbSel)
		{
			if(cmbSel.getSelectedItem().toString().equalsIgnoreCase("All"))
			{
				try
				{
					int row=0;
					System.out.println("aa");
					pst=con.prepareStatement("select empid,to_char(sysdate,'Month'),to_char(sysdate,'YYY'),count(*) from attendance where Attendance='Present' and to_char(empdate,'Month')=to_char(sysdate,'Month') and to_char(empdate,'YYYY')=to_char(sysdate,'YYYY') group by empid");
					rst=pst.executeQuery();
					for(int i=0;i<50;i++)
					{
						for(int j=0;j<6;j++)
							obj[i][j]="";
					}
					while(rst.next())
					{
						tab.setValueAt(rst.getString(1),row,0);
						tab.setValueAt(rst.getString(2),row,1);
						tab.setValueAt(rst.getString(3),row,2);
						tab.setValueAt(rst.getInt(4),row,3);
						row++;
					}
					pst=con.prepareStatement("select count(*) from attendance where Attendance='Absent' and to_char(empdate,'Month')=to_char(sysdate,'Month') and to_char(empdate,'YYYY')=to_char(sysdate,'YYYY') group by empid");
					rst=pst.executeQuery();
					row=0;
					while(rst.next())
					{
						tab.setValueAt(rst.getInt(1),row,4);
						tab.setValueAt(Integer.parseInt(tab.getValueAt(row,3).toString())+Integer.parseInt(tab.getValueAt(row,4).toString()),row,5);
						row++;
					}
				}
				catch(Exception ee){System.out.println(ee);}
			}
			else if(cmbSel.getSelectedItem().toString().equalsIgnoreCase("Emp_Id"))
			{
				txtSel.setVisible(true);btnSearch.setVisible(true);
			}	
		}
		else if(e.getSource()==btnSearch)
		{
			try
				{
					int row=0;
					pst=con.prepareStatement("select empid,to_char(sysdate,'Month'),to_char(sysdate,'YYY'),count(*) from attendance where Attendance='Present' and to_char(empdate,'Month')=to_char(sysdate,'Month') and to_char(empdate,'YYYY')=to_char(sysdate,'YYYY') and empid=? group by empid");
					pst.setString(1,txtSel.getText());
					rst=pst.executeQuery();
					for(int i=0;i<50;i++)
					{
						for(int j=0;j<6;j++)
							obj[i][j]="";
					}
					if(rst.next())
					{
						tab.setValueAt(rst.getString(1),row,0);
						tab.setValueAt(rst.getString(2),row,1);
						tab.setValueAt(rst.getString(3),row,2);
						tab.setValueAt(rst.getInt(4),row,3);
						row++;
					}
					pst=con.prepareStatement("select count(*) from attendance where Attendance='Absent' and to_char(empdate,'Month')=to_char(sysdate,'Month') and to_char(empdate,'YYYY')=to_char(sysdate,'YYYY') group by empid");
					rst=pst.executeQuery();
					row=0;
					if(rst.next())
					{
						tab.setValueAt(rst.getInt(1),row,4);
						tab.setValueAt(Integer.parseInt(tab.getValueAt(row,3).toString())+Integer.parseInt(tab.getValueAt(row,4).toString()),row,5);
						row++;
					}
				}
				catch(Exception ee){}
		}
	}
	public static void main(String[]args)
	{
		new AttendncCal();
	}
}