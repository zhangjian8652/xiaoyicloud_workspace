package com.test.email;

import java.io.File;

/**
 * author:zhangjian
 * date:2016-05-25
 * describe:
 **/
public class Email {
    private String fromAddress;
    private String subject;
    private String[] toAddresses;
    private String[] ccAddresses;
    private String[] bcAddresses;
    private File attachement;
    private File[] attachements;
    private String toAddress;
    private String ccAddress;
    private String bcAddress;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    private String context;

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String[] getToAddresses() {
        return toAddresses;
    }

    public void setToAddresses(String[] toAddresses) {
        this.toAddresses = toAddresses;
    }

    public String[] getCcAddresses() {
        return ccAddresses;
    }

    public void setCcAddresses(String[] ccAddresses) {
        this.ccAddresses = ccAddresses;
    }

    public File[] getAttachements() {
        return attachements;
    }

    public void setAttachements(File[] attachements) {
        this.attachements = attachements;
    }

    public String[] getBcAddresses() {
        return bcAddresses;
    }

    public void setBcAddresses(String[] bcAddresses) {
        this.bcAddresses = bcAddresses;
    }

    public File getAttachement() {
        return attachement;
    }

    public void setAttachement(File attachement) {
        this.attachement = attachement;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getBcAddress() {
        return bcAddress;
    }

    public void setBcAddress(String bcAddress) {
        this.bcAddress = bcAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
