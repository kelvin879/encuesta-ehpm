package sv.gob.service.grupo01;

import java.util.List;

import sv.gob.models.EncuestasPendientes;
import sv.gob.models.PilaDeEncuestas;

public interface IJefeCampoService {
	
	List<PilaDeEncuestas> mostrar();
	List<EncuestasPendientes> mostrar2();

}
