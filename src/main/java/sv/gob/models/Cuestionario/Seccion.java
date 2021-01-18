package sv.gob.models.cuestionario;

import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seccion")
public class Seccion {
	
	@Id
	private String id;
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 ]+$")
	private String codigoSeccion;
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 ]+$")
	private String nombreSeccion;
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 ]+$")
	private String descripcionSeccion;
	private String encuesta;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigoSeccion() {
		return codigoSeccion;
	}
	public void setCodigoSeccion(String codigoSeccion) {
		this.codigoSeccion = codigoSeccion;
	}
	public String getNombreSeccion() {
		return nombreSeccion;
	}
	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}
	public String getDescripcionSeccion() {
		return descripcionSeccion;
	}
	public void setDescripcionSeccion(String descripcionSeccion) {
		this.descripcionSeccion = descripcionSeccion;
	}

	public String getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(String encuesta) {
		this.encuesta = encuesta;
	}

	@Override
	public String toString() {
		return "Seccion [codigoSeccion=" + codigoSeccion + ", descripcionSeccion=" + descripcionSeccion + ", encuesta="
				+ encuesta + ", id=" + id + ", nombreSeccion=" + nombreSeccion + "]";
	}
	

	
	

}
