package edu.virginia.cs2110.ghosthunter17;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {

	private long lastTime;
	private List<GameObject> gameObjects;

	public GameView(Context context) {
		super(context);
		init();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		//Initialize things
		lastTime = System.currentTimeMillis();
		
		//Set up GameObject list
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(new Box(new PointF(10, 10), new PointF(150, 150)));
	}

	public void onPause() {

	}

	public void onResume() {
		lastTime = System.currentTimeMillis();
	}
	
//	@Override
//	protected Parcelable onSaveInstanceState() {
//		Parcel p = Parcel.obtain();
//		p.writeList(gameObjects);
//		Parcelable parcel = p.readParcelable(null);
//		p.recycle();
//		return parcel;
//	
//	}
//	
//	@Override
//	protected void onRestoreInstanceState(Parcelable state) {
//		Parcel p = Parcel.obtain();
//		state.writeToParcel(p, 0);
//		p.readList(gameObjects, null);
//		p.recycle();
//	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		Box.boundX = w;
		Box.boundY = h;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//Update the state of the game
		update();

		//Draw everything to the screen
		render(canvas);

		//Redraw the view (call onDraw again)
		this.invalidate();
	}

	private void render(Canvas c) {
		//Draw each GameObject
		for (GameObject g : gameObjects) {
			g.render(c);
		}
	}

	private void update() {
		//Update time
		long thisTime = System.currentTimeMillis();
		float timePassed = (thisTime - lastTime) / 1000.0f;
		lastTime = thisTime;

		//Update each GameObject
		for (GameObject g : gameObjects) {
			g.update(timePassed);
		}

	}

}
