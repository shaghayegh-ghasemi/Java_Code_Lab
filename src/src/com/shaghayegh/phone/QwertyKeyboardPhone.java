package com.shaghayegh.phone;

import java.util.*;

public class QwertyKeyboardPhone implements HasSendButton, HasKeys {
    private final List<Character> validKey;
    private String lastMessage;
    private final MessageSender sender = new MessageSender();

    public QwertyKeyboardPhone(){
        validKey = Arrays.asList(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '
        );

        lastMessage = "";
    }

    @Override
    public void clickSend() {
        if (!lastMessage.isEmpty() && lastMessage != null) {
            sender.sendMessage(lastMessage);
        } else {
            System.out.println("No message to sent! ");
        }
    }

    public void type(String message){
        for(Character c: message.toLowerCase().toCharArray()){
            if (validKey.contains(c)){
                if (c == ' ') clickKey("space");
                else clickKey(String.valueOf(c));
            } else {
                System.out.println("Unknown character: " + c);
            }
        }

        lastMessage = message.toLowerCase().replaceAll("[^a-z ]", "");
    }
}
