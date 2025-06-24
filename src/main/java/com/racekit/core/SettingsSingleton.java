package com.racekit.core;

/**
 * @class SettingsSingleton
 * @brief This singleton class keeps track of the current settings for the data format and UDP/IP settings
 * */
public class SettingsSingleton {
    private String host;
    private Integer port;
    private String dataFormat;

    private static SettingsSingleton instance;
    private SettingsSingleton() {}

    public static synchronized SettingsSingleton getInstance() {
        if (instance == null) {
            instance  = new SettingsSingleton();
        }
        return instance;
    }

    /* Getter */
    public String getHost() {
        return host;
    }
    public String getDataFormat() { return this.dataFormat; }
    public Integer getPort() {
        return port;
    }

    /* Setter */
    public void setPort(int port) {
        this.port = port;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public void setDataFormat(String format) {
        this.dataFormat = format;
    }

}
