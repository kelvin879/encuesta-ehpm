package sv.gob.service.cuestionario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import sv.gob.models.cuestionario.Seccion;
import sv.gob.repository.cuestionario.SeccionRepository;

@Service
public class SeccionService implements ISeccionService {

	@Autowired
	private SeccionRepository seccionRepo;

	@Override
	public void guardar(Seccion seccion) {
		seccionRepo.save(seccion);

	}

	@Override
	public void eliminar(String idSeccion) {
		seccionRepo.deleteById(idSeccion);

	}

	@Override
	public List<Seccion> buscarTodas() {
		return (List<Seccion>) seccionRepo.findAll();
	}

	@Override
	public Seccion editar(String idSeccion) {
		// TODO Auto-generated method stub
		Optional<Seccion> optional = seccionRepo.findById(idSeccion);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void editar2(String idSeccion) {
		seccionRepo.findById(idSeccion);
	}

	@Override
	public Page<Seccion> buscarTodas(org.springframework.data.domain.Pageable page) {
		// TODO Auto-generated method stub
		return seccionRepo.findAll(page);
	}

	@Override
	public List<Seccion> buscarSecciones(String idEncuesta) {
		// TODO Auto-generated method stub
		return (List<Seccion>) seccionRepo.findByEncuesta(idEncuesta);
	}


}

