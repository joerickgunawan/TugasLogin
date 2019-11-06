package com.example.uts_progmob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DataAdminActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logout,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.logoutBtn : /*Intent logoutIntent = new Intent(MenuAdmin.this, LoginScreen.class);
            startActivity(logoutIntent);*/
                AlertDialog.Builder builder = new AlertDialog.Builder(DataAdminActivity.this);
                builder.setMessage("Apakah anda ingin Logout?").setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(DataAdminActivity.this, "Tidak jadi LogOut", Toast.LENGTH_SHORT).show();
                    }
                })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                Toast.makeText(DataAdminActivity.this, "Berhasil LogOut", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(DataAdminActivity.this, LogInActivity.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_admin);
    }

    public void GoToCRUDKRS(View view) {
        Intent intent = new Intent(DataAdminActivity.this,InsertUpdateDataKRSActivity.class);
        startActivity(intent);
    }
}
