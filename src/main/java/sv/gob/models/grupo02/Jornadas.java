package sv.gob.models.grupo02;

public class Jornadas {
	private String fechaI;
	private String fechaF;
	private String grupo;
	
	public Jornadas() {}
	
	public Jornadas(String fechaI,String fechaF,String grupo) 
	{
		setFechaI(fechaI);
		setFechaF(fechaF);
		setGrupo(grupo);
	}
	
	public String getFechaI() {
		return fechaI;
	}
	public void setFechaI(String fechaI) {
		this.fechaI = fechaI;
	}
	public String getFechaF() {
		return fechaF;
	}
	public void setFechaF(String fechaF) {
		this.fechaF = fechaF;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}
