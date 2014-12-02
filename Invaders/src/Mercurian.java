import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Timer;


public class Mercurian extends Invader implements ActionListener {

private int points = 40;
private BufferedImage img;
private Point position;
private boolean isActive=true;
private int lives=1;
private int width;
private int height;
private int speed=5;
private boolean cloak = false;
Random rnd=new Random();
Timer cloakTimer = new Timer (2000,this);




public Mercurian(Point point,int parentWidth, int lives)
{
	super(point,parentWidth, lives);
	//this code loads the image for the player. The try catches are used to catch and file io error
	try {
		img = ImageIO.read(getClass().getResource("/mercurian.jpg"));
		System.out.println("***************OK*******************");
	} catch (IOException e) {
		System.out.println("***************CAN'T READ FILE*******************");
		e.printStackTrace();
	}
	
	//the height and width of the player are set via the image size
	this.height = img.getHeight();
	this.width = img.getWidth();
	cloakTimer.start();
	this.position=point;
	}
	
			public void actionPerformed(ActionEvent e) {
				{
					
					if (e.getSource() == cloakTimer){
					cloak=!cloak;
					}}
				}
			@Override
		public void draw(Graphics g) {
			
			if(!cloak)
			{
			//draws the Destroyer image in its current position if not cloaked
			g.drawImage(img, position.x, position.y, width, height, null);
			}
			
		
			}
		}
		
