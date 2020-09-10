package prilax.yk.dto.product;

import prilax.yk.dto.common.ApiMessageDto;

import java.util.List;

public class PaymentOptionsResponseDto {

    private List<PaymentOptionDto> data;

    private ApiMessageDto apiMessage;

    public List<PaymentOptionDto> getData() {
        return data;
    }

    public void setData(List<PaymentOptionDto> data) {
        this.data = data;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
