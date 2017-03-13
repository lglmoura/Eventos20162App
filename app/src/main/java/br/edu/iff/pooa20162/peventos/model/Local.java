package br.edu.iff.pooa20162.peventos.model;

import com.orm.SugarRecord;

/**
 * Created by lglmoura on 3/13/17.
 */

public class Local extends SugarRecord {

    private String nome;
    private String endereco;

    public Local(){

    }

    public Local(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
