package br.com.caelum.cadastro;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by android6999 on 17/07/17.
 */

public class DataClass {

    public static String[] geradordeAlunosAsString(){
        String []alunos = new String[5];

        alunos[0]=   "Ana";
        alunos[1]=   "Jõao";
        alunos[2]=   "Márcio";
        alunos[3]=   "Fábio";
        alunos[4]=   "Joana";

        return alunos;
    }

    public static ArrayList<Aluno>geradordeAlunos(){
        ArrayList<Aluno>alunos = new ArrayList<>();
        alunos.add(criarAluno1("Ana"));
        alunos.add(criarAluno2("Jõao"));
        alunos.add(criarAluno3("Márcio"));
        alunos.add(criarAluno4("Fábio"));
        alunos.add(criarAluno5("Joana"));

        return alunos;
    }

    private static Aluno criarAluno1(String nome){
        Aluno aluno = new Aluno(nome);
        aluno.setEndereco("Qd. 01");
        aluno.setTelefone("(11) 3359-7000");
        aluno.setSite("www.one.com.br");
        aluno.setNota(3.5);

        return aluno;
    }

    private static Aluno criarAluno2(String nome){
        Aluno aluno = new Aluno(nome);
        aluno.setEndereco("Qd. 02");
        aluno.setTelefone("(11) 3359-7001");
        aluno.setSite("www.two.com.br");
        aluno.setNota(2.0);

        return aluno;
    }

    private static Aluno criarAluno3(String nome){
        Aluno aluno = new Aluno(nome);
        aluno.setEndereco("Qd. 03");
        aluno.setTelefone("(11) 3359-7002");
        aluno.setSite("www.three.com.br");
        aluno.setNota(3.3);

        return aluno;
    }

    private static Aluno criarAluno4(String nome){
        Aluno aluno = new Aluno(nome);
        aluno.setEndereco("Qd. 04");
        aluno.setTelefone("(11) 3359-7004");
        aluno.setSite("www.four.com.br");
        aluno.setNota(4.5);

        return aluno;
    }

    private static Aluno criarAluno5(String nome){
        Aluno aluno = new Aluno(nome);
        aluno.setEndereco("Qd. 05");
        aluno.setTelefone("(11) 3359-7005");
        aluno.setSite("www.five.com.br");
        aluno.setNota(2.5);

        return aluno;
    }
}
