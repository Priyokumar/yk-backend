package prilax.yk.dto.user;

import prilax.yk.dto.common.ApiMessageDto;

public class VerifyUserResponseDto {

    private  BasicUserDataDto data;

    private ApiMessageDto apiMessage;

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }

    public BasicUserDataDto getData() {
        return data;
    }

    public void setData(BasicUserDataDto data) {
        this.data = data;
    }
}
