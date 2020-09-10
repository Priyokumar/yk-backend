package prilax.yk.dto.product;

import prilax.yk.dto.common.ApiMessageDto;

public class ProductOfferResponseDto {

    private ProductOfferDto data;

    private ApiMessageDto apiMessage;

    public ProductOfferDto getData() {
        return data;
    }

    public void setData(ProductOfferDto data) {
        this.data = data;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
