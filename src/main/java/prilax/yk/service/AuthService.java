package prilax.yk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prilax.yk.dao.user.UserRepository;
import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.common.ApiUtilDto;
import prilax.yk.dto.user.BasicUserDataDto;
import prilax.yk.dto.user.LoginRequestDto;
import prilax.yk.dto.user.VerifyUserRequestDto;
import prilax.yk.dto.user.VerifyUserResponseDto;
import prilax.yk.entity.user.User;
import prilax.yk.error.exception.BadRequestException;
import prilax.yk.error.exception.NotFoundException;
import prilax.yk.service.common.CommonService;
import prilax.yk.util.Util;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private CommonService commonService;

    @Autowired
    private UserRepository userRepository;

    public ActionResponseDto login(LoginRequestDto loginRequestDto) {

        ActionResponseDto res = new ActionResponseDto();

        if (!Util.isAllPresent(loginRequestDto.getMobileNo()))
            throw new BadRequestException("Bad Request");

        Optional<User> userOpt = userRepository.findUsersByMobileNo(loginRequestDto.getMobileNo());

        if (!userOpt.isPresent())
            throw new NotFoundException("User not found.");

        userOpt.get().setOtp("0000");
        commonService.save(userOpt.get());

        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        return res;
    }

    public VerifyUserResponseDto verify(VerifyUserRequestDto verifyData) {

        VerifyUserResponseDto res = new VerifyUserResponseDto();

        if (!Util.isAllPresent(verifyData.getMobileNo()) || !Util.isAllPresent(verifyData.getOtp()))
            throw new BadRequestException("Bad Request");

        Optional<User> userOpt = userRepository.findUsersByMobileNo(verifyData.getMobileNo());

        if (!userOpt.isPresent() || !verifyData.getOtp().equals(userOpt.get().getOtp()))
            throw new NotFoundException("User not found.");

        BasicUserDataDto basicUserDataDto = new BasicUserDataDto();
        basicUserDataDto.setEmail(userOpt.get().getEmail());
        basicUserDataDto.setMobileNo(userOpt.get().getMobileNo());
        basicUserDataDto.setName(userOpt.get().getName());

        res.setData(basicUserDataDto);
        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        return res;
    }

}
