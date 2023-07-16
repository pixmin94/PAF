package sg.iss.day28.repository;

import java.util.List;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonRepository {
    public static final String F_NAME = "name";
    public static final String F_TYPE = "type";
    public static final String F_IMG = "img";
    public static final String C_POKEMON = "pokemon";

    @Autowired
    private MongoTemplate template;

    // db.pokemon.distinct('type')
    public List<String> getAllDistinctTypes() {

        List<String> types = template.findDistinct( new Query(), F_TYPE , C_POKEMON,  String.class);

        return types;
    }

    /* 
    * db.pokemon.aggregate([
    *     { $match: { type: 'Grass' } },
    *     { $project: { _id: 0, name: 1, img: 1} }
    * ])
    */
    public List<Document> getAllPokemonByType(String type) {
        MatchOperation matchType = Aggregation.match( Criteria.where(F_TYPE).is(type));

        ProjectionOperation projectFields = Aggregation.project("name", "img").andExclude("_id");

        Aggregation pipeline = Aggregation.newAggregation(matchType, projectFields);
        AggregationResults<Document> results = template.aggregate(pipeline, C_POKEMON, Document.class);

        return results.getMappedResults();   
    }


    


}
