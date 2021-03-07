import java.awt.*;
import javax.swing.*;
import java.awt.print.*;
import java.awt.event.*;
public class Report extends JFrame implements ActionListener,Printable
{
	JLabel lblLabel=new JLabel("Report Page");
	JLabel lblName=new JLabel("Name");
	JLabel lblName1=new JLabel("");
	JLabel lblFName=new JLabel("Fathers Name");
	JLabel lblFName1=new JLabel("");
	JLabel lblAddress=new JLabel("Address");
	JLabel lblAddress1=new JLabel("");
	JLabel lblGender=new JLabel("Gender");
	JLabel lblGender1=new JLabel("");
	JLabel lblHQualification=new JLabel("Higher Qualification");
	JLabel lblHQualification1=new JLabel("");
	JLabel lblNationality=new JLabel("Nationality");
	JLabel lblNationality1=new JLabel("");
	JLabel lblDOB=new JLabel("Date Of Birth");
	JLabel lblDOB1=new JLabel("");
	JLabel lblHobbies=new JLabel("Hobbies");
	JLabel lblHobbies1=new JLabel("");
	JPanel panel=new JPanel();
	JButton btnPrint=new JButton("print",new ImageIcon("print.png"));
	Report()
	{
		add(panel);
		panel.setLayout(null);
		lblLabel.setBounds(0,0,500,40);panel.add(lblLabel);
		lblLabel.setHorizontalAlignment(JLabel.CENTER);
		lblLabel.setFont(new Font("Forte",Font.BOLD+Font.ITALIC,50));
		lblName.setBounds(100,60,100,20);panel.add(lblName);
		lblName1.setBounds(250,60,100,20);panel.add(lblName1);
		lblFName.setBounds(100,100,100,20);panel.add(lblFName);
		lblFName1.setBounds(250,100,100,20);panel.add(lblFName1);
		lblAddress.setBounds(100,140,100,20);panel.add(lblAddress);
		lblAddress1.setBounds(250,140,100,20);panel.add(lblAddress1);
		lblGender.setBounds(100,180,100,20);panel.add(lblGender);
		lblGender1.setBounds(250,180,100,20);panel.add(lblGender1);
		lblHQualification.setBounds(100,220,100,20);panel.add(lblHQualification);
		lblHQualification1.setBounds(250,220,100,20);panel.add(lblHQualification1);
		lblNationality.setBounds(100,260,100,20);panel.add(lblNationality);
		lblNationality1.setBounds(250,260,100,20);panel.add(lblNationality1);
		lblDOB.setBounds(100,300,100,20);panel.add(lblDOB);
		lblDOB1.setBounds(250,300,100,20);panel.add(lblDOB1);
		lblHobbies.setBounds(100,340,100,20);panel.add(lblHobbies);
		lblHobbies1.setBounds(250,340,200,20);panel.add(lblHobbies1);
		btnPrint.setBounds(200,380,100,30);panel.add(btnPrint);
		
		
		lblName1.setText(EntryForm.txtName.getText());
		lblFName1.setText(EntryForm.txtF_name.getText());
		lblAddress1.setText(EntryForm.txtaAddress.getText());
		if(EntryForm.rdMale.isSelected())
			lblGender1.setText("Male");
		else
			lblGender1.setText("FeMale");
		lblHQualification1.setText(EntryForm.cmbQualificatin.getSelectedItem().toString());
		lblNationality1.setText(EntryForm.lstNationality.getSelectedValue().toString());
		
		lblDOB1.setText(EntryForm.cmbDate.getSelectedItem().toString()+"/"+EntryForm.cmbMonth.getSelectedItem().toString()+"/"+EntryForm.cmbYear.getSelectedItem().toString());
		
		String str="";
		if(EntryForm.chGames.isSelected())
			str=str+"/ Games";
		if(EntryForm.chPainting.isSelected())
			str=str+"/ Painting";
		if(EntryForm.chSBooks.isSelected())
			str=str+"/ Books Reading";
		str=str+"/"+EntryForm.txtOther.getText();
		lblHobbies1.setText(str);
		btnPrint.addActionListener(this);
		setSize(500,500);
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












