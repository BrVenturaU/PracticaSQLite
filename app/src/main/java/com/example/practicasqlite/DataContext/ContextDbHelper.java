package com.example.practicasqlite.DataContext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContextDbHelper extends SQLiteOpenHelper {
    public ContextDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tbAlumno = "CREATE TABLE Alumno(codigo VARCHAR(10) PRIMARY KEY, " +
                "nombre VARCHAR(100), edad INTEGER, direccion VARCHAR(250))";

        String tbInscipcion = "CREATE TABLE Inscripcion(codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "codigoAlumno VARCHAR(10), fechaInscripcion VARCHAR(50), materia VARCHAR(50)," +
                " ciclo VARCHAR(2), anio VARCHAR(4))";

        sqLiteDatabase.execSQL(tbAlumno);
        sqLiteDatabase.execSQL(tbInscipcion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Alumno");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Inscripcion");
            onCreate(sqLiteDatabase);

        }
    }
}
