package Model;
import java.util.Objects;

public class MontadoraResponsavel {
    
    private int montadora_id;
    private int responsavel_id;


    public MontadoraResponsavel() {
    }

    public MontadoraResponsavel(int montadora_id, int responsavel_id) {
        this.montadora_id = montadora_id;
        this.responsavel_id = responsavel_id;
    }

    public int getMontadora_id() {
        return this.montadora_id;
    }

    public void setMontadora_id(int montadora_id) {
        this.montadora_id = montadora_id;
    }

    public int getResponsavel_id() {
        return this.responsavel_id;
    }

    public void setResponsavel_id(int responsavel_id) {
        this.responsavel_id = responsavel_id;
    }

    public MontadoraResponsavel montadora_id(int montadora_id) {
        setMontadora_id(montadora_id);
        return this;
    }

    public MontadoraResponsavel responsavel_id(int responsavel_id) {
        setResponsavel_id(responsavel_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MontadoraResponsavel)) {
            return false;
        }
        MontadoraResponsavel montadoraResponsavel = (MontadoraResponsavel) o;
        return montadora_id == montadoraResponsavel.montadora_id && responsavel_id == montadoraResponsavel.responsavel_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(montadora_id, responsavel_id);
    }

    @Override
    public String toString() {
        return "{" +
            " montadora_id ='" + getMontadora_id() + "'" +
            ", responsavel_id ='" + getResponsavel_id() + "'" +
            "}";
    }
    
}
