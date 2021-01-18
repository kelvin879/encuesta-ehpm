package sv.gob.service.permiso;

import java.util.List;

import sv.gob.models.permiso.Permiso;

public interface IPermisoService {
	void guardar(Permiso permiso);
	void eliminar(String idPermiso);
	List<Permiso> buscarTodas();
	Permiso editar(String idPermiso);

}
