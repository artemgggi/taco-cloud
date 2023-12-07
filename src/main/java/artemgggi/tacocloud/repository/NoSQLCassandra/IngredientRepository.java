package artemgggi.tacocloud.repository.NoSQLCassandra;

import artemgggi.tacocloud.model.NoSQLCassandra.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}
