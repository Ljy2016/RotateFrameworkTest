package com.example.azadljy.myapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.azadljy.mylibrary0.Encouragement;
import com.example.azadljy.mylibrary1.Attack;
import com.example.azadljy.mylibrary2.Defense;
import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private SimpleDateFormat mFormatter = new SimpleDateFormat("MMMM dd yyyy hh:mm aa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void comeon(View v) {
//        Encouragement.giveMeFive(this);
//        Log.e("TAG", "comeon:加油加油！ ");

        new SlideDateTimePicker.Builder(getSupportFragmentManager())
                .setListener(listener)
                .setInitialDate(new Date())
                .build()
                .show();
    }

    public void attack(View v) {
        Attack.attack(this);
        Log.e("TAG", "comeon:攻击攻击！ ");
    }

    public void defense(View v) {
        Defense.defense(this);
        Log.e("TAG", "comeon:防御防御！ ");
    }

    private SlideDateTimeListener listener = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date) {
            Toast.makeText(MainActivity.this,
                    mFormatter.format(date), Toast.LENGTH_SHORT).show();
        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel() {
            Toast.makeText(MainActivity.this,
                    "Canceled", Toast.LENGTH_SHORT).show();
        }
    };
}
