package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.MobileApplication;
import phone.domain.NetworkRestrictionCompleted;
import phone.domain.NetworkUnrestrictionCompleted;

@Entity
@Table(name = "RestrictNetwork_table")
@Data
//<<< DDD / Aggregate Root
public class RestrictNetwork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restrictionId;

    private Long userId;

    private String phone;

    private String imei;

    private String status;

    private String restrictedAt;

    @PostPersist
    public void onPostPersist() {
        NetworkRestrictionCompleted networkRestrictionCompleted = new NetworkRestrictionCompleted(
            this
        );
        networkRestrictionCompleted.publishAfterCommit();

        NetworkUnrestrictionCompleted networkUnrestrictionCompleted = new NetworkUnrestrictionCompleted(
            this
        );
        networkUnrestrictionCompleted.publishAfterCommit();
    }

    public static RestrictNetworkRepository repository() {
        RestrictNetworkRepository restrictNetworkRepository = MobileApplication.applicationContext.getBean(
            RestrictNetworkRepository.class
        );
        return restrictNetworkRepository;
    }
}
//>>> DDD / Aggregate Root
