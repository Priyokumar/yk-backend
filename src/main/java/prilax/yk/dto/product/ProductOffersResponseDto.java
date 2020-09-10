package prilax.yk.dto.product;

import prilax.yk.dto.common.ApiMessageDto;

import java.util.List;

public class ProductOffersResponseDto {

    private List<ProductOfferDto> data;

    private ApiMessageDto apiMessage;

    public List<ProductOfferDto> getData() {
        return data;
    }

    public void setData(List<ProductOfferDto> data) {
        this.data = data;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
