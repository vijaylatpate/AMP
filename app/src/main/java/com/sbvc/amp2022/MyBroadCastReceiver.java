package com.sbvc.amp2022;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            Toast.makeText(context, "Flight Mode Status is Changed", Toast.LENGTH_LONG).show();
        }
    }
}
