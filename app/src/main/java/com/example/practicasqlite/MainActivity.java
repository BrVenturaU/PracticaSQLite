package com.example.practicasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.practicasqlite.DataContext.ContextDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContextDbHelper contextDbHelper = new ContextDbHelper(this, "RegistroAcademico", null, 1);
        String dbName = contextDbHelper.getDatabaseName();
        Toast.makeText(this, dbName, Toast.LENGTH_SHORT).show();
    }
}