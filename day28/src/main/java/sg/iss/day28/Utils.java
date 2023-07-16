package sg.iss.day28;

import org.bson.Document;
import sg.iss.day28.model.Pokemon;

public class Utils {
    public static Pokemon toPokemonObject(Document doc) {
        return new Pokemon(
            doc.getString("name"),
            doc.getString("type"),
            doc.getString("img")
        );
    }
}
