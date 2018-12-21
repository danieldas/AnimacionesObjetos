package com.android.curso.animacionesobjetos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=findViewById(R.id.btnCambiar);

        imageView=findViewById(R.id.img_gif);

        Glide.with(this).load("https://media.giphy.com/media/xTg8BcAQSa3d36C0ec/giphy.gif")
                .asGif().centerCrop().into(imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Main2Activity.this, MainActivity.class);

                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }
}
