package io.github.abidaryassine.productservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;

/**
 * @author yassineabidar on 31/1/2023
 */

@Getter
@Setter
public abstract class AbstractEntity {

    @Id
    private String id;
    private Instant createdAt;
    private Instant updatedAt;
}
