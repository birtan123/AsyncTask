package com.example.asynctask2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.os.Handler;
import android.app.ProgressDialog;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {

    DownloadImage asyncTask = null;
    LoginProcess asyncTask2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asyncTask2 = new LoginProcess();
                asyncTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                asyncTask = new DownloadImage();
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }

        });

    }

    private class DownloadImage extends AsyncTask<Void,Void,Boolean>{
        private int progressStatus=0;
        private Handler handler = new Handler();
        boolean chance50oftrue;
        private ProgressDialog pd = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pd.setIndeterminate(false);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GREEN));
            pd.setCancelable(true);
            pd.setMax(100);
            pd.show();
        }

        @Override
        protected Boolean doInBackground(Void...args){
            progressStatus = 0;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(progressStatus < 100) {
                        progressStatus += 1;
                        try {
                            Thread.sleep(30);


                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }



                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                pd.setProgress(progressStatus);
                                if(progressStatus == 100){
                                    pd.dismiss();
                                }

                            }
                        });
                    }

                }
            }).start();

            return chance50oftrue;
        }

        protected void onPostExecute(Boolean  chance50oftrue){

            Random random = new Random();
            chance50oftrue = (random.nextInt(2) == 0) ? true : false;
            Toast.makeText(getApplicationContext(), (chance50oftrue ? "Yes" : "No"), Toast.LENGTH_LONG).show();

        }

    }

    private class LoginProcess extends AsyncTask<Void,Void,Boolean>{
        private ProgressDialog pd = new ProgressDialog(MainActivity.this);

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }


        protected void onPostExecute(Boolean  chance50oftrue){

            Random random = new Random();
            chance50oftrue = (random.nextInt(2) == 0) ? true : false;
            Toast.makeText(getApplicationContext(), (chance50oftrue ? "Yes" : "No"), Toast.LENGTH_LONG).show();
            pd.hide();
        }

   /*     @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=ProgressDialog.show(MainActivity.this,"downloading","");
        }
*/

    }

}
