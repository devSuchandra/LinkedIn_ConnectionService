package com.CodingShuttle.LinkedIn.ConnectionService.Service;
import com.CodingShuttle.LinkedIn.ConnectionService.Entity.Person;
import com.CodingShuttle.LinkedIn.ConnectionService.Repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ConnectionsService {
    private final PersonRepository personRepository;
    public List<Person> getFirstDegreeConnections(Long userId) {
        log.info("Fetching first degree connections for userId: {}", userId);
        return personRepository.getFirstDegreeConnections(userId);
    }
}
