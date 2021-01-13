package sv.gob.repository.encuesta;

import org.springframework.data.mongodb.repository.MongoRepository;

import sv.gob.models.encuesta.Encuesta;

public interface EncuestaRepository extends MongoRepository<Encuesta, String>{

}
