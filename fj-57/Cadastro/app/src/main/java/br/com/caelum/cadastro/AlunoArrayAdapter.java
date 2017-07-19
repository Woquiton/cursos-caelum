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


    ArrayList<Aluno> alunos;

    public AlunoArrayAdapter(Context context, int textViewResourceId, ArrayList<Aluno> objects) {
        super(context, textViewResourceId, objects);
        alunos = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.item_aluno, null);

        TextView txvw_nome = (TextView) v.findViewById(R.id.txvw_nome);
        TextView txvw_nota = (TextView) v.findViewById(R.id.txvw_nota);
        TextView txvw_telefone = (TextView) v.findViewById(R.id.txvw_telefone);

        txvw_nome.setText(alunos.get(position).getNome());
        txvw_nota.setText( String.valueOf(alunos.get(position).getNota()));
        txvw_telefone.setText(alunos.get(position).getTelefone());

        return v;

    }
}
