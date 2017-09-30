
public class Bat extends GameEntity {

	private int delta;
	
	public Bat(int gameWidth, int gameHeight, int width, int height, int startX, int startY, int speed){
		super(gameWidth, gameHeight, width, height, startX, startY, speed);
	}
	
	public void setLeft(){
		this.delta = -(this.speed);
	}
	
	public void setRight(){
		this.delta = (this.speed); 
	}
	
	public void update(){		
		this.x = this.x + this.delta;
		
		// Check boundary
		if ( this.x <= 0 ){
			this.x = 0;
		}
		
		if ( this.x >= this.gameWidth - this.width){
			this.x = this.gameWidth - this.width;
		}
		
		this.delta = 0;
	}	
}
