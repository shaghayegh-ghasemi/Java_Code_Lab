package com.shaghayegh.phone;

public interface HasKeys {
    // The equivalent of clicking a key to type letters
    public default void clickKey(String key) {
        System.out.println("Hit key " + key);
    }
}
