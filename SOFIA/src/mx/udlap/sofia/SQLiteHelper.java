package mx.udlap.sofia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{
	
	String sqlCreate1 = "CREATE TABLE ejercicios (id_modulo TEXT PRIMARY KEY, ejercicios_totales INTEGER, ejercicios_contestados INTEGER)";
    String sqlCreate2 = "CREATE TABLE teoria (id_modulo TEXT PRIMARY KEY, teoria_vista TEXT)";
    String sqlCreate3 = "CREATE TABLE ejemplos (id_modulo TEXT, ejemplos_total INTEGER, ejemplos_vistos INTEGER)";
	String sqlCreate4 = "CREATE TABLE modulos (id_modulo TEXT, numero_de_clicks INTEGER)";

    
    public SQLiteHelper(Context contexto, String nombreBD,
                               CursorFactory factory, int version) {
        super(contexto, nombreBD, factory, version);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
       
        db.execSQL(sqlCreate1);
        db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);
        db.execSQL(sqlCreate4);
    }
 
   
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        
        db.execSQL("DROP TABLE IF EXISTS ejercicio");
        db.execSQL("DROP TABLE IF EXISTS teoria");
        db.execSQL("DROP TABLE IF EXISTS ejemplos");
        db.execSQL("DROP TABLE IF EXISTS modulos");
        
        db.execSQL(sqlCreate1);
        db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);
        db.execSQL(sqlCreate4);
        
    }

}
