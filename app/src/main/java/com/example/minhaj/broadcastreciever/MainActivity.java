package com.example.minhaj.broadcastreciever;


import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MTag";
    EditText username;
    EditText password;
    TextView textShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        textShown = (TextView) findViewById(R.id.dataShow);
    }

    public void saveInfo(View view)
    {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username",username.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.apply();

        Snackbar.make(view,"Saved",Snackbar.LENGTH_SHORT).show();

    }

    public void showInfo(View view)
    {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username","");
        String password = sharedPref.getString("password","");

        textShown.setText(name + " " + password);

    }


    public void btnNotification(View view)
    {
        Log.d(TAG, "btnNotification:");

        NotificationCompat.Builder notification = (NotificationCompat.Builder) new NotificationCompat.Builder(MainActivity.this)
                .setContentTitle("Notification").setContentText("Hello notify").setSmallIcon(R.mipmap.ic_launcher);

        Notification mynotification = notification.build();
        NotificationManager mnotificationmanager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mnotificationmanager.notify(0,mynotification);

    }
}
