package com.example.my14_smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "main:MyReceiver";

    // 백그라운드에서 대기하다가 자신에게 오는 데이터를 수신
    @Override //                    메인   메세지수신 데이터
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: 호출됨");

        // 내부적으로 데이터를 저장할 수 있는 객체 : Bundle
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);


    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];

        for(int i=0; i< objs.length; i++){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){//API23
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format);
        }
    }
}