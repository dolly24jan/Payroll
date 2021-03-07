import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class help1 extends JFrame implements Runnable
{
	
	JLabel lbl1=new JLabel("Loading Help.....");
	JLabel lbl2=new JLabel("Raman & Kumar Construction Ltd.");
	JProgressBar p=new JProgressBar(0,100);
	JPanel panel=new JPanel();
	JLabel lblImage2=new JLabel(new ImageIcon("prog.jpg"));
	int w,h;
	help1()
	{
		super("Help in Progress");
		panel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("prog.jpg").getImage(),0,0,550,312,null);
			}
		}; 
		setSize(550,350);
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		w=(int)d.getWidth();
		h=(int)d.getHeight();

			panel.setLayout(null);
		add(panel);
		lbl1.setBounds(70,10,300,50);
		lbl2.setBounds(15,60,520,50);
		panel.add(lbl1);panel.add(lbl2);
		lbl1.setFont(new Font("Lucida calligraphy",Font.BOLD,30));
		lbl2.setFont(new Font("Lucida calligraphy",Font.BOLD,25));
		lbl1.setForeground(Color.black);
		lbl2.setForeground(Color.blue);
		lblImage2.setBounds(0,0,550,310);panel.add(lblImage2);
			p.setBounds(80,260,350,25);panel.add(p);
		setVisible(true);
		setLocation(w/2-200,h/2-250);
		
		Thread th=new Thread(this);
		th.start();
		p.setBackground(Color.pink);
		p.setForeground(Color.black);
		p.setStringPainted(true);
	}
	public void run()
	{
		try
		{
		for(int i=0;i<=100;i++)
		{
			p.setValue(i);
			
			p.setString(i+" % Completed");
			Thread.sleep(70);
		}
		dispose();
			new Help2();
		}
		catch(InterruptedException e){}	
	}
	public static void main(String[]args)
	{
		new help1();
	}
}