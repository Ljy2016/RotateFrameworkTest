package com.example.azadljy.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 作者：Ljy on 2017/2/24.
 * 邮箱：enjoy_azad@sina.com
 */

public class LogActivity extends AppCompatActivity {
    TextView textView;
    String[] running = new String[]{"logcat", "-d", "dalvikvm"};
    Process process;
    String currentLog;
    InputStreamReader reader;
    BufferedReader bufferedReader;
    StringBuffer stringBuffer = new StringBuffer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        textView = (TextView) findViewById(R.id.tv_showlog);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    public void getLog2(View view) {
        view.setVisibility(View.GONE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Process logcatProcess = null;
                BufferedReader bufferedReader = null;
                Log.e("TAG", "run:hahahah ");
                try {
                    /** 获取系统logcat日志信息 */
                    //相当于在命令行运行  logcat -s dalvikm ,  -s表示过滤， 第三个参数表示过滤的条件。如果没有第三个参数，数组长度2，肯定也是可以的。下面有logcat的使      用方法

                    logcatProcess = Runtime.getRuntime().exec(running);
                    bufferedReader = new BufferedReader(new InputStreamReader(logcatProcess.getInputStream()));
                    String line;
                    //筛选需要的字串
                    String strFilter = "hahahah";
                    while (true) {
                        Log.e("TAG", "run:打印日志 ");
                        final StringBuffer stringBuffer = new StringBuffer();
                        if ((line = bufferedReader.readLine()) != null) {
                            //读出每行log信息
                            if (line.indexOf(strFilter) >= 0) {
                                /** 检测到strFilter的log日志语句，进行你需要的处理 */
                                stringBuffer.append(line);
                                stringBuffer.append("\n");
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.append(stringBuffer.toString());
                                    }
                                });
                                break;
                            }

                        }
                    }
                } catch (Exception e) {
                    Log.e("TAG", "run:出错了 ");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void getLog(View view) throws IOException {
        view.setVisibility(View.GONE);

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        process = Runtime.getRuntime().exec(running);
//                        if (reader == null) {
                        reader = new InputStreamReader(process.getInputStream());
//                        }
//                        if (bufferedReader == null) {
                        bufferedReader = new BufferedReader(reader);
//                        }
                        while ((currentLog = bufferedReader.readLine()) != null) {
                            stringBuffer.append(currentLog);
                            stringBuffer.append("\n");
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.append(stringBuffer.toString());
                                stringBuffer.delete(0, stringBuffer.length());
                                int offset = textView.getLineCount() * textView.getLineHeight();
                                if (offset > textView.getHeight()) {
                                    textView.scrollTo(0, offset - textView.getHeight());
                                }
                            }
                        });
//                        bufferedReader.notify();
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}