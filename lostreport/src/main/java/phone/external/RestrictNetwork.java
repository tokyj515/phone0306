package phone.external;

import java.util.Date;
import lombok.Data;

@Data
public class RestrictNetwork {

    private Long restrictionId;
    private Long userId;
    private String phone;
    private String imei;
    private String status;
    private String restrictedAt;
}
