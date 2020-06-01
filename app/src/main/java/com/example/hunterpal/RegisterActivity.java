package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3, editText4;
    UserDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new UserDatabaseHelper(this);
        editText1 = (EditText) findViewById(R.id.register_username);
        editText2 = (EditText) findViewById(R.id.register_email);
        editText3 = (EditText) findViewById(R.id.register_password);
        editText4 = (EditText) findViewById(R.id.register_password_confirm);
    }

    public void onRegisterCompleteClick(View view){
        String s1 = editText1.getText().toString();
        String s2 = editText2.getText().toString();
        String s3 = editText3.getText().toString();
        String s4 = editText4.getText().toString();

        if(s1.equals("") || s2.equals("") || s3.equals("")){
            Toast.makeText(getApplicationContext(),R.string.cannot_be_empty, Toast.LENGTH_SHORT);
        }
        else{
            if(s3.equals(s4)){
                Boolean checkUsername = db.checkUsername(s1);
                if(checkUsername == true){
                    Boolean insert = db.insert(s1,s3);
                    if(insert == true){
                        Toast.makeText(getApplicationContext(),R.string.register_complete,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),R.string.username_is_taken,Toast.LENGTH_SHORT).show();
                }
            }
            Toast.makeText(getApplicationContext(),R.string.wrong_password,Toast.LENGTH_SHORT).show();
        }
    }


}
