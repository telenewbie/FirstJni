package com.txznet.testjniapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tele.jni.TestJni;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clicktestjni(View view) {
        Toast.makeText(this, "hello :"+TestJni._get_UID(), Toast.LENGTH_SHORT).show();
    }
}
