package sv.gob.controller.llenado;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.gob.models.cuestionario.Pregunta;
import sv.gob.models.cuestionario.Seccion;
import sv.gob.models.encuesta.Encuesta;
import sv.gob.models.llenado.Llenado;
import sv.gob.models.llenado.SeccionLlenado;
import sv.gob.service.cuestionario.IPreguntaService;
import sv.gob.service.cuestionario.ISeccionService;
import sv.gob.service.encuesta.IEncuestaService;
import sv.gob.service.llenado.ILlenadoService;
import sv.gob.service.llenado.ISeccionLlenadoService;

@Controller
@RequestMapping("/llenado")
public class LlenadoController {
	
	@Autowired
	private ILlenadoService serviceLlenado;
	@Autowired
	private IEncuestaService serviceEncuesta;
	@Autowired
	private ISeccionService serviceSeccion;
	@Autowired
	private IPreguntaService servicePregunta;
	@Autowired
	private ISeccionLlenadoService serviceSeccionllenado;
	private static String id_Encuesta;
	private static String id_Seccion;
	private static String id_llenado;
	@GetMapping("/administrar")
	private String crearLlenado(Llenado llenado, Model model)
	{
		List<Llenado> llenados = serviceLlenado.buscarTodas();
		model.addAttribute("llenados", llenados);
		return "llenado/LlenarEncuestas";
	}
	
	@GetMapping("/secciones")
	private String seccionMostrar( Model model, Pageable page)
	{
		List<Seccion> lista = serviceSeccion.buscarSecciones(id_Encuesta);
		model.addAttribute("secciones", lista);	
		System.out.println(id_Encuesta); 
		model.addAttribute("encuesta", id_Encuesta);		
		return "llenado/LlenarSeccion";
	}

	@GetMapping("/secciones/{id}")
	private String seccion(@PathVariable("id") String idEncuesta, Encuesta encuesta, Model model, Pageable page)
	{
		id_Encuesta = idEncuesta;	
		return "redirect:/llenado/secciones";
	}

	
	@GetMapping("/preguntas/{seccion}")
	private String pregunta(@PathVariable("seccion") String idSeccion, Model model, Pageable page)
	{
		id_Seccion = idSeccion;	
		return "redirect:/llenado/preguntas";
	}

	@GetMapping("/preguntas")
	private String preguntasMostrar(Pregunta pregunta, Model model, Pageable page) {
		Page<Pregunta> preguntasList = servicePregunta.buscarSecciones(page, id_Seccion);
		model.addAttribute("preguntas", preguntasList);
		System.out.println(id_Seccion); 
		model.addAttribute("id_seccion", id_Seccion);
		for (Pregunta preg : preguntasList) {
			System.out.println(preg);
		}
		model.addAttribute("llenas", pregunta);

			return "llenado/LlenarPreguntas";
	}


	@PostMapping("/save")
	private String guardar(@Valid Llenado llenado, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()){
			List<Llenado> lista = serviceLlenado.buscarTodas();
			model.addAttribute("Llenados", lista);
			System.out.println("Existieron errores en el formulario"); 
			return "llenado/LlenarEncuestas";
		}	
				
		// Guadamos el objeto categoria en la bd
		serviceLlenado.guardar(llenado);
		attributes.addFlashAttribute("success", "Registro guardado con éxito");
			
		return "redirect:/llenado/administrar";	
	}

	
	@PostMapping("/preguntas/save")
	private String guardarPreguntas(@Valid SeccionLlenado seccionllenado, String[] idRespuestas,BindingResult result, Model model, RedirectAttributes attributes) {
		
		//pregunta.setTitulo(titulo);
		System.out.println(seccionllenado);
		System.out.println(idRespuestas);
		//serviceSeccionllenado.guardar(seccionllenado);
		return "redirect:/llenado/secciones";
			
	}
	
	@GetMapping("/eliminar/{id}")
	private String eliminar(@PathVariable("id") String idLlenado, RedirectAttributes attributes)
	{
		//Eliminamos el seccion
		serviceLlenado.eliminar(idLlenado);
		
		attributes.addFlashAttribute("success", "Registro eliminado exitosamente");
		return "redirect:/llenado/administrar";
	}

	@ModelAttribute
	public void setGenericos(Model model){
		String estado = "Habilitado";
		model.addAttribute("encuestas", serviceEncuesta.buscarEstado(estado));	
	}
	

}
