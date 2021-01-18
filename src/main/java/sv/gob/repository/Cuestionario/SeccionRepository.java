package sv.gob.repository.cuestionario;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import sv.gob.models.cuestionario.Seccion;

public interface SeccionRepository extends MongoRepository<Seccion, String> {

    List<Seccion> findByEncuesta(String encuesta);

}
