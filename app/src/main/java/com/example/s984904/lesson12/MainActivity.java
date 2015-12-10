package com.example.s984904.lesson12;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnTouchListener {
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = findViewById(R.id.parentLayout);
        v.setOnTouchListener(this);
        text1 = (TextView) findViewById(R.id.text);

    }

    boolean happy = false;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Fragment faceF;
        if (!happy) {
            faceF = new HappyF();
            happy = true;
            text1.setText("This is my happy face!\n Touch to see sad face?!");
        } else {
            faceF = new SadF();
            happy = false;
            text1.setText("This is my sad face!\n Touch to see happy face!\nYEAH! YEAH! YEAH!");
        }
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainF, faceF);
        transaction.addToBackStack(null);
        transaction.commit();


        return false;
    }

}
