package phone.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "insurance", url = "${api.url.insurance}")
public interface InsuranceService {
    @RequestMapping(method = RequestMethod.POST, path = "/insurances")
    public void submitInsuranceClaim(@RequestBody Insurance insurance);

    @RequestMapping(method = RequestMethod.POST, path = "/insurances")
    public void cancleInsurance(@RequestBody Insurance insurance);
}
