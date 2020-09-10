package prilax.yk.dto.product;

import prilax.yk.dto.common.ApiMessageDto;


public class ProductResponseDto {

    private ProductDto data;

    private ApiMessageDto apiMessage;

    public ProductDto getData() {
        return data;
    }

    public void setData(ProductDto data) {
        this.data = data;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
