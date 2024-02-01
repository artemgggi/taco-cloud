package artemgggi.tacocloud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class IngredientRef implements Serializable {
    @Id
    private final String id;
    private final String ingredient;
}
