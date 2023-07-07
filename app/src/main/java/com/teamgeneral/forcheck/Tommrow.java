package com.teamgeneral.forcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Tommrow extends AppCompatActivity {
private ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tommrow);
        back_btn=(ImageView) findViewById(R.id.back_btn);

       back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Tommrow.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}