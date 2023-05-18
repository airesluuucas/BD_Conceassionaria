package Model;
import java.util.Objects;

public class Marca {
    
    private int id;
    private String nome;
    private String sede;
    private Double valor;
    
    public Marca() {
    }

    public Marca(String nome, String sede, Double valor) {
        this.nome = nome;
        this.sede = sede;
        this.valor = valor;
    }

    public Marca(int id, String nome, String sede, Double valor) {
        this.id = id;
        this.nome = nome;
        this.sede = sede;
        this.valor = valor;
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

    public String getSede() {
        return this.sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Marca id(int id) {
        setId(id);
        return this;
    }

    public Marca nome(String nome) {
        setNome(nome);
        return this;
    }

    public Marca sede(String sede) {
        setSede(sede);
        return this;
    }

    public Marca valor(Double valor) {
        setValor(valor);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Marca)) {
            return false;
        }
        Marca marca = (Marca) o;
        return id == marca.id && Objects.equals(nome, marca.nome) && Objects.equals(sede, marca.sede) && Objects.equals(valor, marca.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sede, valor);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", sede='" + getSede() + "'" +
            ", valor='" + getValor() + "'" +
            "}";
    }

}