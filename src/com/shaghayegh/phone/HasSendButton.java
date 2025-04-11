package com.org.phone;

public interface HasSendButton {
    // The equivalent of hitting the send button after message is typed
    // This method should not be modified. The phone should store the message in memory and
    // this method should retrieve the message from memory and pass it to the PhoneConnector
    public void clickSend();
}
