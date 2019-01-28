package tawhidz13.dxball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class GameOver extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.gameover);
	}
	
	public void RestartClicked(View view)
	{
		Intent i = new Intent(GameOver.this, Start.class);
        startActivity(i);
        //finish();
	}
	
	public void ExitClicked(View view)
    {
		//((MainActivity)getContext()).finish();
		moveTaskToBack(true);
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(1);
    }

}
