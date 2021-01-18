package sv.gob.service.llenado;

import java.util.List;

import sv.gob.models.llenado.SeccionLlenado;
public interface ISeccionLlenadoService {
	void guardar(SeccionLlenado SeccionLlenado);
	void eliminar(String idSeccionLlenado);
	List<SeccionLlenado> buscarTodas();
	SeccionLlenado editar(String idSeccionLlenado);
}
