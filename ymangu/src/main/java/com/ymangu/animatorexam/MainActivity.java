package com.ymangu.animatorexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ymangu.animatorexam.lottie.ClickActivity;
import com.ymangu.animatorexam.lottie.NetworkActivity;
import com.ymangu.animatorexam.lottie.SimpleActivity;

import okhttp3.OkHttpClient;

/**
 * 例1： Lottie- 让Android动画实现更简单
 * http://www.jianshu.com/p/9a2136ecbc7b
 * http://www.jianshu.com/p/cae606f45c0b
 */
public class MainActivity extends AppCompatActivity {

    private OkHttpClient client;

    private Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,SimpleActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,ClickActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,NetworkActivity.class);
                startActivity(intent);
            }
        });
    }


}