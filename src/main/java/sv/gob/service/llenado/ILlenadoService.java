package sv.gob.service.llenado;

import java.util.List;

import sv.gob.models.llenado.Llenado;

public interface ILlenadoService {
	void guardar(Llenado llenado);
	void eliminar(String idLlenado);
	List<Llenado> buscarTodas();
	Llenado editar(String idLlenado);
	void editar2(String idLlenado);
}
