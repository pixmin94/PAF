package sg.iss.day28.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatusCode;

import sg.iss.day28.model.Pokemon;
import sg.iss.day28.service.PokemonService;

@Controller
@RequestMapping
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping(path="/")
    public ModelAndView getAllDistinctTypes() {
        ModelAndView mav = new ModelAndView();
        List<String> types = service.getAllDistinctTypes();

        mav.setViewName("index");
        mav.addObject("types", types);
        mav.setStatus(HttpStatusCode.valueOf(200));

        return mav;
    }

    @GetMapping(path="/{type}")
    public ModelAndView getAllPokemonByType(@PathVariable("type") String type) {
        ModelAndView mav = new ModelAndView();
        List<Pokemon> pokemon = service.getAllPokemonByType(type);

        mav.setViewName("pokemon");
        mav.addObject("type", type);
        mav.addObject("pokemon", pokemon);
        mav.setStatus(HttpStatusCode.valueOf(200));

        return mav;
    }

}
