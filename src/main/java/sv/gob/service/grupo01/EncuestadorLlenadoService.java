package sv.gob.service.grupo01;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import sv.gob.models.Asignacion02;

@Service
public class EncuestadorLlenadoService implements IEncuestadorLlenado{
	
	private List<Asignacion02> lista= null;
	
	public EncuestadorLlenadoService()
	{
		lista = new LinkedList<>();
		
		Asignacion02 persona1 = new Asignacion02();
		persona1.setNombre("Pablo");
		persona1.setEstado("Terminada");

		Asignacion02 persona2 = new Asignacion02();
		persona2.setNombre("Rafael");
		persona2.setEstado("Terminada");
	
		Asignacion02 persona3 = new Asignacion02();
		persona3.setNombre("Lucy");
		persona3.setEstado("En progreso");
				
		Asignacion02 persona4 = new Asignacion02();
		persona4.setNombre("Carlos");
		persona4.setEstado("Pendiente");
		
		
		lista.add(persona1);
		lista.add(persona2);
		lista.add(persona3);
		lista.add(persona4);
	}
	
	@Override
	public List<Asignacion02> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

}
