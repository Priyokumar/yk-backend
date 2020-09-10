package prilax.yk.dto.user;

import java.io.Serializable;

public class RegistrationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;

    private String mobileNo;

    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
