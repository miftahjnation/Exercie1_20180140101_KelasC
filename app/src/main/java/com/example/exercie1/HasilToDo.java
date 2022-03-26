package com.example.exercie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HasilToDo extends AppCompatActivity {

    /* Deklarasai TextView pada Hasil ToDo*/
    TextView txTask, txJTask, txTTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_to_do);

        //Menghubungkan setiap variable dengan component yang sudah ditentukan pada layout acitivty_hasil_to_do.xml
        txTask = findViewById(R.id.tvHslEdTask);
        txJTask = findViewById(R.id.tvJHslEdTask);
        txTTask = findViewById(R.id.tvTHslEdTask);

        //Membuat objek bundle dan mengambil data yang dikirimkan dari activity InputTodo
        Bundle bundle = getIntent().getExtras();



    }
}