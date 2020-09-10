package prilax.yk.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prilax.yk.dao.user.UserRepository;
import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.common.ApiUtilDto;
import prilax.yk.dto.user.*;
import prilax.yk.entity.user.User;
import prilax.yk.error.exception.BadRequestException;
import prilax.yk.error.exception.NotFoundException;
import prilax.yk.service.common.CommonService;
import prilax.yk.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private CommonService commonService;

    @Autowired
    private UserRepository userRepository;

    public UsersResponseDto findUsers() {

        UsersResponseDto res = new UsersResponseDto();

        List<User> users = commonService.findAll(User.class);

        if (!Util.isAllPresent(users))
            throw new NotFoundException("No users are found !");

        List<RegistrationDto> usersDto = new ArrayList<>();
        users.forEach(user -> {
            RegistrationDto registrationDto = new RegistrationDto();
            registrationDto.setEmail(user.getEmail());
            usersDto.add(registrationDto);
        });

        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        res.setData(usersDto);

        return res;
    }


    public ActionResponseDto register(RegistrationDto registrationDto) {

        ActionResponseDto res = new ActionResponseDto();

        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setMobileNo(registrationDto.getMobileNo());
        user.setName(registrationDto.getName());
        user.setOtp("0000");
        commonService.save(user);

        String message = "";
        message = "Successfully created the user";
        res.setApiMessage(ApiUtilDto.okMessage(message));

        return res;
    }

    public ExistingUserResponseDto isAnExistingUser(String mobileNo) {

        ExistingUserResponseDto res = new ExistingUserResponseDto();

        Optional<User> userOpt = userRepository.findUsersByMobileNo(mobileNo);

        if (userOpt.isPresent())
            res.setAnExistingUser(true);

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

        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        return res;
    }

}
