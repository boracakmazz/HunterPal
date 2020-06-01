package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        editText = findViewById(R.id.user_input_text);
    }

    public void onSendEmailClick(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String[] array = {"asdbfgsd@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,array);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Example Subject");
        String message = editText.getText().toString();
        intent.putExtra(Intent.EXTRA_TEXT,message);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
