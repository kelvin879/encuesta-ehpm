package sv.gob.controller.cuestionario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import sv.gob.models.cuestionario.Pregunta;
import sv.gob.models.cuestionario.Respuesta;
import sv.gob.models.cuestionario.Seccion;
import sv.gob.service.cuestionario.IPreguntaService;
import sv.gob.service.cuestionario.IRespuestaService;


@Controller
@RequestMapping("/pregunta")
public class PreguntaController {
	
	
	@Autowired
	  private IPreguntaService servicePregunta;
	 @Autowired
	  private IRespuestaService serviceRespuesta;
	   
	
	@PostMapping("/seleccion/{id}")
	private String guardarSeleccion(@PathVariable("id") String idSeccion,@Valid Seccion seccion,
	String respuesta[], String titulo, String descripcion,
	BindingResult result, Model model, RedirectAttributes attributes) {
		List<Respuesta> respuestas =new ArrayList<Respuesta>();
		//Set<Respuesta>respuestas= new HashSet<Respuesta>();
		
		if (result.hasErrors()){
			List<Pregunta> lista = servicePregunta.buscarTodas();
			model.addAttribute("preguntas", lista);
			System.out.println("Existieron errores en el formulario"); 
			return "cuestionario/Crearpregunta";
		}	
		
		
		for(String res: respuesta)
		{		
			String respu = res;
			System.out.println(res);
			Respuesta respuest= new Respuesta();
			respuest.setRespuesta(respu);		
			serviceRespuesta.guardar(respuest);	
			respuestas.add(respuest);						
		}	
				
		// Guadamos el objeto categoria en la bd
		Pregunta pregunta = new Pregunta();
		pregunta.setTitulo(titulo);
		pregunta.setDescripcion(descripcion);
		pregunta.setRespuesta(respuestas);	
		pregunta.setSeccion(idSeccion);	
		pregunta.setTipo("seleccion");	
		System.out.println(pregunta); 
		servicePregunta.guardar(pregunta);
		attributes.addFlashAttribute("success", "Registro guardado con éxito");
			
		//return "redirect:/categorias/index";
		return "redirect:/cuestionario/preguntas/{id}";	
	}
	
	@PostMapping("/multiple/{id}")
	private String guardarMultiple(@PathVariable("id") String idSeccion,@Valid Seccion seccion,
		 String respuesta[], String titulo, String descripcion,
		 BindingResult result, Model model, RedirectAttributes attributes) {
		List<Respuesta> respuestas =new ArrayList<Respuesta>();
		//Set<Respuesta>respuestas= new HashSet<Respuesta>();
		
		if (result.hasErrors()){
			List<Pregunta> lista = servicePregunta.buscarTodas();
			model.addAttribute("preguntas", lista);
			System.out.println("Existieron errores en el formulario"); 
			return "cuestionario/Crearpregunta";
		}	
		
		
		for(String res: respuesta)
		{		
			String respu = res;
			System.out.println(res);
			Respuesta respuest= new Respuesta();
			respuest.setRespuesta(respu);		
			serviceRespuesta.guardar(respuest);	
			respuestas.add(respuest);						
		}	
				
		// Guadamos el objeto categoria en la bd
		Pregunta pregunta = new Pregunta();
		pregunta.setTitulo(titulo);
		pregunta.setDescripcion(descripcion);
		pregunta.setRespuesta(respuestas);	
		pregunta.setSeccion(idSeccion);	
		pregunta.setTipo("multiple");	
		System.out.println(pregunta); 
		servicePregunta.guardar(pregunta);
		attributes.addFlashAttribute("success", "Registro guardado con éxito");
			
		//return "redirect:/categorias/index";
		return "redirect:/cuestionario/preguntas/"+idSeccion;	
	}


	@PostMapping("/texto/{id}")
	private String guardarTexto(@PathVariable("id") String idSeccion,@Valid Seccion seccion,
		 String respuesta[], String titulo, String descripcion,
		 BindingResult result, Model model, RedirectAttributes attributes){
		
		//Set<Respuesta>respuestas= new HashSet<Respuesta>();
		
		if (result.hasErrors()){
			List<Pregunta> lista = servicePregunta.buscarTodas();
			model.addAttribute("preguntas", lista);
			System.out.println("Existieron errores en el formulario"); 
			return "cuestionario/Crearpregunta";
		}	
				
		// Guadamos el objeto categoria en la bd	
		Pregunta pregunta = new Pregunta();
		pregunta.setTitulo(titulo);
		pregunta.setDescripcion(descripcion);		
		pregunta.setSeccion(idSeccion);	
		pregunta.setTipo("texto");	
		System.out.println(pregunta); 
		servicePregunta.guardar(pregunta);
		attributes.addFlashAttribute("success", "Registro guardado con éxito");
			
		//return "redirect:/categorias/index";
		return "redirect:/cuestionario/preguntas/{id}";	
	}

	@GetMapping("/editar/{id}")
	 private String editar(@PathVariable("id") String idPregunta, Model model, RedirectAttributes attributes)
	 {
		Pregunta pregunta= servicePregunta.editar(idPregunta);
		model.addAttribute("pregunta",pregunta);
		List<Pregunta> lista = servicePregunta.buscarTodas();
		model.addAttribute("preguntaes", lista);		
		return "cuestionario/Crearpregunta";
	 }

	@GetMapping("/eliminar/{id}")
	private String eliminar(@PathVariable("id") String idPregunta, RedirectAttributes attributes)
	{
		//Eliminamos el Pregunta
		servicePregunta.eliminar(idPregunta);
		
		attributes.addFlashAttribute("success", "Registro eliminado exitosamente");
		return "redirect:/cuestionario/disenyo";
	}
	
}
