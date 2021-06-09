package io.github.wesleyosantos91.sqs.resource;

import io.github.wesleyosantos91.sqs.domain.Person;
import io.github.wesleyosantos91.sqs.publisher.SQSPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/events/persons")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonResource {

    private final SQSPublisher sqsPublisher;

    @PostMapping(value = "/publish")
    public ResponseEntity<?> sendMessageToKafkaTopic(@RequestBody Person person) {
        sqsPublisher.send(person);
        return ResponseEntity.accepted().build();
    }
}
