package sg.iss.Day22.controller;

import sg.iss.Day22.model.RSVP;
import sg.iss.Day22.repository.RsvpRepo;

public class RsvpController {
    @Autowired
    private RsvpRepo rsvpRepo;

    @GetMapping("/{rsvp-id}")
    public ResponseEntity<RSVP> getById(@PathVariable("rsvp-id") int id) {
        RSVP rsvp = rsvpRepo.findById(id);

        if (rsvp != null) {
            return new ResponseEntity<RSVP>(rsvp, HttpStatus.OK);
        }

        return new ResponseEntity<RSVP>(HttpStatus.INTERNAL_SERVER_ERROR);
   } 
}
