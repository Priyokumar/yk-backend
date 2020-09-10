package prilax.yk.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import prilax.yk.dto.common.ActionResponseDto;

public class APIUtil {

    public  static <T> ResponseEntity<T> GetResponseWithStatus(T body, HttpStatus status){

        ResponseEntity<T> responseEntity = new ResponseEntity<T>(body, status);

        return (ResponseEntity<T>) responseEntity;
    }

}
