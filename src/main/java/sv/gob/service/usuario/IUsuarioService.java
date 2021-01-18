package sv.gob.service.usuario;

import java.util.List;

import sv.gob.models.usuario.Users;

public interface IUsuarioService {
	void guardar(Users usuario);
	void eliminar(String idUsuario);
	List<Users> buscarTodas();
	Users editar(String idUsuario);

}
