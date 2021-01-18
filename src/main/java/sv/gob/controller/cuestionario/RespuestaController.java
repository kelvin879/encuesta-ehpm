package sv.gob.controller.cuestionario;

import java.util.List;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.gob.models.cuestionario.Respuesta;
import sv.gob.service.cuestionario.IRespuestaService;


@Controller
@RequestMapping("/respuesta")
public class RespuestaController {
	
	@Autowired
   	private IRespuestaService serviceRespuesta;

	   
	@PostMapping("/save")
	
	/*private String guardar ( RequestPath requestPath)
	{
		Respuesta res = new Respuesta();
		System.out.println(res);		
		

		return "redirect:/cuestionario/preguntas";

	}*/

	private String guardar(String respuesta[]) {
		/*if (result.hasErrors()){
			List<Respuesta> lista = serviceRespuesta.buscarTodas();
			model.addAttribute("respuestaes", lista);
			System.out.println("Existieron errores en el formulario"); 
			return "cuestionario/CrearRespuesta";
		}	*/

		for(String res: respuesta)
		{
			//String respu = res;
			System.out.println(res);
			Respuesta respuest= new Respuesta();
			serviceRespuesta.guardar(respuest);
		}
		 
		//serviceRespuesta.guardar(respuesta);		
		// Guadamos el objeto categoria en la bd
		//System.out.println(respuesta); 
		//serviceRespuesta.guardar(respuesta);
		//attributes.addFlashAttribute("success", "Registro guardado con éxito");

		//return "redirect:/categorias/index";
		return "redirect:/cuestionario/preguntas";	
	}
	
	@GetMapping("/editar/{id}")
	 private String editar(@PathVariable("id") String idRespuesta, Model model, RedirectAttributes attributes)
	 {
		Respuesta Respuesta= serviceRespuesta.editar(idRespuesta);
		model.addAttribute("respuesta",Respuesta);
		List<Respuesta> lista = serviceRespuesta.buscarTodas();
		model.addAttribute("respuestaes", lista);		
		return "cuestionario/CrearRespuesta";
	 }

	@GetMapping("/eliminar/{id}")
	private String eliminar(@PathVariable("id") String idRespuesta, RedirectAttributes attributes)
	{
		//Eliminamos el Respuesta
		serviceRespuesta.eliminar(idRespuesta);
		
		attributes.addFlashAttribute("success", "Registro eliminado exitosamente");
		return "redirect:/cuestionario/disenyo";
	}
	
}
