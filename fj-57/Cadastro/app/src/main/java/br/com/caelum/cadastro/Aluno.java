package br.com.caelum.cadastro;

import java.util.UUID;

/**
 * Created by android6999 on 17/07/17.
 */

public class Aluno {


    public Aluno(String nome) {

        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;



}
