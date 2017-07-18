package br.com.caelum.cadastro;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by android6999 on 18/07/17.
 */

class AlunoDAO  extends SQLiteOpenHelper{

    private final static int VERSAO = 1;
    public static final String BANCO_DADOS = "ALUNO_DB";


    public AlunoDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AlunoDAO( Context ctx){
        super(ctx, BANCO_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL =  " CREATE TABLE ALUNOS (" +
                "  ID INTEGER NOT NULL PRIMARY KEY," +
                "  NOME TEXT NOT NULL," +
                "  TELEFONE TEXT(12)," +
                "  ENDERECO TEXT (120)," +
                "  SITE TEXT (80)," +
                "  NOTA REAL)";

        sqLiteDatabase.execSQL(SQL);
    }

    public void salvar(Aluno aluno){
        SQLiteDatabase db =  getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("NOME", aluno.getNome());
        valores.put("TELEFONE", aluno.getTelefone());
        valores.put("ENDERECO", aluno.getEndereco());
        valores.put("SITE", aluno.getSite());
        valores.put("NOTA", aluno.getNota());

        db.insert("ALUNOS", null, valores);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAtiga, int versaoAtual) {
        switch (versaoAtiga){
            case  1: onCreate(sqLiteDatabase);
        }

    }

    public void liberarRecursos(){
        close();
    }

    public ArrayList<Aluno>buscarTodos(){
        return DataClass.geradordeAlunos();
    }
}
