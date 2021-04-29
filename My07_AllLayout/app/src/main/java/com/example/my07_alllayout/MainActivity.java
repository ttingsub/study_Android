package com.example.my07_alllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnChange1, btnChange2;
    ImageView imageDream1, imageDream2, imageDream3, imageView1, imageView2;
    int selImg = 2;
    int selImg2 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageDream1 = findViewById(R.id.imageDream1);
        imageDream2 = findViewById(R.id.imageDream2);
        imageDream3 = findViewById(R.id.imageDream3);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        //동적으로 보이게
        imageDream1.setVisibility(View.VISIBLE);
        imageDream2.setVisibility(View.GONE);
        imageDream3.setVisibility(View.GONE);

        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.GONE);

        btnChange1 = findViewById(R.id.btnChange1);
        btnChange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selImg == 1){
                    imageDream1.setVisibility(View.VISIBLE);
                    imageDream2.setVisibility(View.GONE);
                    imageDream3.setVisibility(View.GONE);
                    selImg = 2;
                }else if(selImg == 2){
                    imageDream1.setVisibility(View.GONE);
                    imageDream2.setVisibility(View.VISIBLE);
                    imageDream3.setVisibility(View.GONE);
                    selImg = 3;
                }else if(selImg == 3){
                    imageDream1.setVisibility(View.GONE);
                    imageDream2.setVisibility(View.GONE);
                    imageDream3.setVisibility(View.VISIBLE);
                    selImg = 1;
                }
            }
        });
        btnChange2 = findViewById(R.id.btnChange2);
        btnChange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selImg2 == 1){
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.GONE);
                    selImg2 = 2;
                }else if(selImg2 == 2){
                    imageView1.setVisibility(View.GONE);
                    imageView2.setVisibility(View.VISIBLE);
                    selImg2 = 1;
                }
            }
        });
    }
}