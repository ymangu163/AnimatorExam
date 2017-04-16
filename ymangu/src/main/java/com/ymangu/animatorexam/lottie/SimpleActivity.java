package com.ymangu.animatorexam.lottie;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.ymangu.animatorexam.R;

/**
 * @author  zkk
 * 简书:    http://www.jianshu.com/u/61f41588151d
 * github: https://github.com/panacena
 */
public class SimpleActivity extends AppCompatActivity {

    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_simple.xml中 lottie_fileName="data.json"
        // 所以只需要在 app/src/main/assets 中添加AE 生成的 json文件，重命名为data.json就可以显示动画
        setContentView(R.layout.activity_lottie_simple);
        animationView = (LottieAnimationView) findViewById(R.id.animation_view);

        //自定义lottie动画
        customAnimator();
    }

    private void customAnimator() {
        /**动画的组合使用*/
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f, 0f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animationView.setProgress((float)animation.getAnimatedValue());
            }
        });
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(animationView,"alpha",0.0f,1.0f,0.0f);
        alphaAnimator.setRepeatCount(ValueAnimator.INFINITE);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimator,alphaAnimator);
        animatorSet.setDuration(10000);
        animatorSet.start();


    }
}
