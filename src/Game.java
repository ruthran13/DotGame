/**
 * Description	:Engine for the brick game
 * Copyright	:Copyright (c) 2014
 * Company		:Embla Software Innovations (Pvt) Ltd
 * Created on	:2014.09.01
 * @author 		:Chandimal
 * @version 	:1.0
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Game extends Canvas implements KeyListener {

	private static final long serialVersionUID = 1L;

	BufferedImage buffer; // Create the buffer
	
	BufferedImage bgImg; // Create the buffer
	
	Ball ball;
	Bat bat;
	
	boolean isKeyLeft;
	boolean isKeyRight;
	
	/**
	 * Create the game using the width and the height specified
	 */
	public Game(Dimension dim) {
		buffer 	= new BufferedImage(dim.width, dim.height,
					BufferedImage.TYPE_INT_RGB);
		ball 	= new Ball(dim.width, dim.height, 10,0,0, 5);			//>>
		bat 	= new Bat(dim.width, dim.height, 100, 10, dim.width/2, dim.height - 40, 5);
		
		
		try {
			bgImg = ImageIO.read(new File("./img/bg.png"));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setIgnoreRepaint(true); // Ignore repainting as we are doing all
										// the drawing stuff
	}

	/**
	 * Start the game
	 */
	public void Start() {

		while (true) {
			
			// Check keys
			if ( isKeyLeft ) bat.setLeft();
			if ( isKeyRight ) bat.setRight();
			
			//Updates
			ball.update();
			bat.update();
			
			// Collision detection
			detectCollision();
			
			// Draw the buffer
			drawBuffer();
			// Paint the buffer on screen
			drawScreen();

			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Detect collision
	 */
	public void detectCollision(){
		
		Rectangle rectBall = new Rectangle(ball.getX(), ball.getY(), ball.getHeight() , ball.getWidth());
		Rectangle rectBat = new Rectangle(bat.getX(), bat.getY(), bat.getWidth() , bat.getHeight());
		
		if ( rectBat.intersects( rectBall )){
			ball.reverse();
		}
		
		
	}
	
	/**
	 * Draw the image buffer
	 */
	public void drawBuffer() {
		Graphics2D b = buffer.createGraphics();
		
		// Black color background		
		b.setColor(Color.BLACK);	
		//b.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
		b.drawImage(bgImg, 0, 0, this);
		
		// Black color background		
		b.setColor(Color.WHITE);	//>>
		b.fillOval( ball.getX() , ball.getY(), ball.getWidth(), ball.getHeight());		//>>
		
		 // Draw bat
		 b.setColor(Color.white);
		 b.fillRoundRect( bat.getX() , bat.getY(), bat.getWidth(), bat.getHeight(),  3, 3 );
	}

	/**
	 *  Update it to the screen
	 */
	public void drawScreen() {
		Graphics2D g = (Graphics2D) this.getGraphics();
		g.drawImage(buffer, 0, 0, this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if ( evt.getKeyCode() == 37 ){
			isKeyLeft = true;
		}
		
		if ( evt.getKeyCode() == 39 ){
			isKeyRight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		if ( evt.getKeyCode() == 37 ){
			isKeyLeft = false;
		}
				
		if ( evt.getKeyCode() == 39 ){
			isKeyRight = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
