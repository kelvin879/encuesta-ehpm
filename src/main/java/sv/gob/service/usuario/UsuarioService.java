package sv.gob.service.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.models.usuario.Usuario;
import sv.gob.repository.usuario.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepo.save(usuario);

	}

	@Override
	public void eliminar(String idUsuario) {
		// TODO Auto-generated method stub
		usuarioRepo.deleteById(idUsuario);

	}

	@Override
	public List<Usuario> buscarTodas() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepo.findAll();
	}

	@Override
	public Usuario editar(String idUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional = usuarioRepo.findById(idUsuario);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	

}
