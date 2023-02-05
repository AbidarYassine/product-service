package io.github.abidaryassine.productservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yassineabidar on 5/2/2023
 */
@RestController
@RequestMapping("ping")
public class PingController {


    @GetMapping
    public String pong() {
        return "pong";
    }
}
