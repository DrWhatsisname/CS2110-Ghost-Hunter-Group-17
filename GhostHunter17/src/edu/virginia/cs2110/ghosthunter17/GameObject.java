package edu.virginia.cs2110.ghosthunter17;

import android.graphics.Canvas;
import android.graphics.PointF;

public abstract class GameObject {

	protected PointF pos;

	public GameObject(){
		this.pos = new PointF();
	}
	
	public GameObject(float x, float y) {
		this.pos = new PointF(x, y);
	}

	public GameObject(PointF pos) {
		this.pos = pos;
	}

	public abstract void update(float timePassed);

	public abstract void render(Canvas c);

}
