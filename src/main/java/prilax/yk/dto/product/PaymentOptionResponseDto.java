package prilax.yk.dto.product;

import prilax.yk.dto.common.ApiMessageDto;


public class PaymentOptionResponseDto {

    private PaymentOptionDto data;

    private ApiMessageDto apiMessage;

    public PaymentOptionDto getData() {
        return data;
    }

    public void setData(PaymentOptionDto data) {
        this.data = data;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
