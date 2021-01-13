package sv.gob.models.miembros;

import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "miembros")
public class Miembros {
	
	@Id
	private String id;
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 ]+$")
	private String codigoMiembros;
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 ]+$")
	private String nombreMiembros;
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 ]+$")
	private String apellidoMiembros;
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
	private String correoMiembros;
	@Pattern(regexp = "^[0-9]{8}-[0-9]{1}$")
	private String duiMiembros;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigoMiembros() {
		return codigoMiembros;
	}
	public void setCodigoMiembros(String codigoMiembros) {
		this.codigoMiembros = codigoMiembros;
	}
	public String getNombreMiembros() {
		return nombreMiembros;
	}
	public void setNombreMiembros(String nombreMiembros) {
		this.nombreMiembros = nombreMiembros;
	}
	public String getApellidoMiembros() {
		return apellidoMiembros;
	}
	public void setApellidoMiembros(String apellidoMiembros) {
		this.apellidoMiembros = apellidoMiembros;
	}
	public String getCorreoMiembros() {
		return correoMiembros;
	}
	public void setCorreoMiembros(String correoMiembros) {
		this.correoMiembros = correoMiembros;
	}
	public String getDuiMiembros() {
		return duiMiembros;
	}
	public void setDuiMiembros(String duiMiembros) {
		this.duiMiembros = duiMiembros;
	}
	@Override
	public String toString() {
		return "Miembros [id=" + id + ", codigoMiembros=" + codigoMiembros + ", nombreMiembros=" + nombreMiembros
				+ ", apellidoMiembros=" + apellidoMiembros + ", correoMiembros=" + correoMiembros + ", duiMiembros="
				+ duiMiembros + "]";
	}
	
	

}
