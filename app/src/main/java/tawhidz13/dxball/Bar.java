package tawhidz13.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Bar extends DrawableObject {
	
	private float width;
	private float height;
	
	public Bar(float x,float y,float width,float height,Paint paint)
	{
		super(x,y,paint);
		this.width=width;
		this.height=height;
	}

	@Override
	public void drawObject(Canvas canvas) {
		// TODO Auto-generated method stub
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.FILL);
		canvas.drawRect(this.x , this.y , this.x+this.width , this.y+this.height , paint);
	}
	
	public float getX() {
        return this.x;
    }
	
	public float getY() {
        return this.y;
    }
	
	public float getWidth() {
        return this.width;
    }
	
	public float getHeight() {
        return this.height;
    }

}
