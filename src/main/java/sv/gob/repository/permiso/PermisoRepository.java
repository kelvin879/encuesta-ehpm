package sv.gob.repository.permiso;

import org.springframework.data.mongodb.repository.MongoRepository;

import sv.gob.models.permiso.Permiso;

public interface PermisoRepository extends MongoRepository<Permiso, String> {

    
}
