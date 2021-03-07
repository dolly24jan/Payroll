import java.awt.*;
import javax.swing.*;
public class ProgressBarDemo extends JFrame implements Runnable
{
	JProgressBar progressBar=new JProgressBar();
	JLabel lblProgress=new JLabel("Process On");
	JPanel panel=new JPanel();
	Thread th=new Thread(this);

	public void run()
	{
		for(int i=1;i<=100;i++)
		{
			try{
				Thread.sleep(200);
				progressBar.setValue(i);
			}
			catch(InterruptedException e){}
		}
	}
	ProgressBarDemo()
	{
		add(panel);
		panel.setLayout(null);
		progressBar.setStringPainted(true);
		lblProgress.setBounds(100,100,200,50);
		progressBar.setBounds(20,200,360,20);
		panel.add(lblProgress);
		panel.add(progressBar);
		setSize(400,300);
		setVisible(true);
		th.start();
	}
}