package com.shaghayegh.robot;

import com.shaghayegh.phone.T9KeyboardPhone;
import com.shaghayegh.phone.QwertyKeyboardPhone;

public class Robot {
    T9KeyboardPhone t9KeyboardPhone = new T9KeyboardPhone();
    QwertyKeyboardPhone qwertyKeyboardPhone = new QwertyKeyboardPhone();

    /**
     *
     * @param intendedMessage The message to be sent
     * @param phoneType The phone to be used for sending the message
     */
    public void sendMessage(String intendedMessage, PhoneType phoneType) {
        if (phoneType == PhoneType.T9) {
            t9KeyboardPhone.type(intendedMessage);
            t9KeyboardPhone.clickSend();
        } else if (phoneType == PhoneType.QWERTY) {
            qwertyKeyboardPhone.type(intendedMessage);
            qwertyKeyboardPhone.clickSend();
        }
    }
}
