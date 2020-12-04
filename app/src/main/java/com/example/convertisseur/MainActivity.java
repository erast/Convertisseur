package com.example.convertisseur;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    EditText editText;
    private TextView textout = (TextView) findViewById(R.id.textview);
    private AlertDialog.Builder alert;



    public void convert(View view) {
        Double meter;
        Double kilometer;

        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edittext);

        meter = Double.parseDouble(editText.getText().toString());
        kilometer = meter * 0.001;

        textout.setText(Double.toString(kilometer));


        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public void QuitApp (View view) {
        alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("hello");
        alert.setMessage("Do you want to quit the application?");
        alert.setCancelable(false);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();

            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog=alert.create();
        dialog.show();



//        Toast.makeText(MainActivity.this, String.format("%.2f",kilometer) + " km", Toast.LENGTH_LONG).show();
    }


}