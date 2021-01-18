package sv.gob.controller.permiso;

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

import sv.gob.models.permiso.Permiso;
import sv.gob.service.permiso.IPermisoService;

@Controller
@RequestMapping("/permiso")
public class PermisoController {
	
	
	@Autowired
	private IPermisoService permisoSevice;
	
	@GetMapping("/crear")
	private String CrearPermiso(Permiso permiso)
	{
		return "permiso/Crear";
	}
	
	@GetMapping("/administrar")
	private String MostrarPermiso(Model model)
	{
		List<Permiso> lista = permisoSevice.buscarTodas();

		model.addAttribute("permisos",lista);

		return "permiso/Administrar";
	}
	@GetMapping("/editar/{id}")
	private String Editar(@PathVariable("id") String idPermiso, Model model, RedirectAttributes attributes)
	{
		Permiso permiso= permisoSevice.editar(idPermiso);
		model.addAttribute("permiso",permiso);
		return "permiso/Editar";
	}
	
	@PostMapping("/save")
	private String guardar(@Valid Permiso permiso, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()){
			System.out.println("Existieron errores en el formulario"); 
			return "permiso/Crear";
		}	
				
		// Guadamos el objeto permiso en la bd
		permisoSevice.guardar(permiso);
		attributes.addFlashAttribute("success", "Registro guardado con éxito");
		return "redirect:/permiso/administrar";	
	}

	@GetMapping("/eliminar/{id}")
	private String eliminar(@PathVariable("id") String idPermiso, Model model, RedirectAttributes attributes)
	{
		//Eliminamos el permiso
		     	permisoSevice.eliminar(idPermiso);
		     	
				attributes.addFlashAttribute("success", "Registro eliminado exitosamente");
				return "redirect:/permiso/administrar";
		
	}
}
