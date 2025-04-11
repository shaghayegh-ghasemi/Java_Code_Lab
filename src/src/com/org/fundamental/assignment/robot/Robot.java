package com.org.fundamental.assignment.robot;

import com.org.fundamental.assignment.phone.T9KeyboardPhone;
import com.org.fundamental.assignment.phone.QwertyKeyboardPhone;

public class Robot {
    T9KeyboardPhone t9KeyboardPhone = new T9KeyboardPhone();
    QwertyKeyboardPhone qwertyKeyboardPhone = new QwertyKeyboardPhone();

    /**
     *
     * @param intendedMessage The message to be sent
     * @param phoneType The phone to be used for sending the message
     */
    public void sendMessage(String intendedMessage, PhoneType phoneType) {

    }
}
