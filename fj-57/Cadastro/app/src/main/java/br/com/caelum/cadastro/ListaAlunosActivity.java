package br.com.caelum.cadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String [] alunos = DataClass.geradordeAlunosAsString();
        this.listaAlunos = (ListView)findViewById(R.id.lvw_lista_alunos);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, alunos);

        listaAlunos.setAdapter(adapter);
        //atribuirEventodeListaSimples();
        atribuirEventodeListaLongo();
    }

    private void atribuirEventodeListaSimples(){
        if (listaAlunos != null){
            listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                    Toast.makeText(view.getContext(), "Posicao selecionada: " + posicao, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    private void atribuirEventodeListaLongo(){
        if (listaAlunos != null){
            listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                    Toast.makeText(view.getContext(), "Posicao selecionada: " + posicao, Toast.LENGTH_LONG).show();
                    return false;
                }
            });
        }
    }
}
