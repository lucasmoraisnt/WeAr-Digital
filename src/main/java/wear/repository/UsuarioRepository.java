package wear.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wear.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String username);

}