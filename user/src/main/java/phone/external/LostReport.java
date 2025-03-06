package phone.external;

import java.util.Date;
import lombok.Data;

@Data
public class LostReport {

    private Long reportId;
    private Long userId;
    private String phone;
    private String deviceModel;
    private Date lostDate;
    private String status;
}
