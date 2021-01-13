package sv.gob.controller.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sv.gob.models.usuario.Usuario;
import sv.gob.service.usuario.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService serviceUsuario;

	@GetMapping("/administrar")
	private String MostrarUsuario(Usuario usuario, Model model)
	{
		List<Usuario> lista = serviceUsuario.buscarTodas();
		model.addAttribute("usuarios", lista);		
		return "usuario/Administrar";
	}
	
	@GetMapping("/crear")
	private String CrearUsuario(Model model)
	{
		return "usuario/Crear";
	}
	
	@GetMapping("/editar")
	private String EditarUsuario(Model model)
	{
		return "usuario/Editar";
	}
	
}
