package sv.gob.service.cuestionario;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sv.gob.models.cuestionario.Pregunta;


public interface IPreguntaService {
	void guardar(Pregunta pregunta);	
	void eliminar(String idPregunta);
	List<Pregunta> buscarTodas();
	Page<Pregunta> buscarSecciones(Pageable page, String idSeccion);
	List<Pregunta> buscarSecciones(String idSeccion);
	Pregunta editar(String idPregunta);
	

}
