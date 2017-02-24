package com.example.azadljy.mylibrary1;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：Ljy on 2017/2/23.
 * 邮箱：enjoy_azad@sina.com
 */

public class Attack {
    public static void attack(Context context) {
        Toast.makeText(context, "攻击敌人，造成一万点伤害！", Toast.LENGTH_SHORT).show();
    }
}
