package sg.iss.day28.service;

import java.util.List;
import org.bson.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import sg.iss.day28.Utils;
import sg.iss.day28.model.Pokemon;
import sg.iss.day28.repository.PokemonRepository;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository repo;

    public List<String> getAllDistinctTypes() {
        List<String> types = repo.getAllDistinctTypes();
        return types;
    }

    public List<Pokemon> getAllPokemonByType(String type) {
        List<Document> pokeDoc = repo.getAllPokemonByType(type);
        List<Pokemon> poke = pokeDoc.stream()
            .map(p -> Utils.toPokemonObject(p))
            .collect(Collectors.toList());
        return poke;
    }
}
