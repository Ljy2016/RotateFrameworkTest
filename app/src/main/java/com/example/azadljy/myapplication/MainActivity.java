package com.example.azadljy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.azadljy.mylibrary0.Encouragement;
import com.example.azadljy.mylibrary1.Attack;
import com.example.azadljy.mylibrary2.Defense;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void comeon(View v) {
        Encouragement.giveMeFive(this);
        Log.e("TAG", "comeon:加油加油！ ");
    }

    public void attack(View v) {
        Attack.attack(this);
        Log.e("TAG", "comeon:攻击攻击！ ");
    }

    public void defense(View v) {
        Defense.defense(this);
        Log.e("TAG", "comeon:防御防御！ ");
    }
}
