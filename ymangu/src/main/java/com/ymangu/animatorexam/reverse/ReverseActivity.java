package com.ymangu.animatorexam.reverse;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.ymangu.animatorexam.R;

/**
 * Created by gao on 2017/4/16.
 */


/**
 * 两个View翻转切换效果
 * http://blog.csdn.net/caroline_wendy/article/details/50756697
 */
public class ReverseActivity  extends AppCompatActivity {

    private AnimatorSet mRightOutSet; // 右出动画
    private AnimatorSet mLeftInSet; // 左入动画

    private boolean mIsShowBack;
    private FrameLayout mFlContainer;
    private FrameLayout mFlCardBack;
    private FrameLayout mFlCardFront;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse);


        mFlContainer = (FrameLayout) findViewById(R.id.main_fl_container);
        mFlCardBack = (FrameLayout) findViewById(R.id.main_fl_card_back);
        mFlCardFront = (FrameLayout) findViewById(R.id.main_fl_card_front);

        setAnimators(); // 设置动画
        setCameraDistance(); // 设置镜头距离
    }

    // 设置动画
    private void setAnimators() {
        mRightOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.anim_out);
        mLeftInSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.anim_in);

        // 设置点击事件
        mRightOutSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mFlContainer.setClickable(false);
            }
        });
        mLeftInSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mFlContainer.setClickable(true);
            }
        });
    }

    // 改变视角距离, 贴近屏幕
    private void setCameraDistance() {
        int distance = 16000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mFlCardFront.setCameraDistance(scale);
        mFlCardBack.setCameraDistance(scale);
    }

    // 翻转卡片
    public void flipCard(View view) {
        // 正面朝上
        if (!mIsShowBack) {
            mRightOutSet.setTarget(mFlCardFront);
            mLeftInSet.setTarget(mFlCardBack);
            mRightOutSet.start();
            mLeftInSet.start();
            mIsShowBack = true;
        } else { // 背面朝上
            mRightOutSet.setTarget(mFlCardBack);
            mLeftInSet.setTarget(mFlCardFront);
            mRightOutSet.start();
            mLeftInSet.start();
            mIsShowBack = false;
        }

    }
}