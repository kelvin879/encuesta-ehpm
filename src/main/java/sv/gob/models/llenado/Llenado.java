package sv.gob.models.llenado;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.springframework.data.mongodb.core.mapping.Document;

import sv.gob.models.cuestionario.Pregunta;
import sv.gob.models.encuesta.Encuesta;

@Document(collection = "llenado")
public class Llenado {
    @Id
    private String id;
    private String muestral;
    private String domicilio;
    @JoinColumn(name = "idEncuesta")
    private Encuesta encuesta;
    private List<Pregunta> pregunta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMuestral() {
        return muestral;
    }

    public void setMuestral(String muestral) {
        this.muestral = muestral;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

 

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }



    public List<Pregunta> getPregunta() {
        return pregunta;
    }

    public void setPregunta(List<Pregunta> pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "Llenado [domicilio=" + domicilio + ", encuesta=" + encuesta + ", id=" + id + ", muestral=" + muestral
                + ", pregunta=" + pregunta + "]";
    }

    
 
    
}
