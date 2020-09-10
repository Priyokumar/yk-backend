package prilax.yk.util;

import java.util.concurrent.ThreadLocalRandom;

public class OTPUtils {

	public static int generateOTP() {
		int randomNum = ThreadLocalRandom.current().nextInt(1000, 9999);
		return randomNum;
	}
}
