package prilax.yk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.user.*;
import prilax.yk.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ActionResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        ActionResponseDto response = authService.login(loginRequestDto);
        ResponseEntity<ActionResponseDto> responseEntity = new ResponseEntity<ActionResponseDto>(response,
                HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<VerifyUserResponseDto> verify(@Valid @RequestBody VerifyUserRequestDto verifyUserRequestDto) {
        VerifyUserResponseDto response = authService.verify(verifyUserRequestDto);
        ResponseEntity<VerifyUserResponseDto> responseEntity = new ResponseEntity<VerifyUserResponseDto>(response,
                HttpStatus.OK);
        return responseEntity;
    }

}
