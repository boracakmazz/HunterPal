package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeUsernameActivity extends AppCompatActivity {
    EditText oldUsername, newUsername, password;
    UserDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_username);

        db = new UserDatabaseHelper(this);
        oldUsername = (EditText) findViewById(R.id.old_username);
        newUsername =  (EditText) findViewById(R.id.new_username);
        password = (EditText) findViewById(R.id.change_username_password);

    }

    public void onChangeUsernameClick(View view){
        String s1 = oldUsername.getText().toString();
        String s2 = newUsername.getText().toString();
        String s3 = password.getText().toString();
        Boolean checkUsernamePassword = db.usernamePassword(s1,s3);

        if(s1.equals("") || s2.equals("") || s3.equals("")){
            Toast.makeText(getApplicationContext(),R.string.cannot_be_empty, Toast.LENGTH_SHORT).show();
        }
        else if(s2.equals(s1)){
            Toast.makeText(getApplicationContext(),R.string.old_new_username_same,Toast.LENGTH_SHORT).show();
        }else if(checkUsernamePassword){
            db.updateUsername(s1,s2);
            Toast.makeText(getApplicationContext(),R.string.update_completed,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }

    }

}
