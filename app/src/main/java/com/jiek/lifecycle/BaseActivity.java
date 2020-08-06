package com.jiek.lifecycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import com.jiek.jlogger.JLog;
import com.jiek.jlogger.Logger;

abstract class BaseActivity extends AppCompatActivity {
    LifecycleEventObserver observer = new LifecycleEventObserver() {
        @Override
        public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
            JLog.d(source.getClass().getName(), event.name());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.setDebug();
        Logger.registerTag(this.getClass().getSimpleName());

        getLifecycle().addObserver(observer);
        d("onCreate");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        d("onConfigurationChanged: ");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        d("onPostResume: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        d("onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        d("onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(observer);
        d("onDestroy: ");
    }

    @Override
    public boolean supportRequestWindowFeature(int featureId) {
        d("supportRequestWindowFeature: ");
        return super.supportRequestWindowFeature(featureId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        d("onActivityResult: ");
    }

//    @Nullable
//    @Override
//    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
//        d("onCreateView: ");
//        return super.onCreateView(parent, name, context, attrs);
//    }

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
//        d("onCreateView: ");
//        return super.onCreateView(name, context, attrs);
//    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        d("onLowMemory: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        d("onPause: ");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        d("onNewIntent: ");
    }

    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
        d("onStateNotSaved: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        d("onResume: ");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        d("onBackPressed: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        d("onCreate: ");
    }

    @Override
    protected void onRestart() {
        d("onRestart: ");
        super.onRestart();
    }

    @Override
    public void onTrimMemory(int level) {
        d("onTrimMemory: " + level);
        super.onTrimMemory(level);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        dt("onKeyLongPress: ");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        d("onKeyUp: ");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        d("onTouchEvent: ");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        d("dispatchTouchEvent: " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        d("onPointerCaptureChanged: ");
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        d("onAttachFragment: ");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d("onDetachedFromWindow: ");
    }

    private void d(String msg) {
        JLog.d(this.getClass().getSimpleName(), msg);
    }

    private void dt(String msg) {
        JLog.e(this.getClass().getSimpleName(), msg, new Throwable());
    }
}
