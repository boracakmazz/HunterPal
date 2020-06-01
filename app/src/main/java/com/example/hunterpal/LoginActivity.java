package com.example.hunterpal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    EditText editText1, editText2;
    UserDatabaseHelper db;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new UserDatabaseHelper(this);
        editText1 = (EditText) findViewById(R.id.username);
        editText2 = (EditText) findViewById(R.id.password);

        fab = findViewById(R.id.floatingActionButton);

        View view = findViewById(R.id.floatingActionButton);

        Snackbar.make(view,R.string.change_username_button,Snackbar.LENGTH_LONG).show();

    }

    public void onFabClick(View view){
        Intent intent = new Intent(this,ChangeUsernameActivity.class);
        startActivity(intent);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void loginNotification(){
        int notifyID = 1;
        String CHANNEL_ID = "my_channel_01";
        CharSequence name = getString(R.string.channel_name);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID,name,importance);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,"M_CH_ID")
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.notification_pic)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.notification_pic))
                .setContentTitle("Login Successful!")
                .setPriority(Notification.PRIORITY_MAX)
                .setContentText("Welcome to HunterPal");

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,notificationBuilder.build());

    }

    public void onLoginClick(View view){
        String username = editText1.getText().toString();
        String password = editText2.getText().toString();
        Boolean checkUsernamePassword = db.usernamePassword(username,password);

        if(checkUsernamePassword == true){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                loginNotification();
            }
            Toast.makeText(getApplicationContext(),"Welcome to HunterPal! ",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Username or password is incorrect",Toast.LENGTH_SHORT).show();
        }
    }

    public void onRegisterClick(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }


}
