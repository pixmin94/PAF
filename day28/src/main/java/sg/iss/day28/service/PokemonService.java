package sg.iss.day28.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.iss.day28.repository.PokemonRepository;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository repo;

    public List<String> getAllDistinctTypes() {
        List<String> types = repo.getAllDistinctTypes();
        return types;
    }

    // public List<Pokemon> getAllPokemonByType(String type) {
    //     // use util
    // }
}
