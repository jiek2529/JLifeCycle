package com.jiek.lifecycle;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jiek.dialog.MyDialog;
import com.jiek.jlogger.Logger;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.setDebug();
        Logger.registerTag("MyDialog");

        findViewById(R.id.button1).setOnClickListener(onClickListener);
        findViewById(R.id.button2).setOnClickListener(onClickListener);
        findViewById(R.id.button3).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button1:
                    showAlertDialog();
//                    showDialog(1);
                    break;
                case R.id.button2:
                    showDialogActivity();
                    break;
                case R.id.button3:
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                    startActivity(new Intent(MainActivity.this, Page2Activity.class));
                    break;
            }
        }
    };

    private void showDialogActivity() {
        startActivity(new Intent(this, DialogActivity.class));//触发 Activity 的onPause,Dialog 消失再 onResume，因 DialogActivity，会让当前 Activity 是部分可见状态
    }

    private void showAlertDialog() {
//        方式一：showDialog 与onCreateDialog 配对出现
//            showDialog(1);//不会触发 Activity 的生命周期方法

//        方式二：
        final EditText et = new EditText(MainActivity.this);
        new /*AlertDialog*/MyDialog
                .MyBuilder(MainActivity.this).setMessage("hello").setView(et)
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "confirm: " + et.getText(), Toast.LENGTH_SHORT).show();
                    }
                }).setNeutralButton("中立", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "TODO: " + et.getText(), Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, " cancel", Toast.LENGTH_SHORT).show();
            }
        })
                .create().show();//不会触发 Activity 的生命周期方法
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        return new MyDialog.Builder(MainActivity.this).setMessage("hello").create();
//        return super.onCreateDialog(id);
    }
}
