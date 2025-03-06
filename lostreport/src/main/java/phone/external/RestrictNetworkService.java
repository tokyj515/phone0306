package phone.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "mobile", url = "${api.url.mobile}")
public interface RestrictNetworkService {
    @RequestMapping(method = RequestMethod.POST, path = "/restrictNetworks")
    public void restrictNetwork(@RequestBody RestrictNetwork restrictNetwork);

    @RequestMapping(method = RequestMethod.POST, path = "/restrictNetworks")
    public void unrestrictNetwork(@RequestBody RestrictNetwork restrictNetwork);
}
