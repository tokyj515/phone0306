package phone.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phone.config.kafka.KafkaProcessor;
import phone.domain.*;

@Service
public class QueryLostReportHistoryViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private QueryLostReportHistoryRepository queryLostReportHistoryRepository;
    //>>> DDD / CQRS
}
