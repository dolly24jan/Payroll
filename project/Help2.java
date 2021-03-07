import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Help2 extends JFrame implements ActionListener
{
	JLabel lblMessage=new JLabel(new ImageIcon("Ramantop.jpg"));
	JPanel mainPanel=new JPanel();

	JPanel childKalyan;
	String str="<html><body><blockquote>Raman & Kumar Construction Ltd., incorporated in 09 October, 2002. Company have Presently three <br>active Directors/Partners: Sitesh Raman(CMD), Ajit Kumar, Manoj Kumar. <br> It offers priceless wonders for your sight, captivating horizons for your senses and a pictures que<br> environment and embracing your soul. Raman & Kumar Construction Ltd. comforts you with an inviting <br> lap of serenity that calms down worldly anxities when the day is done.<br> It also provides construction of villas and residential buildings,construction of factories, construction <br> of shopping malls & constrction of commercial buildings. Raman & Kumar general maintainance & <br> fascilities management provides all types of general maintainance works. All type of repairing & <br> maintainance for electrical lines and its fixtures. Due to their Such a elegant work company become <br> one of the most prefer name in the construction Industry.Every apartment of the township has been <br> meticulously planned taking care of all the needs to create comfort. <br> The company takes particular care in ensuring that its project featue perfect vasthu and a clear title <br> so as to give buyers a hassle-free and happy ownership. <br></blockquote></body></html>";
	Font fnt=new Font("Arial Rounded MT Bold",Font.BOLD,16);
	JLabel lblKalyan=new JLabel(str);
	JLabel lblImg=new JLabel(new ImageIcon("md.jpg"));
	
	JPanel childPayroll;
	String str1="<html><body><blockquote>PAYROLL MANAGEMENT SYSTEM <br><br>Payroll Management System holds the salary record of all the employees of a company.<br>Employee Payroll System makes many calculations like PAYSLIP of PF, HRA, TA etc<br>This system stores the number of days attended by employees, it also keeps tracks of<br> how many days employees has worked.This system also calculates the salary according<br> to the, number of days attended in the particular month.If the employee takes casual<br>leave,sick leave or earn leave in a particular month then the salary will be deducted.<br>Employee System provides many features for an organization. Some benefits of this<br> system are as follows:<br>1)	Payment Calculation<br> 2)	PAYSLIP Calculation<br>3)	Record Keeping</blockquote></body></html>";
	JLabel lblPayroll=new JLabel(str1);
	JLabel lblImage1=new JLabel(new ImageIcon("pic2.jpg"));
	JPanel childIndex;
	JLabel lblFile=new JLabel("FILE");
	JLabel lblExit=new JLabel("EXIT");
	ButtonGroup bg=new ButtonGroup();
	JRadioButton rdExit=new JRadioButton("EXIT");
	JLabel lblMaster=new JLabel("MASTERS");
	JLabel lblEmpmaster=new JLabel("EMPLOYEE DETAIL MASTERS");
	JLabel lblDepartmaster=new JLabel("DEPARTMENT MASTERS");
	JLabel lblDesigmaster=new JLabel("DESIGNATION MASTERS");
	//ButtonGroup bg=new ButtonGroup();
	JRadioButton rdEmpmaster=new JRadioButton("EMPLOYEE DETAIL MASTER");
    JRadioButton rdDepartmaster=new JRadioButton("DEPARTMENT MASTER");
	JRadioButton rdDesigmaster=new JRadioButton("DESIGNATION MASTER");
	JLabel lblMthlytr=new JLabel("MONTHLY TRANSACTION");
	JLabel lblPayslp=new JLabel("PAYSLIP");
	JLabel lblMthlyattend=new JLabel("MONTHLY ATTENDANCE");
	//ButtonGroup bg=new ButtonGroup();
	JRadioButton rdPayslp=new JRadioButton("PAYSLIP");
	JRadioButton rdMthlyattend=new JRadioButton("MONTHLY ATTENDANCE");
	JLabel lblPyslip=new JLabel("PAY SLIP CALCULATION");
	//ButtonGroup bg=new ButtonGroup();
	JRadioButton rdPyslip=new JRadioButton("PAY SLIP CALCULATION");
   
	
	
	JLabel lblOthrs=new JLabel("OTHERS");
	JLabel lblAttend=new JLabel("ATTENDANCE");
	JLabel lblLeav=new JLabel("LEAVE");
	JLabel lblIncom=new JLabel("INCOME TAX");
		
	//ButtonGroup bg=new ButtonGroup();
	JRadioButton rdAttend=new JRadioButton("ATTENDANCE");
    JRadioButton rdLeav=new JRadioButton("LEAVE");
	JRadioButton rdIncom=new JRadioButton("INCOME TAX");
	JLabel lblImage=new JLabel(new ImageIcon("cal.jpg"));
	
	JTabbedPane tabbedPane=new JTabbedPane();
	
	int w,h;
	
	Help2()
	{
		setTitle("Help");
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		w=(int)d.getWidth();
		h=(int)d.getHeight();
		
		add(mainPanel);
		mainPanel.setLayout(null);
		
		childIndex=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("background-16.jpg").getImage(),0,0,w,h-200,null);
			}
		}; 
		setIconImage(new ImageIcon().getImage());
    	childPayroll=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("help2.jpg").getImage(),0,0,w,h-200,null);
			}
		}; 
		childKalyan=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("help1.jpg").getImage(),0,0,w,h-200,null);
			}
		}; 
    
		tabbedPane.add("Index",childIndex);
		tabbedPane.add("About Raman & Kumar Construction",childKalyan);
		tabbedPane.add("About Payroll System",childPayroll);
		
	
		tabbedPane.setBackgroundAt(0,Color.pink);
		tabbedPane.setBackgroundAt(1,Color.yellow);
		tabbedPane.setBackgroundAt(2,Color.green);
		//kalyanpur tab
		lblKalyan.setBounds(50,250,w-100,h-300);
		childKalyan.add(lblKalyan);
		lblKalyan.setFont(fnt);
	    //payroll tab
		lblPayroll.setBounds(50,250,w-100,h-300);
		lblImage1.setBounds(0,50,200,400);childPayroll.add(lblImage1);
		//lblImag1.setBounds(400,50,200,400);childPayroll.add(lblImag1);
		
		childPayroll.add(lblPayroll);
		lblPayroll.setFont(fnt);
		//index tab
		lblFile.setBounds(180,40,250,20);childIndex.add(lblFile);
		rdExit.setBounds(200,70,250,20);
		rdExit.setOpaque(false);rdExit.addActionListener(this);
	    bg.add(rdExit);childIndex.add(rdExit);
		lblMaster.setBounds(180,120,250,20);childIndex.add(lblMaster);
		rdEmpmaster.setBounds(200,150,250,20);rdEmpmaster.addActionListener(this);
	    rdDepartmaster.setBounds(200,180,255,20);rdDepartmaster.addActionListener(this);
		rdDesigmaster.setBounds(200,210,250,20);rdDesigmaster.addActionListener(this);
	
	rdEmpmaster.setOpaque(false);
	rdDepartmaster.setOpaque(false);
	rdDesigmaster.setOpaque(false);
	bg.add(rdEmpmaster);childIndex.add(rdEmpmaster);
	bg.add(rdDepartmaster);childIndex.add(rdDepartmaster);
	bg.add(rdDesigmaster);childIndex.add(rdDesigmaster);
	lblMthlytr.setBounds(180,250,250,20);childIndex.add(lblMthlytr);
	rdPayslp.setBounds(200,280,250,20);rdPayslp.addActionListener(this);
	//rdAdjust.setBounds(200,370,255,20);rdAdjust.addActionListener(this);
	rdMthlyattend.setBounds(200,310,250,20);rdMthlyattend.addActionListener(this);
	
	rdPayslp.setOpaque(false);
	//rdAdjust.setOpaque(false);
	rdMthlyattend.setOpaque(false);
	bg.add(rdPayslp);childIndex.add(rdPayslp);
	//bg.add(rdAdjust);childIndex.add(rdAdjust);
	bg.add(rdMthlyattend);childIndex.add(rdMthlyattend);
	 rdPyslip.setBounds(200,340,250,20);rdPyslip.addActionListener(this);
	rdPyslip.setOpaque(false);
	bg.add(rdPyslip);childIndex.add(rdPyslip);
	rdIncom.setOpaque(false);
	lblOthrs.setBounds(600,40,250,20);childIndex.add(lblOthrs);
	lblImg.setBounds(0,50,300,500);childKalyan.add(lblImg);
	 rdAttend.setBounds(600,70,250,20);rdAttend.addActionListener(this);
	rdLeav.setBounds(600,100,250,20);rdLeav.addActionListener(this);
	rdIncom.setBounds(600,130,250,20);rdIncom.addActionListener(this);
	rdAttend.setOpaque(false);
	rdLeav.setOpaque(false);
	bg.add(rdAttend);childIndex.add(rdAttend);
	bg.add(rdLeav);childIndex.add(rdLeav);
	bg.add(rdIncom);childIndex.add(rdIncom);
	childIndex.add(rdIncom);
	childIndex.setLayout(null);
	
	lblImage.setBounds(900,0,400,h-200);childIndex.add(lblImage);
	
		
		tabbedPane.setSelectedIndex(0);		
		childKalyan.setBackground(Color.pink);
		childPayroll.setBackground(Color.yellow);
		childIndex.setBackground(Color.green);

		lblMessage.setBounds(0,0,w,200);
		mainPanel.add(lblMessage);
		
		tabbedPane.setBounds(0,200,w,h-200);
		mainPanel.add(tabbedPane);
		
		setSize(w,h);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		public static void main(String[]args)
		{
			new Help2();
		}
		public void actionPerformed(ActionEvent e)
		{
		   if(e.getSource()==rdExit)
		   {
				new Exit();
			}
		  else if(e.getSource()==rdEmpmaster)
		   {
				new EmpMaster();
			}
			else if(e.getSource()==rdDesigmaster)
		   {
				new DesignMaster();
			}
			else if(e.getSource()==rdDepartmaster)
		   {
				new Departmaster();
			}
		
			else if(e.getSource()==rdMthlyattend)
		   {
				new MonthAttend();
			}
			else if(e.getSource()==rdPyslip)
		   {
				new Pyslip();
			}
		
			else if(e.getSource()==rdAttend)
		   {
				new Attnd();
			}
			else if(e.getSource()==rdLeav)
		   {
				new Leav();
			}  
			else
			{
				new Income();
			}
		}
	}
	
	
	class Exit
	{
		JLabel lbl1=new JLabel("<html><body><blockquote>To exit from the application.</html></body></blockquote>");
		JFrame f=new JFrame("Exit");
		Exit()
		{
			f.setSize(400,200);
			f.setLayout(null);
			lbl1.setBounds(10,10,380,100);
			f.add(lbl1);
			f.setBackground(Color.pink);
			f.setVisible(true);
			f.setLocation(750,450);
		}
		public static void main(String []args)
		{
				new Exit();
		}
	}
	class EmpMaster
	{
		JLabel lbl2=new JLabel("<html><body><blockquote>Stores basic information of all employees</html></body></blockquote>");
		JFrame f=new JFrame("Employee Detail");
		EmpMaster()
		{
			f.setSize(400,200);
			f.setLayout(null);
			lbl2.setBounds(10,10,380,100);
			f.add(lbl2);
			f.setBackground(Color.pink);
			f.setVisible(true);
			f.setLocation(750,450);
		}
		public static void main(String []args)
		{
				new EmpMaster();
		}
	}



	class Departmaster
	{
		JLabel lbl5=new JLabel("<html><body><blockquote>Contains list of all the DEPARTMENTs.</html></body></blockquote>");
		JFrame f=new JFrame("DEPARTMENT Master");
		Departmaster()
		{
			f.setSize(400,200);
			f.setLayout(null);
			lbl5.setBounds(10,10,380,100);
			f.add(lbl5);
			f.setBackground(Color.pink);
			f.setVisible(true);
				f.setLocation(750,450);
		}
		public static void main(String []args)
		{
				new Departmaster();
		}
	}
	class DesignMaster
	{
		JLabel lbl6=new JLabel("<html><body><blockquote>Contains list of Designations under each grade</html></body></blockquote>");
		JFrame f=new JFrame("Designation Master");
		DesignMaster()
		{
			f.setSize(400,200);
			f.setLayout(null);
			lbl6.setBounds(10,10,380,100);
			f.add(lbl6);
			f.setBackground(Color.pink);
			f.setVisible(true);
				f.setLocation(750,450);
		}
		public static void main(String []args)
		{
				new DesignMaster();
		}
	}
	
	
	
	class MonthAttend
	{
		JLabel lbl11=new JLabel("<html><body><blockquote>It is the form to input everyday<br> attendance of the employee.</html></body></blockquote>");
		JFrame f=new JFrame("Exit");
		MonthAttend()
		{
			f.setSize(400,200);
			f.setLayout(null);
			lbl11.setBounds(10,10,380,100);
			f.add(lbl11);
			f.setBackground(Color.pink);
			f.setVisible(true);
				f.setLocation(750,450);
		}
		public static void main(String []args)
		{
				new MonthAttend();
		}
	}
	class Pyslip
	{
		JLabel lbl12=new JLabel("<html><body><blockquote>Shows payslip of all employee monthly.</html></body></blockquote>");
		JFrame f=new JFrame("Payslip");
		Pyslip()
		{
			f.setSize(400,200);
			f.setLayout(null);
			lbl12.setBounds(10,10,380,100);
			f.add(lbl12);
			f.setBackground(Color.pink);
			f.setVisible(true);
				f.setLocation(750,450);
		}
		public static void main(String []args)
		{
				new Pyslip();
		}
	}
	

	class Attnd
	{
		JLabel lbl19=new JLabel("<html><body><blockquote>It maintains the everyday Attendance of <br>each employee.</html></body></blockquote>");
		JFrame f=new JFrame("Attendane");
		Attnd()
		{
			f.setSize(400,200);
			f.setLayout(null);
			lbl19.setBounds(10,10,380,100);
			f.add(lbl19);
			f.setBackground(Color.pink);
			f.setVisible(true);
				f.setLocation(750,450);
		}
		public static void main(String []args)
		{
				new Attnd();
		}
	}
	class Leav
	{
		JLabel lbl20=new JLabel("<html><body><blockquote>It maintains the leave details for the <br>leaves taken by the employees.</html></body></blockquote>");
		JFrame f=new JFrame("Leave");
		Leav()
		{
			f.setSize(400,200);
			f.setLayout(null);
			lbl20.setBounds(10,10,380,100);
			f.add(lbl20);
			f.setBackground(Color.pink);
			f.setVisible(true);
				f.setLocation(750,450);
		}
		public static void main(String []args)
		{
				new Leav();
		}
	}
	class Income
	{
		JLabel lbl21=new JLabel("<html><body><blockquote>It maintains the Income Tax details <br>of the employees.</html></body></blockquote>");
		JFrame f=new JFrame("Exit");
		Income()
		{
			f.setSize(400,200);
			f.setLayout(null);
			lbl21.setBounds(10,10,380,100);
			f.add(lbl21);
			f.setBackground(Color.pink);
			f.setVisible(true);
				f.setLocation(750,450);
		}
		public static void main(String []args)
		{
				new Income();
		}
	}