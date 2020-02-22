package com.example.goodreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class regisAc extends AppCompatActivity {
    Button submit,cancel;
    EditText username,name,school,age,birth;
    String User,Name,School,Age,Birth;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        username = (EditText) findViewById(R.id.Username);
        name = (EditText) findViewById(R.id.nameAnser);
        school =(EditText) findViewById(R.id.schoolname);
        age = (EditText) findViewById(R.id.intage);
        birth = (EditText) findViewById(R.id.birthday);
        submit = (Button) findViewById(R.id.submit);
        cancel = (Button) findViewById(R.id.cancel);
        db = new DbHelper(this);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin = new Intent(regisAc.this,Login.class);
                startActivity(toLogin);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User = username.getText().toString();
                Name = name.getText().toString();
                School = name.getText().toString();
                Age = age.getText().toString();
                Birth = birth.getText().toString();
                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
                todoListDAO.open();
                boolean inseart = todoListDAO.insertDataUser(User,Name,School,Age,Birth,0,0);
                if (!User.equals("") && !Name.equals("") && !School.equals("") && !Age.equals("") && !Birth.equals("") && inseart) {
                    Toast.makeText(regisAc.this,"Data added",Toast.LENGTH_SHORT).show();
                    Intent toLogin = new Intent(regisAc.this,Login.class);
                    startActivity(toLogin);
                }
                else {
                    Toast.makeText(regisAc.this, "Pleas Enter your Data", Toast.LENGTH_SHORT).show();
                }
                todoListDAO.close();
//                if(!Name.equals("") && db.insertData(Name)){
//                    Toast.makeText(regisAc.this,"Username added",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast errorToast = Toast.makeText(regisAc.this, "Pleas Enter your Name and surname", Toast.LENGTH_LONG);
//                    errorToast.setGravity(Gravity.CENTER_VERTICAL,0,0);
//                    errorToast.show();
//                }
//                if (School.trim().equalsIgnoreCase("")){
//                    Toast errorToast = Toast.makeText(regisAc.this, "Pleas Enter your School", Toast.LENGTH_LONG);
//                    errorToast.setGravity(Gravity.CENTER_VERTICAL,0,0);
//                    errorToast.show();
//                }
//                if (Age.trim().equalsIgnoreCase("")){
//                    Toast errorToast = Toast.makeText(regisAc.this, "Pleas Enter your Age", Toast.LENGTH_LONG);
//                    errorToast.setGravity(Gravity.CENTER_VERTICAL,0,0);
//                    errorToast.show();
//                }
//                if (Birth.trim().equalsIgnoreCase("")){
//                    Toast errorToast = Toast.makeText(regisAc.this, "Pleas Enter your Birthday", Toast.LENGTH_LONG);
//                    errorToast.setGravity(Gravity.CENTER_VERTICAL,0,0);
//                    errorToast.show();
//                }


            }
        });
    }
}
