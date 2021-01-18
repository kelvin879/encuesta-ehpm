package sv.gob.repository.usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import sv.gob.models.usuario.Users;

public interface UsuarioRepository extends MongoRepository<Users, String>{

}
