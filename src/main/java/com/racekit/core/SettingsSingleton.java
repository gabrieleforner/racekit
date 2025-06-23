package com.racekit.core;

/**
 * @class SettingsSingleton
 * @brief This singleton class keeps track of the current settings for the data format and UDP/IP settings
 * */
public class SettingsSingleton {
    private String host;
    private int port;

    private static SettingsSingleton instance;
    private SettingsSingleton() {}

    public static synchronized SettingsSingleton getInstance() {
        if (instance == null) {
            instance  = new SettingsSingleton();
        }
        return instance;
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
}
