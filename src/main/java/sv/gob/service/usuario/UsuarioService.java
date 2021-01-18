package sv.gob.service.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.models.usuario.Users;
import sv.gob.repository.usuario.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public void guardar(Users usuario) {
		// TODO Auto-generated method stub
		usuarioRepo.save(usuario);

	}

	@Override
	public void eliminar(String idUsuario) {
		// TODO Auto-generated method stub
		usuarioRepo.deleteById(idUsuario);

	}

	@Override
	public List<Users> buscarTodas() {
		// TODO Auto-generated method stub
		return (List<Users>) usuarioRepo.findAll();
	}

	@Override
	public Users editar(String idUsuario) {
		// TODO Auto-generated method stub
		Optional<Users> optional = usuarioRepo.findById(idUsuario);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	

}
