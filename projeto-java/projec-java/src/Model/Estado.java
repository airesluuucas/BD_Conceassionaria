package Model;
import java.util.Objects;

public class Estado {
    
    private int id;
    private String nome;
    private String sigla;
    private String regiao;
    private Double populacao;


    public Estado() {
    }

    public Estado(int id, String nome, String sigla, String regiao, Double populacao) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.regiao = regiao;
        this.populacao = populacao;
    }
    public Estado( String nome, String sigla, String regiao, Double populacao) {
        this.nome = nome;
        this.sigla = sigla;
        this.regiao = regiao;
        this.populacao = populacao;
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

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getRegiao() {
        return this.regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Double getPopulacao() {
        return this.populacao;
    }

    public void setPopulacao(Double populacao) {
        this.populacao = populacao;
    }

    public Estado id(int id) {
        setId(id);
        return this;
    }

    public Estado nome(String nome) {
        setNome(nome);
        return this;
    }

    public Estado sigla(String sigla) {
        setSigla(sigla);
        return this;
    }

    public Estado regiao(String regiao) {
        setRegiao(regiao);
        return this;
    }

    public Estado populacao(Double populacao) {
        setPopulacao(populacao);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estado)) {
            return false;
        }
        Estado estado = (Estado) o;
        return id == estado.id && Objects.equals(nome, estado.nome) && Objects.equals(sigla, estado.sigla) && Objects.equals(regiao, estado.regiao) && Objects.equals(populacao, estado.populacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sigla, regiao, populacao);
    }

    @Override
    public String toString() {
        return 
            " Id ='" + getId() + "'" +
            ", Estado ='" + getNome() + "'" +
            ", Sigla ='" + getSigla() + "'" +
            ", Região ='" + getRegiao() + "'" +
            ", População ='" + getPopulacao() + "'";
    }
    
}