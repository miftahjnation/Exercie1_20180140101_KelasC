package com.example.exercie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        //Membuat variable untuk menampung data dari activity Sign In
        String userRgs = bundle.getString("user2");

        //berguna untuk mengubah textview menjadi data yang berasal dari SignIn dan Register
        txUserLgn.setText(userSgn);
        txUserRgs.setText(userRgs);






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_input, menu);
        return super.onCreateOptionsMenu(menu);

    }
}