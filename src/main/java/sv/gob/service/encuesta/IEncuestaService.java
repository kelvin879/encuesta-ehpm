package sv.gob.service.encuesta;

import java.util.List;

import sv.gob.models.encuesta.Encuesta;

public interface IEncuestaService {
	void guardar(Encuesta encuesta);
	void eliminar(String idEncuesta);
	List<Encuesta> buscarTodas();
	List<Encuesta> buscarEstado(String estado);
	Encuesta editar(String idEncuesta);
	void editar2(String idEncuesta);
}
