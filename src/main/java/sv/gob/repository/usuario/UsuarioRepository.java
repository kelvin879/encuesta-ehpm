package sv.gob.repository.usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import sv.gob.models.usuario.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
