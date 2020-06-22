package com.example.appdoctruyen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtName;
    private EditText edtPass;
    private TextView txtForget;
    private TextView txtRegis;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtName = (EditText) findViewById(R.id.edtUsername);
        edtPass = (EditText) findViewById(R.id.edtPassword);
        txtForget = (TextView) findViewById(R.id.txtForgetPass);
        txtRegis = (TextView) findViewById(R.id.txtDangKy);
        txtRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = edtName.getText().toString();
                String s2 = edtPass.getText().toString();
                if(emailPassword(s1,s2)== true)
                {
                    int idAcc = getIDAcc(s1,s2);
                    Intent intent = new Intent(LoginActivity.this,BottomNavigationActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("IDAcc",idAcc);
                    intent.putExtra("IDAcc1",bundle);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(),"Email hoac mac khau ko dung !",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public int getIDAcc(String email,String pass)
    {
        database = Database.initDatabase(this,"dbAppRead.db");
        Cursor cursor = database.rawQuery("SELECT * FROM Account WHERE Email = ? and Pass = ?",new String[]{email,pass});
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        return id;
    }
    public Boolean emailPassword(String email,String pass)
    {
        database = Database.initDatabase(this,"dbAppRead.db");
        Cursor cursor = database.rawQuery("SELECT * FROM Account WHERE Email = ? and Pass = ?",new String[]{email,pass});
        if(cursor.getCount()>0) return true;
        else return false;
    }

}
