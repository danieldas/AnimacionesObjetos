package com.android.curso.animacionesobjetos;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import xyz.hanks.library.bang.SmallBangView;

public class MainActivity extends AppCompatActivity {
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, Main2Activity.class);

                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        textView=findViewById(R.id.texto);


        final SmallBangView like_heart = findViewById(R.id.like_heart);
        like_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like_heart.isSelected()) {
                    like_heart.setSelected(false);
                } else {
                    like_heart.setSelected(true);
                    like_heart.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);

                        }
                    });
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Animation animation;

        //noinspection SimplifiableIfStatement
        if (id == R.id.item_alpha) {
            animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
            textView.startAnimation(animation);
            return true;
        }
        else if (id == R.id.item_rotate) {
            animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            textView.startAnimation(animation);
            return true;
        }
        else if (id == R.id.item_scale) {
            animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
            textView.startAnimation(animation);
            return true;
        }
        else if (id == R.id.item_translate) {
            animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
            textView.startAnimation(animation);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
