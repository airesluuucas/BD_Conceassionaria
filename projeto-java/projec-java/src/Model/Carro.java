package Model;
import java.util.Objects;

public class Carro {
    
    private int id;
    private String modelo;
    private String cor;
    private Double valor;
    private int ano;
    private int montadora_id;
    private int marca_id;


    public Carro() {
    }

    public Carro(String modelo, String cor, Double valor, int ano, int montadora_id, int marca_id) {
        this.modelo = modelo;
        this.cor = cor;
        this.valor = valor;
        this.ano = ano;
        this.montadora_id = montadora_id;
        this.marca_id = marca_id;
    }
    
    public Carro(int id, String modelo, String cor, Double valor, int ano, int montadora_id, int marca_id) {
        this.id = id;
        this.modelo = modelo;
        this.cor = cor;
        this.valor = valor;
        this.ano = ano;
        this.montadora_id = montadora_id;
        this.marca_id = marca_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMontadora_id() {
        return this.montadora_id;
    }

    public void setMontadora_id(int montadora_id) {
        this.montadora_id = montadora_id;
    }

    public int getMarca_id() {
        return this.marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

    public Carro id(int id) {
        setId(id);
        return this;
    }

    public Carro modelo(String modelo) {
        setModelo(modelo);
        return this;
    }

    public Carro cor(String cor) {
        setCor(cor);
        return this;
    }

    public Carro valor(Double valor) {
        setValor(valor);
        return this;
    }

    public Carro ano(int ano) {
        setAno(ano);
        return this;
    }

    public Carro montadora_id(int montadora_id) {
        setMontadora_id(montadora_id);
        return this;
    }

    public Carro marca_id(int marca_id) {
        setMarca_id(marca_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Carro)) {
            return false;
        }
        Carro carro = (Carro) o;
        return id == carro.id && Objects.equals(modelo, carro.modelo) && Objects.equals(cor, carro.cor) && Objects.equals(valor, carro.valor) && ano == carro.ano && montadora_id == carro.montadora_id && marca_id == carro.marca_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, cor, valor, ano, montadora_id, marca_id);
    }

    @Override
    public String toString() {
        return "{" +
            " id ='" + getId() + "'" +
            ", modelo ='" + getModelo() + "'" +
            ", cor ='" + getCor() + "'" +
            ", valor ='" + getValor() + "'" +
            ", ano ='" + getAno() + "'" +
            ", montadora_id ='" + getMontadora_id() + "'" +
            ", marca_id ='" + getMarca_id() + "'" +
            "}";
    }
    
}
