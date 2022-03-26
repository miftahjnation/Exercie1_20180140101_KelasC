package com.example.exercie1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi TextView
    TextView clkRegister;

    //Deklarasi EditText
    EditText eduser,edpass;

    //Deklarasi Button
    Button btnSignIn;

    //Deklarasi variable untuk penyimpan data dari edittext
    String user, pass;

    String usernm = "Miftah";
    String passlg = "6666";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Menghubungkan setiap variable yang dibuat dengan component pada layout main_activity
        clkRegister = findViewById(R.id.lRegisterSgIn);
        btnSignIn = findViewById(R.id.buttonSignIn);
        eduser = findViewById(R.id.edtxtNamaLgn);
        edpass = findViewById(R.id.edtxtPassLgn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Untuk menyimpan input dari edittext user dan pass dari halaman Sign In
                user = eduser.getText().toString();
                pass = edpass.getText().toString();

                if(user.equals(usernm) && pass.equals(passlg)){
                    Bundle b = new Bundle();
                    //key parsing data dimasukkan kedalam bundle
                    b.putString("user1", user.trim());
                    b.putString("pass1", pass.trim());

                    //Membuat objek untuk pindah halaman
                    Intent i = new Intent(getApplicationContext(), InputTodo.class);
                    //Memasukkan bundle ke dalam target
                    i.putExtras(b);
                    //berpindah ke halaman lain
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Login berhasil!!", Toast.LENGTH_LONG).show();

                    //menghapus isi dari edittext
                    eduser.getText().clear();
                    edpass.getText().clear();
                }else if(user.isEmpty() && pass.isEmpty()) {
                    eduser.requestFocus();
                    eduser.setError("User diperlukan");
                    edpass.requestFocus();
                    edpass.setError("Password diperlukan");
                }else if(user.isEmpty()) {
                    eduser.requestFocus();
                    eduser.setError("User diperlukan");
                }else if(pass.isEmpty()) {
                    edpass.requestFocus();
                    edpass.setError("Password diperlukan");
                }else if(user.equals(usernm) && !pass.matches(passlg)){
                    Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_LONG).show();
                }else if(!user.matches(usernm) && pass.equals(passlg)) {
                    Toast.makeText(getApplicationContext(), "Email Salah", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "User dan Password salah", Toast.LENGTH_LONG).show();
                }


            }
        });


        clkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iSgn = new Intent(getApplicationContext(), Register.class);
                startActivity(iSgn);
            }
        });



    }
}

