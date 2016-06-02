package com.fission.progresscircle;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    ImageView mDownloadimage;
    Button mDownloading;
    private ProgressDialog progress;
    private int progressBarStatus=0;
    private Handler progressBarHandler=new Handler();
    private long filesize=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDownloadimage=(ImageView)findViewById(R.id.downloadingimage);
        mDownloadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress=new ProgressDialog(v.getContext());
                progress.setCancelable(true);
                progress.setMessage("File Downloding...");
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setProgress(0);
                progress.setMax(100);
                progress.show();
                progressBarStatus=0;
                filesize=0;
              final Thread thread=  new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressBarStatus<100){
                            progressBarStatus=downloadFile();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progressBarHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progress.setProgress(progressBarStatus);
                                }
                            });
                        }
                       if (progressBarStatus>=100){
                           try {
                               Thread.sleep(200);
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                           progress.dismiss();
                       }
                    }

                });
                thread.start();
            }

        });
    }

    private int downloadFile() {
        while (filesize<=1000000)
        {
            filesize++;
            if (filesize==100000){
                return 10;
            }
            else if (filesize==200000){
                return 20;
            }
            else if (filesize==300000){
                return 30;
            }
            else if (filesize==400000){
                return 40;
            }
            else if (filesize==500000){
                return 50;
            }
            else if (filesize==600000){
                return 60;
            }
            else if (filesize==800000){
                return 80;
            }
        }

        return 100;

    }

}
