package prilax.yk.dto.user;

import prilax.yk.dto.common.ApiMessageDto;

import java.util.List;

public class UsersResponseDto {

    private List<RegistrationDto> data;

    private ApiMessageDto apiMessage;

    public List<RegistrationDto> getData() {
        return data;
    }

    public void setData(List<RegistrationDto> data) {
        this.data = data;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
