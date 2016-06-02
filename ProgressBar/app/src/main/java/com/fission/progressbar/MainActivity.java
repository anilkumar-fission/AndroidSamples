package com.fission.progressbar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
    Button mDownload;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDownload=(Button)findViewById(R.id.click);
    }
    public void Download(View view){
     progress=new ProgressDialog(this);
        progress.setMessage("Downloading");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();
        final int totalProgressTime=100;
        final Thread thread=new Thread(){
            @Override
            public void run() {
                super.run();
                int downloadedtime=0;
                while (downloadedtime<totalProgressTime){
                    try {
                        sleep(200);
                        downloadedtime=downloadedtime+5;
                        progress.setProgress(downloadedtime);
                    }
                     catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        thread.start();
    }
}
