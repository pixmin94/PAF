package sg.iss.day26;

import org.bson.Document;

import sg.iss.day26.models.TvShow;

public class Utils {

   public static TvShow toTvShow(Document doc) {
      return new TvShow(
         doc.getInteger("id"),
         doc.getString("name"),
         doc.getString("type"),
         doc.getString("language"),
         doc.getInteger("runtime")
      );
   }
   
}
