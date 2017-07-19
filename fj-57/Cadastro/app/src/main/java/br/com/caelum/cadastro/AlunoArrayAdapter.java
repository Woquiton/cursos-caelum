package br.com.caelum.cadastro;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android6999 on 18/07/17.
 */

public class AlunoArrayAdapter extends ArrayAdapter<Aluno> {
    private ArrayList<Aluno> alunos;

    public AlunoArrayAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Aluno> objects) {
        super(context, resource, objects);
        this.alunos = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        Aluno itemAluno = alunos.get(position);

        if (v == null) {
          //  LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           // v = inflater.inflate(R.layout.item_aluno, null);
            v = LayoutInflater.from(getContext()).inflate(R.layout.item_aluno, parent, false);
        }
        TextView txvw_nome = (TextView) v.findViewById(R.id.txvw_nome);
        TextView txvw_nota = (TextView) v.findViewById(R.id.txvw_nota);
        TextView txvw_telefone = (TextView) v.findViewById(R.id.txvw_telefone);

        txvw_nome.setText(itemAluno.getNome());
        txvw_nota.setText(String.valueOf(itemAluno.getNota()));
        txvw_telefone.setText(itemAluno.getTelefone());

        // Aluno itemAluno = alunos.get(position);

       /* if (itemAluno != null) {
            TextView txvw_nome = (TextView) v.findViewById(R.id.txvw_nome);
            TextView txvw_nota = (TextView) v.findViewById(R.id.txvw_nota);
            TextView txvw_telefone = (TextView) v.findViewById(R.id.txvw_telefone);

            txvw_nome.setText(itemAluno.getNome());
            txvw_nota.setText(String.valueOf(itemAluno.getNota()));
            txvw_telefone.setText(itemAluno.getTelefone());
        }*/
        return v;

    }

}
