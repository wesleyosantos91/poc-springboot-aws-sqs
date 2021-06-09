package io.github.wesleyosantos91.sqs.listener;

import io.awspring.cloud.messaging.listener.Acknowledgment;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import io.github.wesleyosantos91.sqs.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class SQSListener {

    @SqsListener(value = "${aws.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    public void listen(/*@Payload */Person person, Acknowledgment acknowledgment, @Headers Map<String, String> headers)
            throws ExecutionException, InterruptedException {

        log.info("Recieved Message: person = {}, headers = {}", person, headers);

        acknowledgment.acknowledge().get();
    }
}
