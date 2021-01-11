package sv.gob.controller.miembros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sv.gob.models.Usuarios;
import sv.gob.service.administrador.IUsuarioService;

@Controller
@RequestMapping("/miembros")
public class MiembrosController {
	
	@Autowired
	private IUsuarioService usuario;
	
	@GetMapping("/crear")
	private String CrearMiembros(Model model)
	{
		return "miembros/Crear";
	}
	
	@GetMapping("/editar")
	private String EditarMiembros(Model model)
	{
		return "miembros/Editar";
	}
	
	@GetMapping("/administrar")
	private String MostrarUsuario(Model model)
	{
		List<Usuarios> listaMostrarUsuario = usuario.mostrar();
		model.addAttribute("mostrarUsuario",listaMostrarUsuario);
		return "miembros/Administrar";
	}

}
