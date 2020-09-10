package prilax.yk.dto.product;

import prilax.yk.dto.common.ApiMessageDto;

import java.util.List;

public class CategoriesResponseDto {

    private List<CategoryDto> data;

    private ApiMessageDto apiMessage;

    public List<CategoryDto> getData() {
        return data;
    }

    public void setData(List<CategoryDto> data) {
        this.data = data;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
