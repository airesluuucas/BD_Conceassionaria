package Model;
import java.util.Objects;

public class Cidade {
    
    private int id;
    private String nome; 
    private int estado_id;


    public Cidade() {
    }

    public Cidade(String nome, int estado_id){

        this.nome = nome;
        this.estado_id = estado_id;
    }
    public Cidade(int id, String nome, int estado_id) {
        this.id = id;
        this.nome = nome;
        this.estado_id = estado_id;
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

    public int getEstado_id() {
        return this.estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public Cidade id(int id) {
        setId(id);
        return this;
    }

    public Cidade nome(String nome) {
        setNome(nome);
        return this;
    }

    public Cidade estado_id(int estado_id) {
        setEstado_id(estado_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cidade)) {
            return false;
        }
        Cidade cidadeDAO = (Cidade) o;
        return id == cidadeDAO.id && Objects.equals(nome, cidadeDAO.nome) && estado_id == cidadeDAO.estado_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, estado_id);
    }

    @Override
    public String toString() {
        return "{" +
            " id ='" + getId() + "'" +
            ", nome ='" + getNome() + "'" +
            ", estado_id ='" + getEstado_id() + "'" +
            "}";
    }
    
}
