package prilax.yk.dto.product;

import prilax.yk.dto.common.ApiMessageDto;

import java.util.List;

public class ProductsResponseDto {

    private List<ProductDto> data;

    private ApiMessageDto apiMessage;

    public List<ProductDto> getData() {
        return data;
    }

    public void setData(List<ProductDto> data) {
        this.data = data;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
