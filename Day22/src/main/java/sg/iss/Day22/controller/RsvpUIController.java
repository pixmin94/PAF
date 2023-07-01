package sg.iss.Day22.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.iss.Day22.RestTemplate.RsvpRestTemplate;
import sg.iss.Day22.model.RSVP;

@Controller
@RequestMapping("/rsvps")
public class RsvpUIController {
    
    RsvpRestTemplate restTem;

    public RsvpUIController() {
        restTem = new RsvpRestTemplate();
    }

    @GetMapping("/add")
    public String RSVPAdd(Model model) {

        RSVP newRSVP = new RSVP();
        model.addAttribute("rsvp", newRSVP);

        return "rsvpadd";

    }

    @PostMapping("/saveRSVP")
    public String postRSVP(@ModelAttribute RSVP rsvp) {
        
        Boolean bResult = restTem.createRSVP(rsvp);
        
        return "home";
    }

    @GetMapping("/list")
    public String listRSVP(Model model) {

        List<RSVP> rsvps = restTem.getRSVPS();
        model.addAttribute("rsvps", rsvps);

        return "rsvplist";
    }

}
