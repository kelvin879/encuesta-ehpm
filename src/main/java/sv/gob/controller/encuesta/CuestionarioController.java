package sv.gob.controller.encuesta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuestionario")
public class CuestionarioController {
	@GetMapping("/create")
	private String crearCuestionario()
	{
		return "encuesta/CrearCuestionario";
	}
	
}
