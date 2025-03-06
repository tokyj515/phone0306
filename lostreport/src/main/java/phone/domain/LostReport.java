package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.LostreportApplication;
import phone.domain.LostReportCancelCompleted;
import phone.domain.LostReportCompleted;

@Entity
@Table(name = "LostReport_table")
@Data
//<<< DDD / Aggregate Root
public class LostReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reportId;

    private Long userId;

    private String phone;

    private String deviceModel;

    private Date lostDate;

    private String status;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        phone.external.RestrictNetwork restrictNetwork = new phone.external.RestrictNetwork();
        // mappings goes here
        LostreportApplication.applicationContext
            .getBean(phone.external.RestrictNetworkService.class)
            .restrictNetwork(restrictNetwork);

        LostReportCompleted lostReportCompleted = new LostReportCompleted(this);
        lostReportCompleted.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        phone.external.RestrictNetwork restrictNetwork = new phone.external.RestrictNetwork();
        // mappings goes here
        LostreportApplication.applicationContext
            .getBean(phone.external.RestrictNetworkService.class)
            .unrestrictNetwork(restrictNetwork);

        LostReportCancelCompleted lostReportCancelCompleted = new LostReportCancelCompleted(
            this
        );
        lostReportCancelCompleted.publishAfterCommit();
    }

    public static LostReportRepository repository() {
        LostReportRepository lostReportRepository = LostreportApplication.applicationContext.getBean(
            LostReportRepository.class
        );
        return lostReportRepository;
    }
}
//>>> DDD / Aggregate Root
