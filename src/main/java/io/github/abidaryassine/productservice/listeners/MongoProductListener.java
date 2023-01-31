package io.github.abidaryassine.productservice.listeners;

import io.github.abidaryassine.productservice.entities.AbstractEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author yassineabidar on 31/1/2023
 */
@Component
public class MongoProductListener extends AbstractMongoEventListener<AbstractEntity> {

    public void onBeforeConvert(BeforeConvertEvent<AbstractEntity> event) {
        super.onBeforeConvert(event);

        Instant now = Instant.now();

        event.getSource().setCreatedAt(now);
        event.getSource().setUpdatedAt(now);
    }
}
