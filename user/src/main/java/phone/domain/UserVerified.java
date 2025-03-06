package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserVerified extends AbstractEvent {

    private Long userId;
    private Date verifiedAt;
    private String method;

    public UserVerified(User aggregate) {
        super(aggregate);
    }

    public UserVerified() {
        super();
    }
}
//>>> DDD / Domain Event
