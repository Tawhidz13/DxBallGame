package tawhidz13.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class DrawableObject {
	protected float x;
	protected float y;
	protected Paint paint;
	
	public DrawableObject(float x,float y,Paint paint)
	{
		this.x=x;
		this.y=y;
		this.paint=paint;
	}
	
	public abstract void drawObject(Canvas canvas);

}
