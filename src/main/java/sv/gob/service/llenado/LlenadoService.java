package sv.gob.service.llenado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.models.llenado.Llenado;
import sv.gob.repository.llenado.LlenadoRepository;

@Service
public class LlenadoService implements ILlenadoService {

	@Autowired
	private LlenadoRepository llenadoRepo;
	
	@Override
	public void guardar(Llenado llenado) {
		llenadoRepo.save(llenado);
	}

	@Override
	public void eliminar(String idLlenado) {
		llenadoRepo.deleteById(idLlenado);
	}

	@Override
	public List<Llenado> buscarTodas() {
		return (List<Llenado>) llenadoRepo.findAll();
	}

	@Override
	public Llenado editar(String idLlenado) {
		// TODO Auto-generated method stub
		Optional<Llenado> optional = llenadoRepo.findById(idLlenado);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	@Override
	public void editar2(String idLlenado) {
		llenadoRepo.findById(idLlenado);
		
	}

}
