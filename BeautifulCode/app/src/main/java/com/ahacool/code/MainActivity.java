package com.ahacool.code;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahacool.code.com.ahacool.code.animation.FrameAnimUtil;

/**
 * Description: 运行Android代码的Main Activity。
 *
 * @author: moto
 * @time: 17/10/14 上午9:30
 */

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private FrameAnimUtil mFrameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }


    private void initUI() {
        mImageView = (ImageView) findViewById(R.id.anim_image);
        mTextView1 = (TextView) findViewById(R.id.play_tv);
        mTextView2 = (TextView) findViewById(R.id.pause_tv);
        mTextView3 = (TextView) findViewById(R.id.p1_tv);
        mTextView4 = (TextView) findViewById(R.id.p2_tv);

        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(R.array.p1, true);
            }
        });
        mTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(R.array.p1, false);
            }
        });
        mTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(R.array.p2, true);
            }
        });
        mTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(R.array.p2, false);
            }
        });
    }

    private void startAnimation(int resourceId, boolean repeatFlag) {
        if (mFrameAnimation == null) {
            mFrameAnimation = new FrameAnimUtil(mImageView, getRes(resourceId), 40, repeatFlag);
            mFrameAnimation.start();
        } else {
            mFrameAnimation.pause();
            mFrameAnimation.updateAnimation(getRes(resourceId), 40, repeatFlag);
            mFrameAnimation.start();
        }
    }

    private int[] getRes(int id) {
        TypedArray typedArray = getResources().obtainTypedArray(id);
        int len = typedArray.length();
        int[] resId = new int[len];
        for (int i = 0; i < len; i++) {
            resId[i] = typedArray.getResourceId(i, -1);
        }
        typedArray.recycle();
        return resId;
    }

}
