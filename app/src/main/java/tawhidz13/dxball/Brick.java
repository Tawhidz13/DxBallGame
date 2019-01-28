package tawhidz13.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Brick extends DrawableObject {
	
	private float top,bottom,left,right;
	public static float width=50;
	public static float height=20;
	private int hitcount;
	private int col;	
	
	  public Brick(float left,float top,float right,float bottom,int color,Paint paint){
		  	super(left,top,paint);
	        this.left =left;
	        this.top=top;
	        this.right=right;
	        this.bottom=bottom;
	        this.col=color;
	        this.paint=new Paint();
	    	this.paint.setColor(Color.BLACK);
	    	this.paint.setStyle(Style.STROKE);
	        this.paint.setColor(col);
	        this.paint.setStyle(Style.FILL);			
	    
	    		
	    }

	@Override
	public void drawObject(Canvas canvas) {
		// TODO Auto-generated method stub
		//paint.setColor(this.col);
		//paint.setStyle(Style.FILL);
		
	//	paint.setColor(Color.BLACK);
		//paint.setStyle(Style.STROKE);
		

		 canvas.drawRect(this.getLeft(),this.getTop(),this.getRight(),this.getBottom(),this.getPaint());
	}
	
	 public float getLeft() {
	        return left;
	    }

	 public float getRight() {
	        return right;
	    }

	 public float getBottom() {
	        return bottom;
	    }

	 public Paint getPaint() {
	        return paint;
	    }

	 public float getTop() { 
		    return top; 
		}
	 
	 public float getCol() { 
		    return col; 
		}

	 public void setCol(int col) { 
		    this.col=col; 
		}

}
