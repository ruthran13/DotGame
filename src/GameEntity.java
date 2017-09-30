
public abstract class GameEntity {
	
	protected int width;
	protected int height;
	
	protected int x;
	protected int y;
	
	protected int gameWidth;
	protected int gameHeight;
	protected int speed;
	
	
	public GameEntity(int gameWidth, int gameHeight, int width, int height, int startX, int startY, int speed){
		
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		
		this.x = startX;
		this.y = startY;
		
		this.width = width;
		this.height = height;
		
		this.speed = speed;
		
	}

	public abstract void update();
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
