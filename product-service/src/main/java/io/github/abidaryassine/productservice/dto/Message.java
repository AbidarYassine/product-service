package io.github.abidaryassine.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yassineabidar on 5/2/2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String message;
    private MessageType type;
}
