package com.ahacool.code.com.ahacool.code.animation;

import android.widget.ImageView;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 2018/2/26 下午8:11
 */

public class FrameAnimUtil {

    private boolean mIsRepeat;
    private AnimationListener mAnimationListener;
    private ImageView mImageView;
    private int[] mFrameRes;
    private int mDuration;
    private int mLastFrame;
    private boolean mPause;
    private int mCurrentFrame;

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (mPause) {
                return;
            }
            if (0 == mCurrentFrame) {
                if (mAnimationListener != null) {
                    mAnimationListener.onAnimationStart();
                }
            }
            mImageView.setBackgroundResource(mFrameRes[mCurrentFrame]);
            if (mCurrentFrame == mLastFrame) {
                if (mIsRepeat) {
                    if (mAnimationListener != null) {
                        mAnimationListener.onAnimationRepeat();
                    }
                    mCurrentFrame = 0;
                    play(mCurrentFrame);
                } else {
                    if (mAnimationListener != null) {
                        mAnimationListener.onAnimationEnd();
                    }
                }
            } else {
                mCurrentFrame++;
                play(mCurrentFrame);
            }
        }
    };

    public FrameAnimUtil(ImageView iv, int[] frameRes, int duration, boolean isRepeat) {
        mImageView = iv;
        mFrameRes = frameRes;
        mDuration = duration;
        mLastFrame = frameRes.length - 1;
        mIsRepeat = isRepeat;
    }

    public void updateAnimation(int[] frameRes, int duration, boolean isRepeat) {
        mFrameRes = frameRes;
        mDuration = duration;
        mLastFrame = frameRes.length - 1;
        mIsRepeat = isRepeat;
    }

    public void start() {
        mPause = false;
        play(0);
    }

    public void pause() {
        mPause = true;
        mImageView.removeCallbacks(mRunnable);
    }

    private void play(int i) {
        mCurrentFrame = i;
        mImageView.postDelayed(mRunnable, mDuration);
    }

    public interface AnimationListener {

        void onAnimationStart();

        void onAnimationEnd();

        void onAnimationRepeat();
    }

    public void setAnimationListener(AnimationListener listener) {
        mAnimationListener = listener;
    }

}
