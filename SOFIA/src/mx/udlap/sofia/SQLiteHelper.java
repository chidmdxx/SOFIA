package mx.udlap.sofia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{
	
	String sqlCreate1 = "CREATE TABLE ejercicios (id_modulo TEXT PRIMARY KEY, ejercicios_totales INTEGER, ejercicios_contestados INTEGER)";
    String sqlCreate2 = "CREATE TABLE teoria (id_modulo TEXT PRIMARY KEY, teoria_vista TEXT)";
    String sqlCreate3 = "CREATE TABLE ejemplos (id_modulo TEXT PRIMARY KEY, ejemplos_total INTEGER, ejemplos_vistos INTEGER)";
	String sqlCreate4 = "CREATE TABLE modulos (id_modulo TEXT PRIMARY KEY, numero_de_clicks INTEGER)";
	
	String sqlInsert1 = "INSERT INTO modulos VALUES (\'conjuntos\', 0)";
	String sqlInsert2 = "INSERT INTO modulos VALUES (\'triangulos\', 0)";
	String sqlInsert3 = "INSERT INTO modulos VALUES (\'ecuaciones\', 0)";
	
	String sqlInsert4 = "INSERT INTO ejemplos VALUES (\'conjuntos\', 0,0)";
	String sqlInsert5 = "INSERT INTO ejemplos VALUES (\'triangulos\', 0,0)";
	String sqlInsert6 = "INSERT INTO ejemplos VALUES (\'ecuaciones\', 0,0)";
	
	String sqlInsert7 = "INSERT INTO teoria VALUES (\'conjuntos\', \'no\')";
	String sqlInsert8 = "INSERT INTO teoria VALUES (\'triangulos\', \'no\')";
	String sqlInsert9 = "INSERT INTO teoria VALUES (\'ecuaciones\', \'no\')";
	
	String sqlInsert10 = "INSERT INTO ejercicios VALUES (\'conjuntos\', 0,0)";
	String sqlInsert11 = "INSERT INTO ejercicios VALUES (\'triangulos\', 0,0)";
	String sqlInsert12 = "INSERT INTO ejercicios VALUES (\'ecuaciones\',0,0)";
	

    
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
        db.execSQL(sqlInsert1);
        db.execSQL(sqlInsert2);
        db.execSQL(sqlInsert3);
        db.execSQL(sqlInsert4);
        db.execSQL(sqlInsert5);
        db.execSQL(sqlInsert6);
        db.execSQL(sqlInsert7);
        db.execSQL(sqlInsert8);
        db.execSQL(sqlInsert9);
        db.execSQL(sqlInsert10);
        db.execSQL(sqlInsert11);
        db.execSQL(sqlInsert12);
        
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
