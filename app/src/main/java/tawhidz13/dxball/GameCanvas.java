package tawhidz13.dxball;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class GameCanvas extends View {
	private MediaPlayer hitg,hitr;
	private Ball ball;
	private int col;
	public static int score=0;
	private Bar bar;
	private ArrayList<Brick> brick=new ArrayList<Brick>();
	private int canvasWidth,ballSpeed;
	private int tempx=160;
	public static int LIFE;
	public static boolean newLife;
	private float barWidth,brickStartY=0,brickStartX=0;
	private Context context;
	private int tap=0;
	Activity act;
	
	Paint paint;
	float x=0,y=0;
	public float dx = 4, dy = 4;
	boolean firstTime=true;
	
	
	public GameCanvas(Context context) 
	{
		super(context);
		paint = new Paint();
		newLife = true;
		LIFE=3;
		hitg=MediaPlayer.create(context, R.raw.green);
		hitr=MediaPlayer.create(context, R.raw.red);
		this.context=context;
	}
	
	public GameCanvas(Context context,Activity act) 
	{
		super(context);
		this.act=act;
		paint = new Paint();
		newLife = true;
		LIFE=3;
		hitg=MediaPlayer.create(context, R.raw.green);
		hitr=MediaPlayer.create(context, R.raw.red);
		this.context=context;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		float x1,y1;
		
		if(tap==1)
		{
			Intent i = new Intent(context, GameOver.class);
            context.startActivity(i);
		}

		x1=event.getX();
		y1=event.getY();
		
			if(bar.getX()>0)
			{
				if(x1<(canvasWidth/2))
					{
						bar.x-=40;	
					}
			}
			
			if(bar.getX()<canvasWidth-barWidth)
			{
				if(x1>(canvasWidth/2))
				{
					bar.x+=40;	
				}
			}

		
		return super.onTouchEvent(event);
	}

	protected void onDraw(Canvas canvas) 
	{
		canvasWidth=canvas.getWidth();
		if(firstTime)
		{
			firstTime=false;
			//x=canvas.getWidth() / 2;
		//	y=canvas.getHeight() / 2;
			
			
			brickStartX = 0;
	        brickStartY = (canvas.getHeight()/25)*2;
	            for(int i=0; i<4; i++){
	                if(brickStartX>=canvas.getWidth()) {
	                    brickStartX = 0;
	                    brickStartY += canvas.getHeight()/15;
	                }
	                if(i%2==0){
	                    col = Color.RED;
	                    brick.add(new Brick(brickStartX,brickStartY,brickStartX+canvas.getWidth()/5,brickStartY+canvas.getHeight()/15,col,paint));
	                   // brick.get(i).drawObject(canvas);
	                }else{
	                    col = Color.GREEN;
	                    brick.add(new Brick(brickStartX,brickStartY,brickStartX+canvas.getWidth()/5,brickStartY+canvas.getHeight()/15,col,paint));
	                    //brick.get(i).drawObject(canvas);
	                }
	                brickStartX+=canvas.getWidth()/5;
	            }
	    }
	
		if(newLife){
            newLife = false;
        	//ball=new Ball(ball.x, ball.y, 10,paint);           
            
            ballSpeed = 10;
            ball=new Ball(canvas.getWidth()/2,canvas.getHeight()-50,10,paint);
            ball.setDX(ballSpeed);
            ball.setDY(-ballSpeed);
            
            barWidth = canvas.getWidth()/4;
            bar = new Bar(canvas.getWidth()/2-(barWidth/2), canvas.getHeight()-35, barWidth, 30,paint);
        	//bar=new Bar(tempx, 770, 150, 20, paint);
            
            
        }
		
		
		/* if(ball.x>0)
 		{
 			calculateNextPos();
 		}
 		else if(ball.x<canvas.getWidth()-5)

			{
 			ball.x--;
 		}
 		if(ball.y>0)
 		{
 			calculateNextPos2();
 		}
 		else if(ball.y<canvas.getHeight())
 		{
 			ball.y--;
 		}*/
		canvas.drawRGB(255, 255, 255);
		

		drawBall(canvas);
		//ball.drawObject(canvas);
		bar.drawObject(canvas);
		
		  //text
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
        //paint.setFakeBoldText(true);
        canvas.drawText("SCORE: "+score,10,40,paint);

        paint.setTextSize(40);
        //paint.setFakeBoldText(true);
        canvas.drawText("LIFE: "+LIFE,canvas.getWidth()-150,40,paint);
			
		
		for(int i=0;i<brick.size();i++){
	           paint.setColor(Color.TRANSPARENT);
	            brick.get(i).drawObject(canvas);
	           
	        }
		
		//gameover
        if(LIFE == 0 ){//game over
            //game finished life over
                paint.setColor(Color.WHITE);
                canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);

                paint.setTextSize(70);
                paint.setFakeBoldText(true);
                paint.setColor(Color.RED);
                canvas.drawText("GAME OVER",canvas.getWidth()/2-200,canvas.getHeight()/2,paint);
                paint.setColor(Color.BLUE);
                canvas.drawText("SCORE: "+score,canvas.getWidth()/2-160,canvas.getHeight()/2+80,paint);
                canvas.drawText("Tap to close this window",canvas.getWidth()/2-120,canvas.getHeight()/2+160,paint);
                tap=1;
                
                score=0;
                LIFE=3;
                try {
                    Thread.sleep(10000);
                //    Intent i = new Intent(context, GameOver.class);
                  //  context.startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
        }
		
		//brick=new Brick(150, 100, 3, paint);
		
		//float barwidth= (canvasWidth/10)*3;

		/*	for(int i=0;i<3;i++)
			{
				//brickStartY=Brick.height/2;
				brickStartX=Brick.width/2;
				
				for(int j=0;j<5;j++)
				{
					brick[i][j]=new Brick(0+brickStartX,brickStartY, 3, paint);
					brick[i][j].drawObject(canvas);
					brickStartX=brickStartX+ Brick.width+5;
				}
				brickStartY=brickStartY+ Brick.height+5;
			}
		*/
        this.BrickCollision(brick,ball,canvas);
		if((this.brick.size()==0)){
			//paint.setColor(Color.BLACK);
	    //    paint.setTextSize(40);
	        //paint.setFakeBoldText(true);
	      //  canvas.drawText("SCORE: "+999,10,40,paint);

		//	firstTime = true;
          //  newLife = true;		
           // paint.setColor(Color.BLACK);
            //paint.setTextSize(40);
            //paint.setFakeBoldText(true);
           // canvas.drawText("SCORE: "+555,10,40,paint);

			//Intent i = new Intent(context,NextLevel.class);
			//i.putExtra("score", score);
			//context.startActivity(i);
			act.setContentView(new Level2(act));
           // setContentView(new Level2(this));
            //Intent i = new Intent(Ga.this, Start.class);
            //startActivity(i);
        }
		//act.setContentView(new Level2(act));
		this.BarCollision(bar,ball, canvas);
		this.ball.lifeCheck(canvas);
		ball.move();
		invalidate();
	}
	
	 void drawBall(final Canvas canvas) {

	        Runnable runnable = new Runnable() {
	            @Override
	            public void run() {
	            	ball.drawObject(canvas);
	                //draw ball
	                //paint.setColor(Color.rgb(235, 29, 2));
	                //canvas.drawOval(ball.getBall(), paint);
	            }
	        };
	        runnable.run();
	    }
	
	
	public void BarCollision(Bar bar,Ball ball,Canvas canvas){
        // Ball And Bar Collision Detect
        if(((this.ball.getY()+this.ball.getR())>=this.bar.getY())&&((this.ball.getY()+this.ball.getR())<=this.bar.getY()+this.bar.getHeight())&& ((this.ball.getX())>=this.bar.getX())&& ((this.ball.getX())<=this.bar.getX()+this.bar.getWidth())) {
            dy=-dy;
            ball.setDY(-ballSpeed);
        }

    }
	
	public void BrickCollision(ArrayList<Brick> br ,Ball myBall,Canvas canvas) {
        // Ball And Bricks Collision
        for (int i = 0; i < brick.size(); i++) {
            if (((myBall.getY() - myBall.getR()) <= br.get(i).getBottom()) && ((myBall.getY() + myBall.getR()) >= br.get(i).getTop()) && ((myBall.getX()) >= br.get(i).getLeft()) && ((myBall.getX()) <= br.get(i).getRight())) {
                if(br.get(i).getCol()!=Color.RED)
                {
                	hitg.start();
                	this.brick.remove(i);
                    score += 5;
                }
                else
                {
                	hitr.start();
                	br.get(i).setCol(Color.YELLOW);
                	br.get(i).paint.setColor(Color.BLACK);
                	br.get(i).paint.setStyle(Style.STROKE);
                	br.get(i).paint.setColor(Color.YELLOW);
                	br.get(i).paint.setStyle(Style.FILL);
                    score += 2;
                }
                myBall.setDY(-(myBall.getDY()));
            }
        }

    }
	
}
