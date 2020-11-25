package sv.gob.controller.revision;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sv.gob.models.grupo02.Encuesta;
import sv.gob.service.controlCalidad.IControlEncuestaService;

@Controller
public class ControlEncuestaController {
	
	@Autowired
	private IControlEncuestaService ControlEncuestaService;
	
	@GetMapping("/revision")
	private String EncuestasRevision(Model model)
	{
		List<Encuesta> listaRevision=ControlEncuestaService.mostrarRevision();
		model.addAttribute("revision",listaRevision);
		return "revision/EncuestasRevision";
	}


	@GetMapping("/revisar")
	private String EncuestasRevisar(Model model)
	{
		List<Encuesta> listaPila=ControlEncuestaService.mostrarPila();
		model.addAttribute("revisar",listaPila);
		return "revision/EncuestasRevisar";
	}
}
