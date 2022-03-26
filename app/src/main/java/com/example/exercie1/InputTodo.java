package com.example.exercie1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class InputTodo extends AppCompatActivity {

    /* Deklarasai TextView pada Input ToDo */
    TextView txUserLgn, txUserRgs;

    //Mendeklarasi variable Edit text dan FloatingActionButton
    EditText edTask,edJTask,edTTask;
    FloatingActionButton fabAdd;

    //Mendeklarasi variable untuk menyimpan data dari edittext pada layout
    String sTask,sJTask,sTTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_todo);

        //Menghubungkan variable text view dengan component TextView pada activity_input_todo
        txUserLgn = findViewById(R.id.lInputLgn);

        //Menghubungkan variable text view dengan component TextView pada activity_input_todo
        txUserRgs = findViewById(R.id.lInputRgs);

        //Mendeklarasikan variable bundle untuk mengambil pesan yang dikirimkan dengan method intent
        Bundle bundle = getIntent().getExtras();

        //Membuat variable untuk menampung data dari activity Sign In
        String userSgn = bundle.getString("user1");

        //Membuat variable untuk menampung data dari activity Register
        String userRgs = bundle.getString("user2");

        //berguna untuk mengubah textview menjadi data yang berasal dari SignIn dan Register
        txUserLgn.setText(userSgn);
        txUserRgs.setText(userRgs);

        //Menghubungkan variable dengan component edittext pada layout
        edTask = findViewById(R.id.edtxtTask);
        edJTask = findViewById(R.id.edtxtJTask);
        edTTask = findViewById(R.id.edtxtTTask);

        //Menghubungkan variable dengan component FloatActionButton pada layout
        fabAdd = findViewById(R.id.fabTambah);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Untuk menyimpan input dari edittext pada halaman Input ToDo
                sTask = edTask.getText().toString();
                sJTask = edJTask.getText().toString();
                sTTask = edTTask.getText().toString();

                if(sTask.isEmpty() && sJTask.isEmpty() && sTTask.isEmpty())
                {
                    //Menampilkan pesan notifikasi jika seluruh EditText kosong
                    Snackbar.make(view, "Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();
                    edTask.setError("Task wajib diisi");
                    edJTask.setError("Jenis task wajib diisi");
                    edTTask.setError("Time task wajib diisi");
                }
                //Statement jika hanya Task yang diisi.
                else if(sJTask.isEmpty() && sTTask.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Silahkan isi Jenis task dan Time task", Toast.LENGTH_LONG).show();
                    edJTask.setError("Jenis task wajib diisi");
                    edTTask.setError("Time task wajib diisi");
                }
                //Statement jika hanya Jenis Task yang diisi.
                else if(sTask.isEmpty() && sTTask.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Silahkan isi Task dan Time task", Toast.LENGTH_LONG).show();
                    edTask.setError("Task wajib diisi");
                    edTTask.setError("Time task wajib diisi");
                }
                //Statement jika hanya Time Task yang diisi.
                else if(sTask.isEmpty() && sJTask.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Silahkan isi Task dan Jenis task", Toast.LENGTH_LONG).show();
                    edTask.setError("Task wajib diisi");
                    edJTask.setError("Jenis task wajib diisi");
                }
                //Statement jika hanya  Task yang kosong.
                else if(sTask.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Silahkan isi Task!", Toast.LENGTH_LONG).show();
                    edTask.setError("Task wajib diisi");
                }
                //Statement jika hanya Jenis Task yang kosong.
                else if(sJTask.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Silahkan isi Jenis task", Toast.LENGTH_LONG).show();
                    edJTask.setError("Jenis task wajib diisi");
                }
                //Statement jika hanya Time Task yang kosong.
                else if(sTTask.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Silahkan isi Time task", Toast.LENGTH_LONG).show();
                    edTTask.setError("Jenis task wajib diisi");
                }
                else
                {
                    //Menampilkan pesan notifikasi jika Data Berhasil diinput
                    Toast.makeText(getApplicationContext(), "Data Berhasil Dimasukkan", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();
                    //key parsing data dimasukkan kedalam bundle
                    b.putString("task", sTask.trim());
                    b.putString("jtask", sJTask.trim());
                    b.putString("ttask", sTTask.trim());

                    //Method untuk berhasil masuk ke Halaman Input Todo
                    Intent iHd = new Intent(getApplicationContext(), HasilToDo.class);
                    //Memasukkan bundle ke dalam target
                    iHd.putExtras(b);
                    //berpindah ke halaman lain
                    startActivity(iHd);
                }
            }
        });








    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_input, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}