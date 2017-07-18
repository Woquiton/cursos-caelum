package br.com.caelum.cadastro;

import android.widget.EditText;
import android.widget.RatingBar;

import java.math.BigDecimal;

/**
 * Created by android6999 on 18/07/17.
 */

public class FormAlunoHelper {
    private EditText edtNome;
    private EditText edtTelefone;
    private EditText edtEndereco;
    private EditText edtSite;
    private RatingBar rtBarNota;


    public FormAlunoHelper(FormularioActivity ctx) {
        this.edtNome        = (EditText) ctx.findViewById(R.id.edtNome);
        this.edtTelefone    = (EditText) ctx.findViewById(R.id.edtTelefone);
        this.edtEndereco    = (EditText) ctx.findViewById(R.id.edtEndereco);
        this.edtSite        = (EditText) ctx.findViewById(R.id.edtSite);
        this.rtBarNota      = (RatingBar) ctx.findViewById(R.id.rtBarClassificacao);
    }

    public EditText getEdtNome() {
        return edtNome;
    }

    public void setEdtNome(EditText edtNome) {
        this.edtNome = edtNome;
    }

    public EditText getEdtTelefone() {
        return edtTelefone;
    }

    public void setEdtTelefone(EditText edtTelefone) {
        this.edtTelefone = edtTelefone;
    }

    public EditText getEdtEndereco() {
        return edtEndereco;
    }

    public void setEdtEndereco(EditText edtEndereco) {
        this.edtEndereco = edtEndereco;
    }

    public EditText getEdtSite() {
        return edtSite;
    }

    public void setEdtSite(EditText edtSite) {
        this.edtSite = edtSite;
    }

    public RatingBar getRtBarNota() {
        return rtBarNota;
    }

    public void setRtBarNota(RatingBar rtBarNota) {
        this.rtBarNota = rtBarNota;
    }

    public  Aluno pegaAlunodoForm() {
        Aluno aluno = new Aluno(this.edtNome.toString());

        aluno.setEndereco(this.edtEndereco.toString());
        aluno.setNota(new BigDecimal(this.rtBarNota.getRating()));
        aluno.setSite(this.edtSite.toString());
        aluno.setTelefone(this.edtTelefone.toString());

        return aluno;
    }

    public boolean isInvalido(){
        return edtNome.getText().toString().isEmpty();
    }

    public void exibirErro(FormularioActivity ctx){
        edtNome.setError(ctx.getResources().getString(R.string.msgNomeInvalido));
    }
}
