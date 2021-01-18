package sv.gob.service.cuestionario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import sv.gob.models.cuestionario.Pregunta;
import sv.gob.repository.cuestionario.PreguntaRepository;

@Service
public class PreguntaService implements IPreguntaService {

	@Autowired
	private PreguntaRepository preguntaRepo;

	@Override
	public void guardar(Pregunta pregunta) {
		preguntaRepo.save(pregunta);

	}

	@Override
	public void eliminar(String idPregunta) {
		preguntaRepo.deleteById(idPregunta);

	}

	@Override
	public List<Pregunta> buscarTodas() {

		return (List<Pregunta>) preguntaRepo.findAll();
	}

	@Override
	public Pregunta editar(String idPregunta) {
		// TODO Auto-generated method stub
		Optional<Pregunta> optional = preguntaRepo.findById(idPregunta);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Pregunta> buscarSecciones(String idSeccion) {
		return (List<Pregunta>) preguntaRepo.findBySeccion(idSeccion);
	}

	@Override
	public Page<Pregunta> buscarSecciones(org.springframework.data.domain.Pageable page, String idSeccion) {
		// TODO Auto-generated method stub
		return preguntaRepo.findBySeccion(page, idSeccion);
	}



}

