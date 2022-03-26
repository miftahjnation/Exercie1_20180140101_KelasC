package com.example.exercie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Register extends AppCompatActivity {

    // Deklarasi variabel dengan tipe data Edit Text dan FloatingAction Button
    EditText edRgUser, edRgEmail, edRgPass, edRgRepass;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edRgUser = findViewById(R.id.edtxtNamaRgs);
        edRgEmail = findViewById(R.id.edtxtEmailRgs);
        edRgPass = findViewById(R.id.edtxtPassRgs);
        edRgRepass = findViewById(R.id.edtxtRePassRgs);
        fab = findViewById(R.id.fabTambah);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}