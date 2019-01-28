package tawhidz13.dxball;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class DxBallActivity extends Activity {
	private Button Button;
	private MediaPlayer introSong;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        introSong=MediaPlayer.create(DxBallActivity.this,R.raw.fade);
        introSong.setLooping(true);
        introSong.start();
        ImageView logo = (ImageView)findViewById(R.id.logoImage);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo);
        logo.startAnimation(animation);
        Button = (Button) findViewById(R.id.button);
    }
    

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		introSong.release();
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}


	public void StartClicked(View view)
    {
        Intent i = new Intent(DxBallActivity.this, Start.class);
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