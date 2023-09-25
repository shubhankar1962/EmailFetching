 package com.example.emailfetching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        b1=findViewById(R.id.b1);
    }

    public void emailProcessing(View view) {
        String to = e1.getText().toString();
        String sub = e2.getText().toString();
        String msg = e3.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT,sub);
        email.putExtra(Intent.EXTRA_TEXT,msg);

        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email,"send email"));
    }

}