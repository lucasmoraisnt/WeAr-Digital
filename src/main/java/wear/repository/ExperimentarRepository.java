package wear.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wear.models.Experimentar;


public interface ExperimentarRepository extends JpaRepository<Experimentar, Long> {

    Page<Experimentar> findByDescricaoContaining(String descricao, Pageable pageable);

}