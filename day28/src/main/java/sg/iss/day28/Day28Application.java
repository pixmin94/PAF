package sg.iss.day28;

import java.util.List;

import org.bson.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.iss.day28.repository.PokemonRepository;
import sg.iss.day28.Utils;

@SpringBootApplication
public class Day28Application { // implements CommandLineRunner

	@Autowired
	private PokemonRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Day28Application.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	List<String> result = repo.getAllDistinctTypes();
	// 	System.out.println(">>>>>>>>>>> \n");
	// 	for (String type : result) {
	// 		System.out.println(type);
	// 	}

	// 	List<Document> listOfPokemonByType = repo.getAllPokemonByType("Grass");
	// 	System.out.println(">>>>>>>>>>> \n");
	// 	for (Document poke : listOfPokemonByType) {
	// 		System.out.println(poke.toJson());
	// 	}

	// 	System.exit(0);
	// }

}
