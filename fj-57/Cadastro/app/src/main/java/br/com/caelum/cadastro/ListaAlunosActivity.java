package br.com.caelum.cadastro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        loadLista();
        registerForContextMenu(listaAlunos);


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

    private void adicionarEventoparaAbrirFormulariodeAdicao(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_adicionar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(view.getContext(), FormularioActivity.class);
                startActivity(it);
            }
        });
    }

    private void loadLista(){
        this.listaAlunos = (ListView)findViewById(R.id.lvw_lista_alunos);
        AlunoDAO alunoDAO = new AlunoDAO(this);
        ArrayList<Aluno>alunos = alunoDAO.buscarTodos();

        AlunoArrayAdapter adapter = new AlunoArrayAdapter(this, R.layout.item_aluno, alunos);

        listaAlunos.setAdapter(adapter);
        alunoDAO.liberarRecursos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLista();
        //this.listaAlunos = (ListView)findViewById(R.id.lvw_lista_alunos);
        //AlunoDAO alunoDAO = new AlunoDAO(this);
        //ArrayList<Aluno>alunos = alunoDAO.buscarTodos();

        //AlunoArrayAdapter adapter = new AlunoArrayAdapter(this, R.layout.item_aluno, alunos);

        //listaAlunos.setAdapter(adapter);
        //alunoDAO.liberarRecursos();

        // listaAlunos.setAdapter(adapter);
       // atribuirEventodeListaSimples();
      //  atribuirEventodeListaLongo();
        adicionarEventoparaAbrirFormulariodeAdicao();

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, final View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Aluno alunoSelecionado = (Aluno) this.listaAlunos.getAdapter().getItem(info.position);
        menu.add("Ligar");

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                new AlertDialog.Builder(v.getContext())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Deletar")
                        .setMessage("Confirma Exclusão")
                        .setPositiveButton("Sim",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        AlunoDAO dao  = new AlunoDAO(v.getContext());
                                        dao.deletar(alunoSelecionado);
                                        dao.liberarRecursos();
                                        carregarLista();
                                    }
                                }).setNegativeButton("Não", null).show();
                return false;
            }
        });

    }

    private void carregarLista() {
        Toast.makeText(this, "disiieiwiei", Toast.LENGTH_SHORT).show();
    }
}
