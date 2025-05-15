package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class KeyboardActions {
    private AndroidDriver driver;

    public KeyboardActions(AndroidDriver driver) {
        this.driver = driver;
    }

    // Method to press individual digits on the Android keyboard using KeyEvent
    public void pressNumberKeys(String input) {
        String dob = "07101996";

        for (char digit : dob.toCharArray()) {
            AndroidKey key = mapDigitToAndroidKey(digit);
            if (key != null) {
                driver.pressKey(new KeyEvent(key));
            }
        }
    }

    private AndroidKey mapDigitToAndroidKey(char digit) {
        switch (digit) {
            case '0': return AndroidKey.DIGIT_0;
            case '1': return AndroidKey.DIGIT_1;
            case '2': return AndroidKey.DIGIT_2;
            case '3': return AndroidKey.DIGIT_3;
            case '4': return AndroidKey.DIGIT_4;
            case '5': return AndroidKey.DIGIT_5;
            case '6': return AndroidKey.DIGIT_6;
            case '7': return AndroidKey.DIGIT_7;
            case '8': return AndroidKey.DIGIT_8;
            case '9': return AndroidKey.DIGIT_9;
            default: return null;
        }
    }
}
