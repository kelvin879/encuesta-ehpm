package sv.gob.service.cuestionario;

import java.util.List;

import sv.gob.models.cuestionario.Pregunta;


public interface IPreguntaService {
	void guardar(Pregunta pregunta);	
	void eliminar(String idPregunta);
	List<Pregunta> buscarTodas();
	List<Pregunta> buscarSecciones(String idSeccion);
	Pregunta editar(String idPregunta);
	void editar2(String idPregunta);

}
