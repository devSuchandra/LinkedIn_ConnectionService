package com.CodingShuttle.LinkedIn.ConnectionService.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Positive
    private Long userId;

    @NotBlank
    private String name;
}
