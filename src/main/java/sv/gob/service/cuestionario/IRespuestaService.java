package sv.gob.service.cuestionario;

import java.util.List;

import sv.gob.models.cuestionario.Respuesta;


public interface IRespuestaService {
	void guardar(Respuesta respuesta);
	void guardar2(Respuesta[] respuesta);
	void eliminar(String idRespuesta);
	List<Respuesta> buscarTodas();
	Respuesta editar(String idRespuesta);
	void editar2(String idRespuesta);

}
