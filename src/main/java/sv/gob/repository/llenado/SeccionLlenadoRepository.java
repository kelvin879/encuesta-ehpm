package sv.gob.repository.llenado;

import org.springframework.data.mongodb.repository.MongoRepository;

import sv.gob.models.llenado.Llenado;
import sv.gob.models.llenado.SeccionLlenado;

public interface SeccionLlenadoRepository extends MongoRepository<SeccionLlenado, String> {


}
