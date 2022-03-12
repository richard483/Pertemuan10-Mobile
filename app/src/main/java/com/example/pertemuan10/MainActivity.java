package com.example.pertemuan10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button toMaps_bt;
    Button toActivity2_bt;

    View.OnClickListener toMaps_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
//            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
//
//            try {
//                startActivity(mapIntent);
//            }catch (Exception e){
//                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
//            };
            showToMapsAlertDialog();
        }
    };

    View.OnClickListener toActivity2_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent);
        }
    };

    private void showToMapsAlertDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();//mungkin MainActivity.class di context
        alertDialog.setTitle("Confirmation");
        alertDialog.setMessage("You will ber directed to google maps");
        alertDialog.setCancelable(false);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                try {
                    startActivity(mapIntent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                };
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Ngak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Tidak jadi ke Maps", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    }

    private  void progressDialog(){
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Tunggu sebentar");
        progressDialog.setMessage("Sedang loading...");
        progressDialog.setCancelable(true);

        progressDialog.show();

//        progressDialog.dismiss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toMaps_bt = findViewById(R.id.go_btn);
        toActivity2_bt = findViewById(R.id.activity2_btn);

        toMaps_bt.setOnClickListener(toMaps_listener);
        toActivity2_bt.setOnClickListener(toActivity2_listener);

        progressDialog();

    }

    //untuk menhubungkan xml menu dengan file java
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //untuk memberikan action listener terhadap menu yang dipilih
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.youtube_item:{
                Uri location = Uri.parse("https://www.youtube.com");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                try {
                    startActivity(mapIntent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                };
                break;
            }case R.id.b_item:{
                Toast.makeText(getApplicationContext(), "Pressed menu B", Toast.LENGTH_SHORT).show();
                break;
            } default:{
                Toast.makeText(getApplicationContext(), "Pressed other menu", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}