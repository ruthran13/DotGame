
public class Ball extends GameEntity {
	
	private int dx;		//>>
	private int dy;		//>>
	
	public Ball(int gameWidth, int gameHeight, int size, int startX, int startY, int speed){
		super(gameWidth, gameHeight, size, size, startX, startY, speed);
		this.dx = this.speed;		//>>
		this.dy = this.speed;		//>>
	}
	
	/**
	 * Update ball location
	 */
	public void update(){		
		x = x + dx;
		y = y + dy;
		
		if ( x + this.width >= gameWidth  ) {
			dx = -this.speed;
		}
		
		if ( x <= 0 ){
			dx = +this.speed;
		}
		
		if ( y + this.height  >= gameHeight ){			
			dy = -this.speed;
		}
		
		if ( y <= 0 ){
			dy = +this.speed;
		}	
	}
	
	public void reverse(){
		dy = -this.speed;
	}
	
	
}
