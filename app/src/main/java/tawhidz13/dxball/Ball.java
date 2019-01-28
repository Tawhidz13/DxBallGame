package tawhidz13.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Ball extends DrawableObject {
	
	private float radius;
	private float dx=0;
	private float dy=0;
	
	
	public Ball(float x,float y,float radius,Paint paint)
	{
		super(x,y,paint);
		this.radius=radius;
	}

	@Override
	public void drawObject(Canvas canvas) {
		// TODO Auto-generated method stub
		paint.setColor(Color.BLACK);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(this.getX(), this.getY(), this.getR(), this.paint);
	}
	
	public float getX() {
        return this.x;
    }

	public float getY() {
        return this.y;
    }
	
	public float getR() {
        return this.radius;
    }
	
    public void setX(float x) {
        this.x = x;
    }

    public float getDX() {
        return dx;
    }

    public float getDY() {
        return dy;
    }


    public void setDX(float dx) {
        this.dx = dx;
    }

    public void setDY(float dy) {
        this.dy = dy;
    }
    
    public void move(){
        x=x+dx;
        y=y+dy;
    }
	
	public void lifeCheck(Canvas canvas)
	{
		if((this.y-this.radius)>=canvas.getHeight()){
            GameCanvas.LIFE -= 1;
            GameCanvas.newLife = true;
        }
		
		if((this.x+this.radius)>=canvas.getWidth() || (this.x-this.radius)<=0){
            this.dx = -this.dx;
        }
		
        if( (this.y-this.radius)<=0){
            this.dy = -this.dy;
        }

	}
	
	public void lifeCheck2(Canvas canvas)
	{
		if((this.y-this.radius)>=canvas.getHeight()){
            GameCanvas.LIFE -= 1;
            //GameCanvas.newLife = true;
            Level2.newLife=true;
        }
		
		if((this.x+this.radius)>=canvas.getWidth() || (this.x-this.radius)<=0){
            this.dx = -this.dx;
        }
		
        if( (this.y-this.radius)<=0){
            this.dy = -this.dy;
        }

	}


}
