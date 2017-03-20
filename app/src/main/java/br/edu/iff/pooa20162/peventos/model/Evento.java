package br.edu.iff.pooa20162.peventos.model;

import com.orm.SugarRecord;

/**
 * Created by aluno on 06/03/17.
 */

public class Evento extends SugarRecord {

    private String nome;
    private Local local;

    private String data;
    private int capacidade;


    public Evento(String nome, Local local,  String data, int capacidade) {
        this.nome = nome;
        this.local = local;

        this.data = data;
        this.capacidade = capacidade;
    }

    public Evento(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
