package sv.gob.service.cuestionario;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sv.gob.models.cuestionario.Seccion;


public interface ISeccionService {
	void guardar(Seccion seccion);
	void eliminar(String idSeccion);
	List<Seccion> buscarTodas();
	List<Seccion> buscarSecciones(String idEncuesta);
	Seccion editar(String idSeccion);
	void editar2(String idSeccion);
	Page<Seccion> buscarTodas(Pageable page);

}
