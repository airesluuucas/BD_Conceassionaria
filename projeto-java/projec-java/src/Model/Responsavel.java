package Model;
import java.util.Objects;

public class Responsavel {

    private int id;
    private String nome;
    private int passe;


    public Responsavel() {
    }

    public Responsavel( String nome, int passe) {
        this.nome = nome;
        this.passe = passe;
    }
    public Responsavel(int id, String nome, int passe) {
        this.id = id;
        this.nome = nome;
        this.passe = passe;
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

    public int getPasse() {
        return this.passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public Responsavel id(int id) {
        setId(id);
        return this;
    }

    public Responsavel nome(String nome) {
        setNome(nome);
        return this;
    }

    public Responsavel passe(int passe) {
        setPasse(passe);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Responsavel)) {
            return false;
        }
        Responsavel responsavel = (Responsavel) o;
        return id == responsavel.id && Objects.equals(nome, responsavel.nome) && passe == responsavel.passe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, passe);
    }

    @Override
    public String toString() {
        return "{" +
            " id ='" + getId() + "'" +
            ", nome ='" + getNome() + "'" +
            ", passe ='" + getPasse() + "'" +
            "}";
    }
    

    
}
/*
 * 
 *    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    passe INT UNSIGNED NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY(PASSE)
 * 
 * 
 */