package br.edu.iff.pooa20162.peventos.model;

import com.orm.SugarRecord;

/**
 * Created by aluno on 06/03/17.
 */

public class Evento extends SugarRecord {

    private String nome;
    private String local;
    private String endereco;
    private String data;
    private int capacidade;


    public Evento(String nome, String local, String endereco, String data, int capacidade) {
        this.nome = nome;
        this.local = local;
        this.endereco = endereco;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
