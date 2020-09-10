package prilax.yk.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.product.*;
import prilax.yk.service.product.PaymentOptionService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/paymentOptions")
public class PaymentOptionController {

    @Autowired
    private PaymentOptionService paymentOptionService;

    @GetMapping
    public PaymentOptionsResponseDto findPaymentOptions() {

        return paymentOptionService.findPaymentOptions();
    }

    @PostMapping
    public ResponseEntity<ActionResponseDto> createPaymentOption(@Valid @RequestBody PaymentOptionDto paymentOptionDto) {
        ActionResponseDto response = paymentOptionService.createOrUpdatePaymentOption(paymentOptionDto, null);
        ResponseEntity<ActionResponseDto> responseEntity = new ResponseEntity<ActionResponseDto>(response,
                HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public PaymentOptionResponseDto findPaymentOption(@PathVariable("id") String id) {
        return paymentOptionService.findPaymentOption(id);
    }

    @PutMapping(value = "/{id}")
    public ActionResponseDto updatePaymentOption(@Valid @RequestBody PaymentOptionDto paymentOptionDto, @PathVariable("id") String id) {
        return paymentOptionService.createOrUpdatePaymentOption(paymentOptionDto, id);
    }

    @DeleteMapping(value = "/{id}")
    public ActionResponseDto deletePaymentOption(@PathVariable("id") String id) {
        return paymentOptionService.deletePaymentOption(id);
    }

}
