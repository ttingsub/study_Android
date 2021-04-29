package com.example.my10_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Sub1Activity extends AppCompatActivity {
    private static final String TAG = "main:Sub1Activity";
    Button btnSub1;
    TextView tvSub1;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        btnSub1 = findViewById(R.id.btnSub1);
        tvSub1 = findViewById(R.id.tvSub1);

        //메인에서 보낸 데이터 받기
        intent = getIntent();
        if(intent != null){
            String id = intent.getStringExtra("id");
            int pw = intent.getIntExtra("pw",0);
            PersonDTO personDTO1 = (PersonDTO) intent.getSerializableExtra("personDTO1");
            Log.d(TAG, "onCreate: id =>" + id + ", pw => " + pw);

            tvSub1.setText("id =>" + id + ", \npw => " + pw);
            tvSub1.append("\nDTO id => " + personDTO1.getId()
                           + "\nDTO pw => " + personDTO1.getPw());
        }

        btnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //메인에게 인텐트 만들어서 데이터 보내기
                Intent reIntent = new Intent();
                reIntent.putExtra("key",
                        tvSub1.getText().toString() + " : ㅋㅋㅋ");
                setResult(RESULT_OK, reIntent);
                finish();
            }
        });
    }
}