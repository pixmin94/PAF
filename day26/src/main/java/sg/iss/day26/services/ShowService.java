package sg.iss.day26.services;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.iss.day26.Utils;
import sg.iss.day26.models.TvShow;
import sg.iss.day26.repositories.ShowsRepository;

@Service
public class ShowService {

   @Autowired
   private ShowsRepository showRepo;

   public Optional<TvShow> findShowByName(String showName) {

      List<Document> result = showRepo.findShowsByName(showName);
      if (result.size() <= 0)
         return Optional.empty();

      return Optional.of(Utils.toTvShow(result.get(0)));
   }
   
}