package com.jiek.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;

import com.jiek.jlogger.JLog;

/**
 * 仅用于 Dialog 生命周期验证使用
 * <p>
 * show: [ constructor 2 、onContentChanged 、 onCreate 、 onStart 、 show 、 onAttachedToWindow ]
 * dismiss: [onKeyDown: 4 、 onKeyUp: 4 、 onDetachedFromWindow 、 onStop 、 dismiss 、 cancel 、 onBackPressed]
 * outsideCancel: [onDetachedFromWindow 、 onStop 、 dismiss 、 cancel]
 * <p>
 * 退后台：[无生命周期函数被调用]??
 * 回前台：[无生命周期函数被调用]??
 */
public class MyDialog extends AlertDialog {

    protected MyDialog(Context context) {
        super(context);
        d("constructor 1");
    }

    protected MyDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        d("constructor 3");
    }

    protected MyDialog(Context context, int themeResId) {
        super(context, themeResId);
        d("constructor 2");
    }

    public static class MyBuilder extends Builder {

        public MyBuilder(Context context) {
            super(context);
        }

        public MyBuilder(Context context, int themeResId) {
            super(context, themeResId);
        }

        @Override
        public AlertDialog create() {
//            return super.create();
            final AlertDialog dialog = new MyDialog(getContext(), 0);
            dialog.setCancelable(true);
//            if (P.mCancelable) {
            dialog.setCanceledOnTouchOutside(true);
//            }
//            dialog.setOnCancelListener();
//            dialog.setOnDismissListener(P.mOnDismissListener);
//            if (P.mOnKeyListener != null) {
//                dialog.setOnKeyListener(P.mOnKeyListener);
//            }
            return dialog;
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        d("setTitle ");
    }

    @Override
    public void setView(View view) {
        super.setView(view);
        d("setView ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d("onCreate ");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        d("onKeyDown " + keyCode);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        d("onKeyUp " + keyCode);
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean isShowing() {
        d("isShowing ");
        return super.isShowing();
    }

    @Override
    public void create() {
        super.create();
        d("create ");
    }

    @Override
    public void show() {
        super.show();
        d("show ");
    }

    @Override
    public void hide() {
        super.hide();
        d("hide ");
    }

    @Override
    public void dismiss() {
        super.dismiss();
        d("dismiss ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        d("onStart ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        d("onStop ");
    }

    @NonNull
    @Override
    public Bundle onSaveInstanceState() {
        d("onSaveInstanceState ");
        return super.onSaveInstanceState();
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        d("onRestoreInstanceState ");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        d("onBackPressed ");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        d("onContentChanged ");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d("onAttachedToWindow ");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d("onDetachedFromWindow ");
    }

    @Override
    public void cancel() {
        super.cancel();
        d("cancel ");
    }

    private void d(String msg) {
        JLog.d(this.getClass().getSimpleName(), msg);
    }

    private void dt(String msg) {
        JLog.e(this.getClass().getSimpleName(), msg, new Throwable());
    }
}
