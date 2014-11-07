package edu.virginia.cs2110.ghosthunter17;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

public class Box extends GameObject {
	
	public static int boundX, boundY;

	private PointF vel, size;
	private Paint p;


	public Box(PointF pos, PointF vel) {
		super(pos);
		this.vel = vel;
		this.size = new PointF(100, 100);

		this.p = new Paint();
		p.setColor(0xffff0000);
	}

	@Override
	public void update(float timePassed) {
		this.pos.x += vel.x * timePassed;
		this.pos.y += vel.y * timePassed;
		
		if (pos.x + size.x > boundX){
			pos.x = boundX-size.x;
			vel.x = -vel.x;
		}
		else if (pos.x < 0){
			pos.x = 0;
			vel.x = -vel.x;
		}
		if (pos.y + size.y > boundY){
			pos.y = boundY-size.y;
			vel.y = -vel.y;
		}
		else if (pos.y < 0){
			pos.y = 0;
			vel.y = -vel.y;
		}

	}

	@Override
	public void render(Canvas c) {
		c.drawRect(pos.x, pos.y, pos.x + size.x, pos.y + size.y, p);
	}

}
