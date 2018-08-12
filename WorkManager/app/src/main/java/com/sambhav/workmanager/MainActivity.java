package com.sambhav.workmanager;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import androidx.work.OneTimeWorkRequest;
import androidx.work.State;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkStatus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WorkManager wm = WorkManager.getInstance();
        Button btnwork = findViewById(R.id.btn);
      final WorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInitialDelay(5, TimeUnit.SECONDS)
                .build();
        btnwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wm.enqueue(workRequest);
            }
        });

        LiveData<WorkStatus> liveData = wm.getStatusById(workRequest.getId());
        liveData.observe(this, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {
                if (workStatus.getState()== State.SUCCEEDED)
                {

                }
            }
        });

    }
}
