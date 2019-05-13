package com.example.educatenow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.TimePicker;
import android.widget.Toast;
public class BroadCastGetter extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean no=intent.getBooleanExtra(  ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
        if (no) {
            Toast.makeText(context, "No data connectivity", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(context,"Note: Internet connection has been established",Toast.LENGTH_LONG).show();
        }
    }
}
