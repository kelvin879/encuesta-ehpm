package sv.gob.models.cuestionario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "pregunta")
public class Pregunta {
    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private String tipo;
    private List<Respuesta> respuesta;
    private String seccion;
    //private Set<Respuesta> respuesta = new HashSet<>();
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Respuesta> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<Respuesta> respuesta) {
        this.respuesta = respuesta;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "Pregunta [descripcion=" + descripcion + ", id=" + id + ", respuesta=" + respuesta + ", seccion="
                + seccion + ", tipo=" + tipo + ", titulo=" + titulo + "]";
    }
    

}
