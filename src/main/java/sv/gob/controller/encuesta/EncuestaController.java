package sv.gob.controller.encuesta;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.gob.models.encuesta.Encuesta;
import sv.gob.service.encuesta.IEncuestaService;

@Controller
@RequestMapping("/encuesta")
public class EncuestaController {
	
	@Autowired
	private IEncuestaService serviceEncuesta;
	
	@GetMapping("/administrar")
	private String crearEncuesta(Encuesta encuesta, Model model)
	{
		List<Encuesta> encuestas = serviceEncuesta.buscarTodas();
		model.addAttribute("encuestas", encuestas);
		
		return "encuesta/Administrar";
	}
	
	@PostMapping("/save")
	private String guardar(@Valid Encuesta encuestas, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()){
			List<Encuesta> lista = serviceEncuesta.buscarTodas();
			model.addAttribute("encuestas", lista);
			System.out.println("Existieron errores en el formulario"); 
			return "encuesta/Administrar";
		}	
				
		// Guadamos el objeto categoria en la bd
		serviceEncuesta.guardar(encuestas);
		attributes.addFlashAttribute("success", "Registro guardado con éxito");
			
		return "redirect:/encuesta/administrar";	
	}
	
	@GetMapping("/editar/{id}")
	 private String editar(@PathVariable("id") String idEncuesta, Model model, RedirectAttributes attributes)
	 {
		Encuesta encuesta= serviceEncuesta.editar(idEncuesta);
		model.addAttribute("encuesta",encuesta);
		List<Encuesta> listas = serviceEncuesta.buscarTodas();
		model.addAttribute("encuestas", listas);		
		return "encuesta/administrar";
	 }

	@GetMapping("/eliminar/{id}")
	private String eliminar(@PathVariable("id") String idEncuesta, RedirectAttributes attributes)
	{
		//Eliminamos el seccion
		serviceEncuesta.eliminar(idEncuesta);
		
		attributes.addFlashAttribute("success", "Registro eliminado exitosamente");
		return "redirect:/encuesta/administrar";
	}

}
