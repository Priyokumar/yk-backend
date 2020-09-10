package prilax.yk.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.user.*;
import prilax.yk.service.user.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public UsersResponseDto findUsers() {
        return userService.findUsers();
    }

    @GetMapping(value = "/isAnExistingUser")
    public ExistingUserResponseDto isAnExistingUser(@RequestParam(name = "mobileNo", required = false) String mobileNo) {
        return userService.isAnExistingUser(mobileNo);
    }

    @PostMapping
    public ResponseEntity<ActionResponseDto> register(@Valid @RequestBody RegistrationDto registrationDto) {
        ActionResponseDto response = userService.register(registrationDto);
        ResponseEntity<ActionResponseDto> responseEntity = new ResponseEntity<ActionResponseDto>(response,
                HttpStatus.CREATED);
        return responseEntity;
    }

}
