package sv.gob.repository.encuesta;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import sv.gob.models.encuesta.Encuesta;

public interface EncuestaRepository extends MongoRepository<Encuesta, String>{

    List<Encuesta> findByEstado(String estado);


}
