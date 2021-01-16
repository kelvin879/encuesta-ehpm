package sv.gob.repository.cuestionario;

import org.springframework.data.mongodb.repository.MongoRepository;

import sv.gob.models.cuestionario.Respuesta;

public interface RespuestaRepository extends MongoRepository <Respuesta,String> {
    
}
