package com.example.my01_helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etPhoneNum;
    Button btnCall, newPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml에 선언된 위젯을 찾는다
        etPhoneNum = findViewById(R.id.editText);
        btnCall = findViewById(R.id.btnCall);


        //클릭할때마다 밑에 기능이 실행됨됨
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = "tel:" + etPhoneNum.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse(phoneNum));
                startActivity(intent);
            }
        });
        findViewById(R.id.newPage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onBtn1Clicked(View view){
        Toast.makeText(this, "버튼1을 클릭했습니다.", Toast.LENGTH_SHORT).show();
    }
    public void onBtn2Clicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }
    public void onBtnCall(View view){

    }
}