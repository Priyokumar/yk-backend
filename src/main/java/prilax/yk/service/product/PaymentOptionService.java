package prilax.yk.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.common.ApiUtilDto;
import prilax.yk.dto.product.*;
import prilax.yk.entity.common.PaymentOption;
import prilax.yk.error.exception.NotFoundException;
import prilax.yk.service.common.CommonService;
import prilax.yk.util.Util;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentOptionService {

    @Autowired
    private CommonService commonService;

    public PaymentOptionsResponseDto findPaymentOptions() {

        PaymentOptionsResponseDto res = new PaymentOptionsResponseDto();

        List<PaymentOption> paymentOptions = commonService.findAll(PaymentOption.class);

        if (!Util.isAllPresent(paymentOptions))
            throw new NotFoundException("No paymentOptions are found !");

        List<PaymentOptionDto> paymentOptionsDto = new ArrayList<>();
        paymentOptions.forEach(paymentOption->{
            paymentOptionsDto.add(setPaymentOptionToDto(paymentOption));
        });

        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        res.setData(paymentOptionsDto);

        return res;
    }

    public ActionResponseDto createOrUpdatePaymentOption(PaymentOptionDto paymentOptionDto, String id) {

        ActionResponseDto res = new ActionResponseDto();

        PaymentOption paymentOption = new PaymentOption();

        if (Util.isAllPresent(id)) {
            paymentOption.setId(id);
        }

        paymentOption.setName(paymentOptionDto.getName());
        paymentOption.setEnabled(paymentOptionDto.getEnabled());

        commonService.save(paymentOption);

        String message = "";
        if (Util.isAllPresent(id)) {
            message = "Successfully updated the PaymentOption data";
            res.setApiMessage(ApiUtilDto.okMessage(message));
        } else {
            message = "Successfully created a PaymentOption";
            res.setApiMessage(ApiUtilDto.createdMessage(message));
            res.setActionMessage(message);
        }

        return res;
    }

    public PaymentOptionResponseDto findPaymentOption(String id) {

        PaymentOptionResponseDto res = new PaymentOptionResponseDto();

        PaymentOption paymentOption = commonService.findById(id, PaymentOption.class);

        if (!Util.isAllPresent(paymentOption))
            throw new NotFoundException("No paymentOption can be found !");

        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        res.setData(setPaymentOptionToDto(paymentOption));

        return res;
    }

    public PaymentOptionDto setPaymentOptionToDto(PaymentOption paymentOption) {

        PaymentOptionDto paymentOptionDto = new PaymentOptionDto();

        paymentOptionDto.setEnabled(paymentOption.getEnabled());
        paymentOptionDto.setId(paymentOption.getId());
        paymentOptionDto.setName(paymentOption.getName());

        return paymentOptionDto;
    }

    public ActionResponseDto deletePaymentOption(String id) {

        ActionResponseDto res = new ActionResponseDto();

        PaymentOption paymentOption = commonService.findById(id, PaymentOption.class);

        if (!Util.isAllPresent(paymentOption))
            throw new NotFoundException("No paymentOption can be found !");

        commonService.delete(paymentOption);

        res.setApiMessage(ApiUtilDto.okMessage("Successfully deleted"));
        return res;
    }
}
