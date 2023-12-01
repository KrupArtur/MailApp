package com.test.jfx.model;

import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {

    private String address;
    private String password;
    private Properties properties;
    private Store store;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        properties = new Properties();
     /*   properties.put("incomingHost", "imap.gmail.com");
        properties.put("mail.store.protocol", "imaps");

        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smtp.gmail.com");
        properties.put("mail.smtps.auth", "true");
        properties.put("outgoingHost", "smtp.gmail.com");
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.imap.auth.mechanisms", "XOAUTH2");
        */
        properties.put("mail.smtp.ssl.trust","smtp.gmail.com");
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("incomingHost", "imap.gmail.com");
    }
}
