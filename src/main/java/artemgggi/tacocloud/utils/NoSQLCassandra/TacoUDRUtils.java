package artemgggi.tacocloud.utils.NoSQLCassandra;


import artemgggi.tacocloud.model.NoSQLCassandra.Ingredient;
import artemgggi.tacocloud.model.NoSQLCassandra.IngredientUDT;
import artemgggi.tacocloud.model.NoSQLCassandra.Taco;
import artemgggi.tacocloud.model.NoSQLCassandra.TacoUDT;

import java.util.List;
import java.util.stream.Collectors;

public class TacoUDRUtils {

  public static TacoUDT toTacoUDT(Taco taco) {
    return new TacoUDT(taco.getName(), taco.getIngredients());
  }

  public static List<IngredientUDT> toIngredientUDTs(List<Ingredient> ingredients) {
    return ingredients.stream()
            .map(ingredient -> toIngredientUDT(ingredient))
            .collect(Collectors.toList());
  }

  public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
    return new IngredientUDT(ingredient.getName(), ingredient.getType());
  }
}