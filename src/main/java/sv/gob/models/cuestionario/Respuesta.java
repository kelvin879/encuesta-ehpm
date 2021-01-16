package sv.gob.models.cuestionario;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "respuesta")
public class Respuesta {
    
    @Id
    private String id;
    private String respuesta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Respuesta [id=" + id + ", respuesta=" + respuesta + "]";
    }
    
    
}
