package com.example.exercie1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class Register extends AppCompatActivity {

    // Deklarasi variabel dengan tipe data Edit Text dan Button
    EditText edRgUser, edRgEmail, edRgPass, edRgRepass;
    Button btnRgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edRgUser = findViewById(R.id.edtxtNamaRgs);
        edRgEmail = findViewById(R.id.edtxtEmailRgs);
        edRgPass = findViewById(R.id.edtxtPassRgs);
        edRgRepass = findViewById(R.id.edtxtRePassRgs);
        btnRgs = findViewById(R.id.buttonRegister);

        btnRgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}