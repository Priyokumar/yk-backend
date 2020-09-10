package prilax.yk.dto.user;

import prilax.yk.dto.common.ApiMessageDto;

public class ExistingUserResponseDto {

    private  Boolean isAnExistingUser = false;

    private ApiMessageDto apiMessage;

    public Boolean getAnExistingUser() {
        return isAnExistingUser;
    }

    public void setAnExistingUser(Boolean anExistingUser) {
        isAnExistingUser = anExistingUser;
    }

    public ApiMessageDto getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(ApiMessageDto apiMessage) {
        this.apiMessage = apiMessage;
    }
}
