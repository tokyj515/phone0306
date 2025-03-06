package phone.external;

import java.util.Date;
import lombok.Data;

@Data
public class Insurance {

    private Long insuranceId;
    private Long userId;
    private String phone;
    private String policyType;
    private String claimStatus;
}
