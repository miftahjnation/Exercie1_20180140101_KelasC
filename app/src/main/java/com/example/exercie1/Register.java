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

    //Deklarasi variable untuk penyimpan data dari edittext
    String userRgs1,emailRgs,passRgs,rePassRgs;

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
                //Untuk menyimpan input dari edittext pada halaman Register
                userRgs1= edRgUser.getText().toString();
                emailRgs = edRgEmail.getText().toString();
                passRgs = edRgPass.getText().toString();
                rePassRgs = edRgRepass.getText().toString();

                if(userRgs1.isEmpty() && emailRgs.isEmpty() && passRgs.isEmpty() && rePassRgs.isEmpty())
                {
                    //Menampilkan pesan notifikasi jika seluruh EditText kosong
                    Snackbar.make(view, "Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();
                    edRgUser.setError("User wajib diisi");
                    edRgEmail.setError("Email wajib diisi");
                    edRgPass.setError("Password wajib diisi");
                    edRgRepass.setError("Re-password wajib diisi");
                }
                //Statement jika hanya user yang diisi.
                else if(passRgs.isEmpty() && rePassRgs.isEmpty() && emailRgs.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Silahkan isi Email, Password dan Repassword", Toast.LENGTH_LONG).show();
                    edRgEmail.setError("Email wajib diisi");
                    edRgPass.setError("Password wajib diisi");
                    edRgRepass.setError("Re-password wajib diisi");
                }
                //Statement jika hanya email yang diisi.
                else if(userRgs1.isEmpty() && passRgs.isEmpty() && rePassRgs.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Silahkan isi User, Password dan Repassword", Toast.LENGTH_LONG).show();
                    edRgUser.setError("User wajib diisi");
                    edRgPass.setError("Password wajib diisi");
                    edRgRepass.setError("Re-password wajib diisi");
                }
                //Statement jika hanya password yang diisi.
                else if(userRgs1.isEmpty() && rePassRgs.isEmpty() && emailRgs.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Silahkan isi User, Email dan Repassword", Toast.LENGTH_LONG).show();
                    edRgUser.setError("User wajib diisi");
                    edRgEmail.setError("Email wajib diisi");
                    edRgRepass.setError("Re-password wajib diisi");
                }
                //Statement jika hanya repass yang diisi.
                else if(userRgs1.isEmpty() && emailRgs.isEmpty()&& passRgs.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Silahkan isi User, Email dan Password", Toast.LENGTH_LONG).show();
                    edRgUser.setError("User wajib diisi");
                    edRgEmail.setError("Email wajib diisi");
                    edRgPass.setError("Password wajib diisi");
                }
                //Statement jika pass dan repass dikosongkan.
                else if(passRgs.isEmpty() && rePassRgs.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Silahkan isi Password dan Repassword", Toast.LENGTH_LONG).show();
                    edRgPass.setError("Password wajib diisi");
                    edRgRepass.setError("Re-password wajib diisi");
                }
                else
                {
                    //Membuat kondisi untuk mengecek apakah isi dari EditText password dan EditText repassword
                    //sama atau tidak
                    if(passRgs.equals(rePassRgs) && emailRgs.isEmpty() && userRgs1.isEmpty())
                    {
                        //Menampilkan pesan notifikasi jika user dan email kosong
                        Toast.makeText(getApplicationContext(), "Silahkan isi user dan email! jangan dikosongkan.", Toast.LENGTH_LONG).show();
                        edRgUser.setError("User wajib diisi");
                        edRgEmail.setError("Email wajib diisi");
                    }
                    else if(passRgs.equals(rePassRgs) && userRgs1.isEmpty() )
                    {
                        //Menampilkan pesan notifikasi jika user kosong
                        Toast.makeText(getApplicationContext(), "Silahkan isi user! jangan dikosongkan.", Toast.LENGTH_LONG).show();
                        edRgUser.setError("User wajib diisi");
                    }
                    else if(passRgs.equals(rePassRgs) && emailRgs.isEmpty() )
                    {
                        //Menampilkan pesan notifikasi jika email kosong
                        Toast.makeText(getApplicationContext(), "Silahkan isi email! jangan dikosongkan.", Toast.LENGTH_LONG).show();
                        edRgEmail.setError("Email wajib diisi");
                    }
                    else if(passRgs.equals(rePassRgs) )
                    {
                        //Menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...", Toast.LENGTH_LONG).show();

                        Bundle b1 = new Bundle();
                        //key parsing data dimasukkan kedalam bundle
                        b1.putString("user2", userRgs1.trim());

                        //Method untuk berhasil masuk ke Halaman Input Todo
                        Intent iTd = new Intent(getApplicationContext(), InputTodo.class);
                        //Memasukkan bundle ke dalam target
                        iTd.putExtras(b1);
                        //berpindah ke halaman lain
                        startActivity(iTd);
                    }
                    else
                    {
                        //Menampilkan pesan bahwa isi dari EditText password dan EditText repassword
                        //tidak sama
                        Snackbar.make(view, "Password dan Repassword harus sama !!!", Snackbar.LENGTH_LONG).show();
                    }

                }
            }
        });


    }
}