package phone.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "lostreport", url = "${api.url.lostreport}")
public interface LostReportService {
    @RequestMapping(method = RequestMethod.POST, path = "/lostReports")
    public void requestCustomerSupport(@RequestBody LostReport lostReport);

    @RequestMapping(method = RequestMethod.POST, path = "/lostReports")
    public void requestCustomerSupport(@RequestBody LostReport lostReport);

    @RequestMapping(method = RequestMethod.POST, path = "/lostReports")
    public void requestOnlineLostReport(@RequestBody LostReport lostReport);

    @RequestMapping(method = RequestMethod.POST, path = "/lostReports")
    public void requestOnlineLostReportCancel(
        @RequestBody LostReport lostReport
    );
}
