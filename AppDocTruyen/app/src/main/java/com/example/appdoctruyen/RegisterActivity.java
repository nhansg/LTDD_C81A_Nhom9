package com.example.appdoctruyen;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    final String DATABASE_NAME = "dbAppRead.db";
    SQLiteDatabase database;
    ArrayList<Account> list;

    private Button btnRegis;
    private EditText edtName;
    private EditText edtPass;
    private EditText edtRePass;
    private EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = Database.initDatabase(this,DATABASE_NAME);
        setContentView(R.layout.activity_register);
        btnRegis = (Button) findViewById(R.id.btnRegis);
        edtName = (EditText) findViewById(R.id.edtNameRegis);
        edtPass = (EditText) findViewById(R.id.edtPasswordRegis);
        edtRePass = (EditText) findViewById(R.id.edtRePasswordRegis);
        edtEmail = (EditText) findViewById(R.id.edtEmailRegis);
        database = Database.initDatabase(this,DATABASE_NAME);
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = edtName.getText().toString();
                String s2 = edtPass.getText().toString();
                String s3 = edtRePass.getText().toString();
                String s4 = edtEmail.getText().toString();
                if(s1.equals("") || s2.equals("")|| s3.equals("")|| s4.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fields are empty !!",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(s2.equals(s3)) {
                        Boolean chk = chkEmail(s4);
                        if (chk==true){
                            insert(s4,s1,s2);
                            if (insert(s4,s1,s2)== true){
                                Toast.makeText(getApplicationContext(),"Register Successful !!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this,BottomNavigationActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Email da ton tai !!",Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(),"Mat khau khong trung !!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean insert(String email,String name,String pass)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email",email);
        contentValues.put("Pass",pass);
        contentValues.put("Name",name);
        long ins = database.insert("Account",null,contentValues);
        if(ins == -1) return false;
        else return true;
    }
    public Boolean chkEmail(String email)
    {
        Cursor cursor = database.rawQuery("SELECT * FROM Account WHERE Email = ?",new String[]{email});
        if (cursor.getCount()>0) return false;
        else return true;
    }
}
