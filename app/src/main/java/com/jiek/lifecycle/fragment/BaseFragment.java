package com.jiek.lifecycle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import com.jiek.jlogger.JLog;
import com.jiek.jlogger.Logger;

class BaseFragment extends Fragment {
    LifecycleEventObserver observer = new LifecycleEventObserver() {
        @Override
        public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
            d("lifeCycle : " + event.name());
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Logger.registerTag(this.getClass().getSimpleName());
        d("onAttach");
        getLifecycle().addObserver(observer);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        d("onDetach: ");
        getLifecycle().removeObserver(observer);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d("onCreate");
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        d("onCreateView");
        return null;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        d("onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        d("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        d("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        d("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        d("onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        d("onDestroy");
    }

    private void d(String msg) {
        JLog.d(this.getClass().getSimpleName(), msg);
    }

    private void dt(String msg) {
        JLog.e(this.getClass().getSimpleName(), msg, new Throwable());
    }
}
