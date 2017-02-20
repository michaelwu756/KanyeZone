package members;

import engine.*;
import ui.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class Indicator extends DrawnObject
{
	private static Color ARROW_FILL=Color.DARK_GRAY;
	private static double ARROW_SCALE=0.5;
	private static int ARROW_WIDTH=5;
	
	private static Image bg;
	private static Image arrow;
	
	private double theta;
	
	public Indicator()
	{
		super(0,0);
		newRandomLocation();
	}
	public static void setStaticImage(Image im, Image im2)
	{
		bg = im;
		arrow = im2;
	}
	public void newRandomLocation()
	{
		int sidevalue=(int)(Math.random()*8);
		int edge = GamePanel.BORDER_WIDTH+(int)(Kanyes.DIAMETER/2)+15;
		if (sidevalue==0)
		{
			x=edge+GamePanel.LEFT_PANEL_WIDTH; 
			y=edge;
		}
		else if (sidevalue==1)
		{
			x=(GamePanel.VWIDTH+GamePanel.LEFT_PANEL_WIDTH)/2; 
			y=edge;
		}
		else if (sidevalue==2)
		{
			x=GamePanel.VWIDTH-edge;
			y=edge;
		}
		else if (sidevalue==3)
		{
			x=edge+GamePanel.LEFT_PANEL_WIDTH; 
			y=GamePanel.VHEIGHT/2;
		}
		else if (sidevalue==4)
		{
			x=GamePanel.VWIDTH-edge;
			y=GamePanel.VHEIGHT/2;
		}
		else if (sidevalue==5)
		{
			x=edge+GamePanel.LEFT_PANEL_WIDTH; 
			y=GamePanel.VHEIGHT-edge;
		}
		else if (sidevalue==6)
		{
			x=(GamePanel.VWIDTH+GamePanel.LEFT_PANEL_WIDTH)/2;
			y=GamePanel.VHEIGHT-edge;
		}
		else if (sidevalue==7)
		{
			x=GamePanel.VWIDTH-edge;
			y=GamePanel.VHEIGHT-edge;
		}
		
		boolean angled;
		do
		{
			angled=true;
			theta= Math.random()*2*Math.PI;
			if (theta<(1.0/18)*Math.PI && theta>(-1.0/18)*Math.PI
				|| theta<(0.5+1.0/18)*Math.PI && theta>(0.5-1.0/18)*Math.PI
				|| theta<(1.0+1.0/18)*Math.PI && theta>(1.0-1.0/18)*Math.PI
				|| theta<(1.5+1.0/18)*Math.PI && theta>(1.5-1.0/18)*Math.PI
				|| theta<(2.0+1.0/18)*Math.PI && theta>(2.0-1.0/18)*Math.PI
				|| theta<(0.25+1.0/18)*Math.PI && theta>(0.25-1.0/18)*Math.PI
				|| theta<(0.75+1.0/18)*Math.PI && theta>(0.75-1.0/18)*Math.PI
				|| theta<(1.25+1.0/18)*Math.PI && theta>(1.25-1.0/18)*Math.PI
				|| theta<(1.75+1.0/18)*Math.PI && theta>(1.75-1.0/18)*Math.PI)
				angled = false;
		} while(!angled);
	}
	public double getTheta()
	{
		return theta;
	}
	public void paint(Graphics g)
	{
		Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(ARROW_FILL);
		g2d.drawImage(bg, (int)x-bg.getWidth(null)/2, (int)y-bg.getHeight(null)/2, null);
		g2d.setStroke(new BasicStroke(ARROW_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2d.draw(new Line2D.Double(
			(int)(x-(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.cos(theta)),
			(int)(y-(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.sin(theta)),
			(int)(x+(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.cos(theta)),
			(int)(y+(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.sin(theta))
		));
		g2d.draw(new Line2D.Double(
			(int)(x+(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.cos(theta)),
			(int)(y+(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.sin(theta)),
			(int)(x-(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.sin(theta)),
			(int)(y+(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.cos(theta))
		));
		g2d.draw(new Line2D.Double(
			(int)(x+(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.cos(theta)),
			(int)(y+(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.sin(theta)),
			(int)(x+(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.sin(theta)),
			(int)(y-(ARROW_SCALE*Kanyes.DIAMETER/2)*Math.cos(theta))
		));
	}
}