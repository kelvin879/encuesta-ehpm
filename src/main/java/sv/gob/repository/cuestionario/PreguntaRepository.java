package sv.gob.repository.cuestionario;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import sv.gob.models.cuestionario.Pregunta;


public interface PreguntaRepository extends MongoRepository<Pregunta, String> {
    
  List<Pregunta> findBySeccion(String seccion);
    
}
