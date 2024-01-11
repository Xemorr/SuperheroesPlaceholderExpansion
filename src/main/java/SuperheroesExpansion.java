import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.xemor.superheroes.Superhero;
import me.xemor.superheroes.Superheroes;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SuperheroesExpansion extends PlaceholderExpansion {

    private Superheroes superheroes;

    @Override
    public @NotNull String getIdentifier() {
        return "superheroes";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Xemor_";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.3"; // make sure this stays up to date, placeholder team got annoyed it wasn't accurate
    }

    @Override
    public String getRequiredPlugin() {
        return "Superheroes";
    }

    @Override
    public boolean canRegister() {
        return (superheroes = (Superheroes) Bukkit.getPluginManager().getPlugin(getRequiredPlugin())) != null;
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        Superhero superhero = superheroes.getHeroHandler().getSuperhero(player);
        return switch (identifier) {
            case "name" -> superhero.getName();
            case "description" -> superhero.getDescription();
            default -> null;
        };
    }
}
