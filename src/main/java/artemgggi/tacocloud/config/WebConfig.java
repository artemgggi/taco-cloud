package artemgggi.tacocloud.config;

import artemgggi.tacocloud.model.Ingredient;
import artemgggi.tacocloud.model.Taco;
import artemgggi.tacocloud.repository.IngredientRepository;
import artemgggi.tacocloud.repository.TacoRepository;
import artemgggi.tacocloud.repository.UsersRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import artemgggi.tacocloud.model.Ingredient.Type;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }

//    @Bean
//    public ApplicationRunner dataLoader(IngredientRepository repo) {
//        return args -> {
//            repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
//            repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
//            repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
//            repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
//            repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
//            repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
//            repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
//            repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
//            repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
//            repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
//        };
//    }

    @Bean
    public CommandLineRunner dataLoader(
            IngredientRepository repo,
            UsersRepository userRepo,
            PasswordEncoder encoder,
            TacoRepository tacoRepo) {
        return args -> {
            Ingredient flourTortilla = new Ingredient(
                    "FLTO", "Flour Tortilla", Type.WRAP);
            Ingredient cornTortilla = new Ingredient(
                    "COTO", "Corn Tortilla", Type.WRAP);
            Ingredient groundBeef = new Ingredient(
                    "GRBF", "Ground Beef", Type.PROTEIN);
            Ingredient carnitas = new Ingredient(
                    "CARN", "Carnitas", Type.PROTEIN);
            Ingredient tomatoes = new Ingredient(
                    "TMTO", "Diced Tomatoes", Type.VEGGIES);
            Ingredient lettuce = new Ingredient(
                    "LETC", "Lettuce", Type.VEGGIES);
            Ingredient cheddar = new Ingredient(
                    "CHED", "Cheddar", Type.CHEESE);
            Ingredient jack = new Ingredient(
                    "JACK", "Monterrey Jack", Type.CHEESE);
            Ingredient salsa = new Ingredient(
                    "SLSA", "Salsa", Type.SAUCE);
            Ingredient sourCream = new Ingredient(
                    "SRCR", "Sour Cream", Type.SAUCE);
            repo.save(flourTortilla);
            repo.save(cornTortilla);
            repo.save(groundBeef);
            repo.save(carnitas);
            repo.save(tomatoes);
            repo.save(lettuce);
            repo.save(cheddar);
            repo.save(jack);
            repo.save(salsa);
            repo.save(sourCream);
            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(Arrays.asList(
                    flourTortilla, groundBeef, carnitas,
                    sourCream, salsa, cheddar));
            tacoRepo.save(taco1);
            Taco taco2 = new Taco();
            taco2.setName("Bovine Bounty");
            taco2.setIngredients(Arrays.asList(
                    cornTortilla, groundBeef, cheddar,
                    jack, sourCream));
            tacoRepo.save(taco2);
        };
    }
}
