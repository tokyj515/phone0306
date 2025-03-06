package phone.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "mobile", url = "${api.url.mobile}")
public interface BlockDeviceService {
    @RequestMapping(method = RequestMethod.POST, path = "/blockDevices")
    public void blockDevice(@RequestBody BlockDevice blockDevice);

    @RequestMapping(method = RequestMethod.POST, path = "/blockDevices")
    public void unblockDevice(@RequestBody BlockDevice blockDevice);
}
