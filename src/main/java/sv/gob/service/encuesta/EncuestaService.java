package sv.gob.service.encuesta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.models.encuesta.Encuesta;
import sv.gob.repository.encuesta.EncuestaRepository;

@Service
public class EncuestaService implements IEncuestaService {

	@Autowired
	private EncuestaRepository encuestaRepo;
	
	@Override
	public void guardar(Encuesta encuesta) {
		encuestaRepo.save(encuesta);
	}

	@Override
	public void eliminar(String idEncuesta) {
		encuestaRepo.deleteById(idEncuesta);
	}

	@Override
	public List<Encuesta> buscarTodas() {
		return (List<Encuesta>) encuestaRepo.findAll();
	}

	@Override
	public Encuesta editar(String idEncuesta) {
		// TODO Auto-generated method stub
		Optional<Encuesta> optional = encuestaRepo.findById(idEncuesta);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	@Override
	public void editar2(String idEncuesta) {
		encuestaRepo.findById(idEncuesta);
		
	}

}
