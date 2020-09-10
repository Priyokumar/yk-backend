package prilax.yk.dto.product;

import prilax.yk.dto.common.ApiMessageDto;


public class CategoryResponseDto {

    private CategoryDto data;

    private ApiMessageDto apiMessage;

    public CategoryDto getData() {
        return data;
    }

    public void setData(CategoryDto data) {
        this.data = data;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
