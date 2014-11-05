package edu.virginia.cs2110.ghosthunter17;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {

	private long lastTime;
	private float x;
	private float y;
	private float vx;
	private float vy;
	
	private static final float SIZE = 200;

	public GameView(Context context) {
		super(context);
		lastTime = System.currentTimeMillis();
		x = 10;
		y = 10;
		vx = 100;
		vy = 100;
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		lastTime = System.currentTimeMillis();
		x = 10;
		y = 10;
		vx = 100;
		vy = 100;
	}

	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		lastTime = System.currentTimeMillis();
		x = 10;
		y = 10;
		vx = 100;
		vy = 100;

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		update();
		
		render(canvas);
		
		this.invalidate();
	}

	private void render(Canvas c) {
		Paint p = new Paint();
		p.setColor(0xffff0000);
		c.drawRect(x,y,x+SIZE,y+SIZE, p);
	}

	private void update() {
		long thisTime = System.currentTimeMillis();
		float timePassed = (thisTime - lastTime)/1000.0f;
		lastTime = thisTime;
		
		this.x += vx * timePassed;
		this.y += vy * timePassed;
		
		if (x + SIZE > this.getWidth()){
			x = this.getWidth()-SIZE;
			vx = -vx;
		}
		else if (x < 0){
			x = 0;
			vx = -vx;
		}
		if (y +SIZE > this.getHeight()){
			y = this.getHeight()-SIZE;
			vy = -vy;
		}
		else if (y < 0){
			y = 0;
			vy = -vy;
		}
		
	}

}
