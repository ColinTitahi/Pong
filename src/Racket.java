import java.awt.Graphics;
import java.awt.Rectangle;

public class Racket {
	
    private static final int WIDTH = 10, HEIGHT = 60;
    private Pong game;
    private int up, down;
    private int x;
    private int y,ya; 
    private int paddleSpeed = 2;
    
    
    public Racket(Pong game, int up, int down, int x) {
        this.game = game;
        this.x = x;
        y = game.getHeight() / 2;
        this.up = up;
        this.down = down;
    }

    /*
    public void update() {
        if (y > 0 && y < game.getHeight() - HEIGHT - 40) // 29
            y += ya;
        else if (y == 0)
            y++;
        else if (y < game.getHeight() - HEIGHT - 40) //29
            y--;
        
        //System.out.println("y: " + y);
    }
    
    */
    
    public void update() {
    	if ((y > 0) && (y < game.getHeight() - HEIGHT - 40)) {    		
    		y += ya;	
    	}
    	
    	if (y < 0 && ya > 0) {
    		y += ya;;
    	}
    	
    	if (y > game.getHeight() - HEIGHT - 40 && ya < 0 ) {
    		y += ya;
    	}
    }
    

    public void pressed(int keyCode) {
        if (keyCode == up)
            ya = paddleSpeed * -1 ;
        else if (keyCode == down)
            ya = paddleSpeed;
    }

    public void released(int keyCode) {
        if (keyCode == up || keyCode == down)
            ya = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}