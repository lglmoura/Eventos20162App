package br.edu.iff.pooa20162.peventos.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lglmoura on 3/13/17.
 */
@Table
public class Local extends SugarRecord  implements Parcelable {

    private Long id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeLong(id);

    }

    public Long getId() {
        return id;
    }

    private Local(Parcel from){

        id = from.readLong();
        endereco = from.readString();
        nome = from.readString();
    }

    public static final Parcelable.Creator<Local>
            CREATOR = new Parcelable.Creator<Local>() {

        public Local createFromParcel(Parcel in) {
            return new Local(in);
        }

        public Local[] newArray(int size) {
            return new Local[size];
        }
    };
}
