package io.github.wesleyosantos91.sqs.publisher;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import io.awspring.cloud.messaging.core.SqsMessageHeaders;
import io.github.wesleyosantos91.sqs.domain.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SQSPublisher {

    private final QueueMessagingTemplate messagingTemplate;

    @Value("${aws.queue.name}")
    private String queueName;

    public void send(Person person) {
        Map<String, Object> headers = new HashMap<>();

        log.info("Sending message : {}", person);

        messagingTemplate.convertAndSend(queueName, person, headers);

    }
}
