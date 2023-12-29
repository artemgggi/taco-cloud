package artemgggi.tacocloud.repository;

import artemgggi.tacocloud.model.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TacoRepository
        extends PagingAndSortingRepository<Taco, Long> {
    Optional<Taco> findById(Long id);
    Taco save(Taco taco);
}

