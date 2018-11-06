package com.example.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GameViews extends View{
	
	Bitmap mpic1,mpic2;
	Context mcontext;
	float mscreamWidth,mscreamHeight,mpicWidth;
	float mpic1x,mpic1y,mpic2x,mpic2y,mpic3x,mpic3y,mpic4x,mpic4y;
	int  mMousepic=0;
	public GameViews(Context context) {
		super(context);
		innit(context);
		// TODO Auto-generated constructor stub
	}
	
	public GameViews(Context context, AttributeSet attrs) {
		super(context, attrs);
		innit(context);
		// TODO Auto-generated constructor stub
	}
	
	public GameViews(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		innit(context);
		// TODO Auto-generated constructor stub
	}
	private void innit(Context context) {
		// TODO Auto-generated method stub
		
		mcontext=context;
		mpic1=BitmapFactory.decodeResource(mcontext.getResources(), R.drawable.mouse);
		mpic2=BitmapFactory.decodeResource(mcontext.getResources(), R.drawable.background);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		mpic2=Bitmap.createScaledBitmap(mpic2, canvas.getWidth(), canvas.getHeight(), true);
		canvas.drawBitmap(mpic2, 0, 0, null);
		mscreamHeight=canvas.getHeight();
		mscreamWidth=canvas.getWidth();
		mpicWidth=(mscreamWidth-50*3)/2;
		mpic1x = mscreamWidth * 28 / 100;
		mpic1y = mscreamHeight * 20 / 100;
		mpic2x = mscreamWidth * 63 / 100;
		mpic2y = mscreamHeight * 19 / 100;
		mpic3x = mscreamWidth * 22 / 100;
		mpic3y = mscreamHeight * 51 / 100;
		mpic4x = mscreamWidth * 64 / 100;
		Log.e("mMousepic",mMousepic+"");
		switch (mMousepic) {
		case 0:
			canvas.drawBitmap(mpic1, mpic1x, mpic1y, null);
			break;
		case 1:
			canvas.drawBitmap(mpic1, mpic2x, mpic2y, null);
			break;
		case 2:
			canvas.drawBitmap(mpic1, mpic3x, mpic3y, null);
			break;
		default:
			canvas.drawBitmap(mpic1, mpic4x, mpic3y, null);
			break;
		}

	}
	public void update(int i) {
		// TODO Auto-generated method stub
		switch (i) {
		case 0:
			mMousepic = 0;
			break;
		case 1:
			mMousepic = 1;
			break;
		case 2:
			mMousepic = 2;
			break;
		default:
			mMousepic = 3;
			break;
		}
		invalidate();
	}

public boolean bitMouse(float x,float y) {
	// TODO Auto-generated method stub
	if ((x >= mscreamWidth / 4 && x <= mscreamWidth * 48 / 100)
			&& (y >= mscreamHeight / 4 && y <= mscreamHeight / 2)) {
		if (mMousepic == 0) {
			return true;
		} else {
			return false;
		}
	} else if ((x >= mscreamWidth * 3 / 5 && x <= mscreamWidth * 88 / 100)
			&& (y >= mscreamHeight / 4 && y <= mscreamHeight / 2)) {
		if (mMousepic == 1) {
			return true;
		} else {
			return false;
		}
	} else if ((x >= mscreamWidth / 4 && x <= mscreamWidth * 48 / 100)
			&& (y >= mscreamHeight / 2 && y <= mscreamHeight * 5 / 6)) {
		if (mMousepic == 2) {
			return true;
		} else {
			return false;
		}
	} else if ((x >= mscreamWidth * 3 / 5 && x <= mscreamWidth * 88 / 100)
			&& (y >= mscreamHeight / 2 && y <= mscreamHeight * 5 / 6)) {
		if (mMousepic == 3) {
			return true;
		} else {
			return false;
		}
	} else {
		return false;
	}

}
}
