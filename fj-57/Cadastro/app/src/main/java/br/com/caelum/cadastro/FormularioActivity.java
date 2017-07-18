package br.com.caelum.cadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {
    private FormAlunoHelper formAlunoHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_formulario);

        formAlunoHelper = new FormAlunoHelper(this);


        adicionarEventoSalvareFechar();
    }


    private void adicionarEventoSalvareFechar(){
        Button btnFechar = (Button) findViewById(R.id.btnSalvar);

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
            case R.id.menu_formulario_ok: {
                if (formAlunoHelper.isInvalido()){
                    formAlunoHelper.exibirErro(this);
                }
                else{
                    finish();
                }
                return false;
            }
            default: return super.onOptionsItemSelected(item);
        }

    }

    private boolean salvo(){
        if (formAlunoHelper.isInvalido()){
            //TODO: Criar rotina de persistencia
            return true;
        }
        return false;
    }

}
