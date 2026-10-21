package com.CodingShuttle.LinkedIn.ConnectionService.Repository;
import com.CodingShuttle.LinkedIn.ConnectionService.Entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;
public interface PersonRepository extends Neo4jRepository<Person, Long>{
    Optional<Person> getByName(String name);

    @Query("MATCH (p:Person)-[:CONNECTED_TO]-(c:Person) " +
            "WHERE p.userId = $userId " +
            "RETURN c")
    List<Person> getFirstDegreeConnections(Long userId);
}
