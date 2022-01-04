package com.csco.android;

import com.facebook.react.bridge.ReadableMap;

public interface IJSBridge {
    void sendMessage(ReadableMap params);
}
