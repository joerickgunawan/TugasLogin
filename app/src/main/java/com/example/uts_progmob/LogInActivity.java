package com.example.uts_progmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        SharedPreferences prefs = LogInActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);
        String statusLogin = prefs.getString("isLiogin", null);
        EditText roleLogin = (EditText) findViewById(R.id.emailText);
        String strValue = roleLogin.getText().toString();
        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(myBtnLoginClick);

        if (statusLogin == "Admin"){
            Intent intent = new Intent(LogInActivity.this, DataAdminActivity.class);
            startActivity(intent);
        } else if (statusLogin == "User"){
            Intent intent = new Intent(LogInActivity.this, DataDiriMahasiswaActivity.class);
            startActivity(intent);
        } else if(statusLogin == null){
            Toast.makeText(LogInActivity.this, "Tidak Dapat Login", Toast.LENGTH_SHORT).show();
        }
    }

    public void GoToMenudm(View view) {
        Intent intent = new Intent(LogInActivity.this, DataAdminActivity.class);
        startActivity(intent);
    }

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = LogInActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);
            String statusLogin = prefs.getString("isLogin", null);
            SharedPreferences.Editor editor = prefs.edit();

            Button btnSignIn = (Button) findViewById(R.id.btnSignIn);
            if (statusLogin == null){
                editor.putString("isLogin", "Admin");
                Intent intent = new Intent(LogInActivity.this, DataAdminActivity.class);
                startActivity(intent);
            }else if (statusLogin == null){
                editor.putString("isLogin", "User");
                Intent intent = new Intent(LogInActivity.this, DataDiriMahasiswaActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(LogInActivity.this, "belum", Toast.LENGTH_SHORT).show();
            }
            editor.commit();
        }
    };
}
