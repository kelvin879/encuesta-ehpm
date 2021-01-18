package sv.gob.controller.cuestionario;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import sv.gob.service.cuestionario.IPreguntaService;
import sv.gob.service.cuestionario.IRespuestaService;


@Controller
@RequestMapping("/pregunta")
public class PreguntaController {
	
	
	@Autowired
	  private IPreguntaService servicePregunta;
	 @Autowired
	  private IRespuestaService serviceRespuesta;

 	private String idSeccion;

	/* Mostrar preguntas */
	@GetMapping("/preguntas")
	private String crearCuestionario(Pregunta pregunta, Model model, Pageable page) {
		Page<Pregunta> preguntasList = servicePregunta.buscarSecciones(page, idSeccion);
		model.addAttribute("preguntas", preguntasList);
		System.out.println(idSeccion); 
		model.addAttribute("id_seccion", idSeccion);
		for (Pregunta preg : preguntasList) {
			System.out.println(preg);
		}
			return "cuestionario/PreguntasSeccion";
	}

	@GetMapping("/{seccion}")
	private String seccion(@PathVariable ("seccion") String seccion, Model model, Pageable page)
	{
		idSeccion = seccion;	
		return "redirect:/pregunta/preguntas";
	}
	
	@PostMapping("/seleccion/save")
	private String guardarSeleccion(@Valid Pregunta pregunta,
	String respuesta[], BindingResult result, Model model, RedirectAttributes attributes) {
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
		//Pregunta pregunta = new Pregunta();
		//pregunta.setTitulo(titulo);
		//pregunta.setDescripcion(descripcion);
		pregunta.setRespuesta(respuestas);	
		pregunta.setSeccion(idSeccion);	
		pregunta.setTipo("seleccion");	
		System.out.println(pregunta); 
		servicePregunta.guardar(pregunta);
		attributes.addFlashAttribute("success", "Registro guardado con éxito");
			
		//return "redirect:/categorias/index";
		return "redirect:/pregunta/preguntas";	
	}
	
	@PostMapping("/multiple/save")
	private String guardarMultiple(@Valid Pregunta pregunta,
	String respuesta[], BindingResult result, Model model, RedirectAttributes attributes) {
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
		//Pregunta pregunta = new Pregunta();
		//pregunta.setTitulo(titulo);
		//pregunta.setDescripcion(descripcion);
		pregunta.setRespuesta(respuestas);	
		pregunta.setSeccion(idSeccion);	
		pregunta.setTipo("multiple");	
		System.out.println(pregunta); 
		servicePregunta.guardar(pregunta);
		attributes.addFlashAttribute("success", "Registro guardado con éxito");
			
		//return "redirect:/categorias/index";
		return "redirect:/pregunta/preguntas";	
	}


	@PostMapping("/texto/save")
	private String guardarTexto(@Valid Pregunta pregunta,
		 String respuesta,
		 BindingResult result, Model model, RedirectAttributes attributes){
		
		//Set<Respuesta>respuestas= new HashSet<Respuesta>();
		List<Respuesta> respuestas =new ArrayList<Respuesta>();
		
		if (result.hasErrors()){
			List<Pregunta> lista = servicePregunta.buscarTodas();
			model.addAttribute("preguntas", lista);
			System.out.println("Existieron errores en el formulario"); 
			return "cuestionario/Crearpregunta";
		}	

		Respuesta respu= new Respuesta();
		respu.setRespuesta("");
		serviceRespuesta.guardar(respu);	
		respuestas.add(respu);
		// Guadamos el objeto categoria en la bd	
		//Pregunta pregunta = new Pregunta();
		//pregunta.setTitulo(titulo);
		//pregunta.setDescripcion(descripcion);		
		pregunta.setSeccion(idSeccion);	
		pregunta.setTipo("texto");
		pregunta.setRespuesta(respuestas);	
		System.out.println(pregunta); 
		servicePregunta.guardar(pregunta);
		attributes.addFlashAttribute("success", "Registro guardado con éxito");
			
		//return "redirect:/categorias/index";
		return "redirect:/pregunta/preguntas";	
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
		List <Respuesta> respuestas;
		//Eliminamos el Pregunta
		Pregunta pregunta= servicePregunta.editar(idPregunta);
		respuestas = pregunta.getRespuesta();
		if(respuestas != null)
		{
			for(Respuesta res : respuestas)
			{
				serviceRespuesta.eliminar(res.getId());
			}

		}
		servicePregunta.eliminar(idPregunta);
		
		attributes.addFlashAttribute("success", "Registro eliminado exitosamente");
		return "redirect:/pregunta/preguntas";
	}
	
}
