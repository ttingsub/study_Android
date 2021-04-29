package com.example.my15_touchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    View view1;
    View view2;
    ScrollView scrollView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        scrollView = findViewById(R.id.ScrollView);

        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float curX = event.getX();
                float curY = event.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    printString("손가락 눌림" + curX + ", " + curY);
                } else if(action == MotionEvent.ACTION_MOVE) {
                    printString("손가락 움직임" + curX + ", " + curY);
                } else if(action == MotionEvent.ACTION_UP){
                    printString("손가락 똄" + curX + ", " + curY);
                }
                return true;
            }
        });

        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                detector.onTouchEvent(event);

                return true;
            }
        });
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            // 화면이 눌렸을 때
            @Override
            public boolean onDown(MotionEvent e) {
                printString("onDown() 호출됨");
                return false;
            }

            // 화면이 눌렸다가 떼어지는 경우
            @Override
            public void onShowPress(MotionEvent e) {
                printString("onShowPress() 호출됨");
            }

            // 화면이 한손가락으로 눌렸다가 떼어지는 경우
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                printString("onSingleTapUp() 호출됨");
                return false;
            }

            // 화면이 눌린채 일정한 속도와 방향으로 움직였다 떼는 경우
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                printString("onScroll() 호출됨 => " + distanceX + ", " + distanceY);
                return false;
            }

            // 화면을 손가락으로 오랫동안 눌렀을 경우
            @Override
            public void onLongPress(MotionEvent e) {
                printString("onLongPress() 호출됨");

            }

            // 화면이 눌린채 가속도를 붙여 손가락으로 움직였다 떼는 경우
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                printString("onFling() 호출됨 =>"  + velocityX + ", " + velocityY);
                return false;
            }
        });
    }

    public void printString(String str){
        textView.append(str + "\n");

        scrollView.fullScroll(View.FOCUS_DOWN);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            printString("시스템에서 [BACK]버튼이 눌렸습니다.");
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_VOLUME_UP){
            printString("시스템에서 [VOLUME_UP]버튼이 눌렸습니다.");
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            printString("시스템에서 [VOLUME_DOWN버튼이 눌렸습니다.");
            return  true;
        }


        return false;
    }
}