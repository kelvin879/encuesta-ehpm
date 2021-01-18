package sv.gob.repository.llenado;


import org.springframework.data.mongodb.repository.MongoRepository;

import sv.gob.models.llenado.Llenado;

public interface LlenadoRepository extends MongoRepository<Llenado, String>{


}
