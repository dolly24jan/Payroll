import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MDI extends JFrame implements ActionListener
{
static int w,h;	
	public class ImagePanel extends JPanel
{
	String str="";
	ImagePanel(String str)
	{
		this.str=str;
	}
	ImagePanel()
	{
		str="image.jpg";
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon(str).getImage(),0,0,w,h,null);
	}
}
	ImagePanel panel=new ImagePanel("payaroll1.jpg");
	JMenu file=new JMenu("File");
	JMenu master=new JMenu("Master"); 
	JMenu monthly=new JMenu("Monthly Transactions");
	JMenu help=new JMenu("Help");
	JMenu others=new JMenu("Others");
	JMenu detail=new JMenu("Employee Detail Form");
	JMenuItem empNew =new JMenuItem("New Employee");
	JMenuItem empUpdate =new JMenuItem("Employee Update");
	
	JMenuItem exit =new JMenuItem("Exit");
	JMenu maker=new JMenu("Masters");
	JMenuItem department =new JMenuItem("Department");
	JMenuItem designation =new JMenuItem("Designation");
	
	JMenuItem payslp =new JMenuItem("Pay Slip");
	JMenuItem attendance =new JMenuItem("Monthly Attendance");
	JMenuItem about =new JMenuItem("About Us");
	JMenuItem attendance1 =new JMenuItem("Attendance");
	JMenuItem leave =new JMenuItem("Leave");
	JMenuItem Income =new JMenuItem("Income Tax");
	JMenuItem allowance =new JMenuItem("Allowance");
	JMenuBar mb=new JMenuBar();
	
	

	MDI()
	{
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension dim=toolkit.getScreenSize();
		h=(int)dim.getHeight();
		w=(int)dim.getWidth();
		
		//panel.setLayout(null);
		add(panel);
		
		//panel.setBackground(new Color(192,192,192));
		exit.addActionListener(this);
		empNew.addActionListener(this);
		empUpdate.addActionListener(this);
		department.addActionListener(this);
		designation.addActionListener(this);
		payslp.addActionListener(this);
		attendance.addActionListener(this);
		about.addActionListener(this);
		attendance1.addActionListener(this);
		leave.addActionListener(this);
		Income.addActionListener(this);
		allowance.addActionListener(this);
		setSize(w,h);
		setVisible(true);
		file.add(exit);
		master.add(detail);master.addSeparator();master.add(maker);
		detail.add(empNew);detail.add(empUpdate);
        maker.add(department);maker.add(designation);
		monthly.add(payslp);monthly.add(attendance);
		help.add(about);
		others.add(attendance1);others.add(leave);others.add(Income);others.add(allowance);
		mb.add(file);mb.add(master);mb.add(monthly);mb.add(help);mb.add(others);
		setJMenuBar(mb);
		file.setMnemonic('f');
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[]args)
	{
		new MDI();
	}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==exit)
		{
			System.exit(0);
		}
		else if(ae.getSource()==empNew)
		{
		    new Employ();
		}
		else if(ae.getSource()==empUpdate)
		{
			new Employ1();
		}
		else if(ae.getSource()==department)
		{
			new DepartMaster();
		}
		else if(ae.getSource()==designation)
		{
			new DesiMaster();
		}
			else if(ae.getSource()==payslp)
		{
			new PaySlp();
		}
			else if(ae.getSource()==attendance)
		{
			new AttendncCal();
		}
			else if(ae.getSource()==about)
		{
			new help1();
		}
			else if(ae.getSource()==attendance1)
		{
			new Attendance();
		}
			else if(ae.getSource()==leave)
		{
			new Leave1();
		}
			else if(ae.getSource()==Income)
		{
			new IncomTax();
		}
					else if(ae.getSource()==allowance)
		{
			new Allowance();
		}
		}
		
}







