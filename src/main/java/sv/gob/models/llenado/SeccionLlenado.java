package sv.gob.models.llenado;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import sv.gob.models.cuestionario.Pregunta;
@Document("seccionLlenado")
public class SeccionLlenado {
    @Id
    private String id;
    private List <Pregunta> pregunta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Pregunta> getPregunta() {
        return pregunta;
    }

    public void setPregunta(List<Pregunta> pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "SeccionLlena [id=" + id + ", pregunta=" + pregunta + "]";
    }

    
    
}
