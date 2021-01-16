package sv.gob.service.cuestionario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.models.cuestionario.Respuesta;
import sv.gob.repository.cuestionario.RespuestaRepository;

@Service
public class RespuestaService implements IRespuestaService {
	
	@Autowired
	private RespuestaRepository respuestaRepo;

	@Override
	public void guardar(Respuesta respuesta) {
		respuestaRepo.save(respuesta);
		
	}

	@Override
	public void eliminar(String idRespuesta) {
		respuestaRepo.deleteById(idRespuesta);
		
	}

	@Override
	public List<Respuesta> buscarTodas() {
		return (List<Respuesta>) respuestaRepo.findAll();
	}

	@Override
	public Respuesta editar(String idRespuesta) {
		// TODO Auto-generated method stub
		Optional<Respuesta> optional = respuestaRepo.findById(idRespuesta);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	@Override
	public void editar2(String idRespuesta) {
		respuestaRepo.findById(idRespuesta);
	}

	@Override
	public void guardar2(Respuesta[] respuesta) {
		// TODO Auto-generated method stub
		for (int i=0; i<respuesta.length; i++)
		{
			Respuesta respues=respuesta[i];
			respuestaRepo.save(respues);
		}		

	}
}

