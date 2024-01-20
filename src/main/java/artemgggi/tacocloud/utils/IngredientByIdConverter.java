package artemgggi.tacocloud.utils;

import artemgggi.tacocloud.model.Ingredient;
import artemgggi.tacocloud.repository.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

   private final IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepository = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}

