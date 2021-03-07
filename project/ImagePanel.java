import java.awt.*;
import javax.swing.*;
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
		g.drawImage(new ImageIcon(str).getImage(),0,0,null);
	}
}