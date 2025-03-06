package phone.external;

import java.util.Date;
import lombok.Data;

@Data
public class BlockDevice {

    private Long blockId;
    private Long userId;
    private String phone;
    private String imei;
    private String blockStatus;
    private Date blockAt;
}
