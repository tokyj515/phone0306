package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.InsuranceApplication;
import phone.domain.InsuranceClaimCanceled;
import phone.domain.InsuranceClaimSubmitted;

@Entity
@Table(name = "Insurance_table")
@Data
//<<< DDD / Aggregate Root
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long insuranceId;

    private Long userId;

    private String phone;

    private String policyType;

    private String claimStatus;

    @PostPersist
    public void onPostPersist() {
        InsuranceClaimSubmitted insuranceClaimSubmitted = new InsuranceClaimSubmitted(
            this
        );
        insuranceClaimSubmitted.publishAfterCommit();

        InsuranceClaimCanceled insuranceClaimCanceled = new InsuranceClaimCanceled(
            this
        );
        insuranceClaimCanceled.publishAfterCommit();
    }

    public static InsuranceRepository repository() {
        InsuranceRepository insuranceRepository = InsuranceApplication.applicationContext.getBean(
            InsuranceRepository.class
        );
        return insuranceRepository;
    }
}
//>>> DDD / Aggregate Root
