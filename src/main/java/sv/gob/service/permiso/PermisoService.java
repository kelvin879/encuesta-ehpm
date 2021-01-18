package sv.gob.service.permiso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.models.permiso.Permiso;
import sv.gob.repository.permiso.PermisoRepository;

@Service
public class PermisoService implements IPermisoService {

	@Autowired
	private PermisoRepository permisoRepo;

	@Override
	public void guardar(Permiso permiso) {
		// TODO Auto-generated method stub
		permisoRepo.save(permiso);

	}

	@Override
	public void eliminar(String idPermiso) {
		// TODO Auto-generated method stub
		permisoRepo.deleteById(idPermiso);
	}

	@Override
	public List<Permiso> buscarTodas() {
		// TODO Auto-generated method stub
		return (List<Permiso>) permisoRepo.findAll();
	}

	@Override
	public Permiso editar(String idPermiso) {
		// TODO Auto-generated method stub
		Optional<Permiso> optional = permisoRepo.findById(idPermiso);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
