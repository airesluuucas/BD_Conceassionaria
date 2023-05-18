package Model;
import java.util.Objects;

public class Montadora {
    private int id;
    private String nome;
    private int cidade_id;


    public Montadora() {
    }

    public Montadora(String nome, int cidade_id) {
        this.nome = nome;
        this.cidade_id = cidade_id;
    }
    public Montadora(int id, String nome, int cidade_id) {
        this.id = id;
        this.nome = nome;
        this.cidade_id = cidade_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCidade_id() {
        return this.cidade_id;
    }

    public void setCidade_id(int cidade_id) {
        this.cidade_id = cidade_id;
    }

    public Montadora id(int id) {
        setId(id);
        return this;
    }

    public Montadora nome(String nome) {
        setNome(nome);
        return this;
    }

    public Montadora cidade_id(int cidade_id) {
        setCidade_id(cidade_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Montadora)) {
            return false;
        }
        Montadora montadora = (Montadora) o;
        return id == montadora.id && Objects.equals(nome, montadora.nome) && cidade_id == montadora.cidade_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cidade_id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", cidade_id='" + getCidade_id() + "'" +
            "}";
    }
    

}
