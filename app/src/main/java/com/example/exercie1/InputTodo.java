package com.example.exercie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class InputTodo extends AppCompatActivity {

    /* Deklarasai TextView pada Input ToDo */
    TextView txUserLgn, txUserRgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_todo);

        //Menghubungkan variable text view dengan component TextView pada activity_input_todo
        txUserLgn = findViewById(R.id.lInputRoL);

        //Mendeklarasikan variable bundle untuk mengambil pesan yang dikirimkan dengan method intent
        Bundle bundle = getIntent().getExtras();

        //Membuat variable untuk menampung data dari activity Sign In
        String userSgn = bundle.getString("user1");

        txUserLgn.setText(userSgn);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_input, menu);
        return super.onCreateOptionsMenu(menu);

    }
}