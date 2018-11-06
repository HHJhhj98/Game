package com.example.game;

import java.util.Random;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private GameViews mGame;
	Random random;
	long point = 0l;
	private SoundPool msoundPool;
	private SparseIntArray mSoundID;
	private MediaPlayer mPlayer;
	boolean isRelease;
	Handler mHandler = new Handler(new Handler.Callback() {

		@Override
		public boolean handleMessage(Message arg0) {
			// TODO Auto-generated method stub
			int i = random.nextInt(4);
			switch (i) {
			case 0:
				mGame.update(0);
				break;
			case 1:
				mGame.update(1);
				break;
			case 2:
				mGame.update(2);
				break;
			default:
				mGame.update(3);
				break;
			}
			if (point >= 100000) {
				mHandler.sendEmptyMessageDelayed(1, 800);
			} else {
				mHandler.sendEmptyMessageDelayed(1, 1000);
			}
			return false;
		}

	});

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initview();
		loadMusic();
		mHandler.sendEmptyMessage(1);
	}

	private void loadMusic() {
		// TODO Auto-generated method stub
		mPlayer = MediaPlayer.create(this, R.raw.live);
		mPlayer.start();

		mPlayer.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer arg0) {
				// TODO Auto-generated method stub
				mPlayer.start();

			}
		});
	}

	private void initview() {
		// TODO Auto-generated method stub
		random = new Random();
		mGame = (GameViews) findViewById(R.id.game);
		msoundPool = new SoundPool(5, AudioManager.STREAM_RING, 0);
		mSoundID = new SparseIntArray();
		mSoundID.append(1, msoundPool.load(this, R.raw.ring_1, 1));
		mSoundID.append(2, msoundPool.load(this, R.raw.ring_2, 1));
		mGame.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				float x = arg1.getX();
				float y = arg1.getY();
				
				boolean b = mGame.bitMouse(x, y);
				if (b) {
					point += 1000;
					Toast.makeText(MainActivity.this, point + "", 1000).show();
					msoundPool.play(1, 1, 1, 1, 0, 1);

				} else {
					
					Toast.makeText(MainActivity.this, "没有打中，请继续！", 1000).show();
					msoundPool.play(2, 1, 1, 1, 0, 1);
				}
				return false;
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
