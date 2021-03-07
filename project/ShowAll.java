import java.awt.*;
import javax.swing.*;
import java.sql.*;
class ShowAll extends JFrame
{
	String heading[]={"Emp_name","F_Name","Address","Emp_id"};
	Object object[][];
	JTable tab;
	JScrollPane jsp;
	Connection con;
	PreparedStatement pst;
	ResultSet rst;
	{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			int row=0;
			con=DriverManager.getConnection("Jdbc:Odbc:Oracle","system","oracle");
			pst=con.prepareStatement("Select count(*) from entryform");
			rst=pst.executeQuery();
			if(rst.next())
			{
				row=rst.getInt(1);
				object=new Object[row][4];
				for(int i=0;i<row;i++)
				for(int j=0;j<4;j++)
				object[i][j]="";
			}
			tab=new JTable(object,heading);
			jsp=new JScrollPane(tab);
		}
		catch(Exception e){}
	}
	ShowAll()
	{
		add(jsp);
		try{
			pst=con.prepareStatement("Select name,fname,address,emp_id from entryform");
			rst=pst.executeQuery();
			int row=0;
			while(rst.next())
			{
				tab.setValueAt(rst.getString(1),row,0);
				tab.setValueAt(rst.getString(2),row,1);
				tab.setValueAt(rst.getString(3),row,2);
				tab.setValueAt(rst.getString(4),row,3);
				row++;
			}
		}
		catch(Exception e){}
		setSize(400,400);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[]args)
	{
		new ShowAll();
	}
}

