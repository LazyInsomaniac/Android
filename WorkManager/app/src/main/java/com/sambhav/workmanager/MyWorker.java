package com.sambhav.workmanager;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;

public class MyWorker extends Worker {
    @NonNull
    @Override
    public Result doWork() {
        Log.e("TAG", "doWork: ");
        return Result.SUCCESS;
    }
}
