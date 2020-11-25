package sv.gob.controller.cuestionario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuestionario")
public class CuestionarioController {

	@GetMapping("/disenyo")
	private String crearSeccion()
	{
		return "cuestionario/CrearSeccion";
	}

	@GetMapping("/preguntas")
	private String crearCuestionario()
	{
		return "cuestionario/PreguntasSeccion";
	}
	
}
