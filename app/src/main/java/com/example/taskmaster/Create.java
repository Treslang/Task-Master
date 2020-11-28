package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create extends AppCompatActivity {

    EditText username, password, reenter;
    Button btnCreate1;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        reenter = (EditText) findViewById(R.id.reenter);
        btnCreate1 = (Button) findViewById(R.id.btnCreate1);
        DB = new DBHelper(this);

        btnCreate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String rep = reenter.getText().toString();

                if(user.equals("")||pass.equals("")||rep.equals(""))
                    Toast.makeText(Create.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(rep)){
                        Boolean checkUser = DB.checkUsername(user);
                        if(checkUser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(Create.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Create.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Create.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Create.this, "Password did not matched!", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

    }
}