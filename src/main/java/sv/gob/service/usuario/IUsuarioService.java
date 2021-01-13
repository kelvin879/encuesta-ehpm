package sv.gob.service.usuario;

import java.util.List;

import sv.gob.models.usuario.Usuario;

public interface IUsuarioService {
	void guardar(Usuario usuario);
	void eliminar(String idUsuario);
	List<Usuario> buscarTodas();
	Usuario editar(String idUsuario);

}
