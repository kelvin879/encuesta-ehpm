package sv.gob.service.llenado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.models.llenado.SeccionLlenado;
import sv.gob.repository.llenado.SeccionLlenadoRepository;

@Service
public class SeccionLlenadoService implements ISeccionLlenadoService {

	@Autowired
	private SeccionLlenadoRepository seccionllenadoRepo;
	
	@Override
	public void guardar(SeccionLlenado seccionllenado) {
		seccionllenadoRepo.save(seccionllenado);
	}

	@Override
	public void eliminar(String idSeccionLlenado) {
		seccionllenadoRepo.deleteById(idSeccionLlenado);
	}

	@Override
	public List<SeccionLlenado> buscarTodas() {
		return (List<SeccionLlenado>) seccionllenadoRepo.findAll();
	}

	@Override
	public SeccionLlenado editar(String idSeccionLlenado) {
		// TODO Auto-generated method stub
		Optional<SeccionLlenado> optional = seccionllenadoRepo.findById(idSeccionLlenado);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

}
