package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Practical_6_3 extends AppCompatActivity {

    Button btnLoader, btnHorizontal;
    ProgressBar progressBar;
    ProgressDialog progressDialog;
    Handler handler = new Handler();
    int status = 0;
    long fileSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical63);

        btnLoader = findViewById(R.id.btnLoader);
        btnHorizontal = findViewById(R.id.btnHorizontal);
        progressBar = findViewById(R.id.spinner);

        btnLoader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.GONE);

                progressDialog = new ProgressDialog(view.getContext());
                progressDialog.setCancelable(false);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMessage("Downloading Resources");
                progressDialog.setProgress(0);
                progressDialog.setMax(100);
                progressDialog.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (status < 100) {
                            status = doOperation();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.setProgress(status);
                                }
                            });
                        }
                        if (status >= 100) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                        }
                    }
                }).start();
            }
        });

    }

    private int doOperation() {
        while (fileSize <= 10000) {
            fileSize++;
            if (fileSize == 1000) {
                return 10;
            } else if (fileSize == 2000) {
                return 20;
            } else if (fileSize == 3000) {
                return 30;
            } else if (fileSize == 4000) {
                return 40;
            } else if (fileSize == 5000) {
                return 50;
            } else if (fileSize == 6000) {
                return 60;
            } else if (fileSize == 7000) {
                return 70;
            } else if (fileSize == 8000) {
                return 80;
            } else if (fileSize == 9000) {
                return 90;
            }
        }
        return 100;
    }
}