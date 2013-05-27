/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.models;

/**
 *
 * @author Robert Smieja
 */
public class Options {

    private Integer currentWorld;
    private Integer currentMap;
    private String currentEventId;
    private Integer currentMatchId;
    private Boolean proxyEnabled;
    private String proxyAddress;
    private Integer proxyPort;
    final private String proxyProtocol = "https";

    public Options() {
        this.currentWorld = 0;
        this.currentMap = 0;
        this.currentEventId = "";
        this.currentMatchId = 0;
        this.proxyEnabled = false;
        this.proxyAddress = "";
        this.proxyPort = 0;
//        this.proxyProtocol = "";
    }

    public Integer getCurrentWorld() {
        return currentWorld;
    }

    public void setCurrentWorld(Integer currentWorld) {
        this.currentWorld = currentWorld;
    }

    public Integer getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Integer currentMap) {
        this.currentMap = currentMap;
    }

    public String getCurrentEventId() {
        return currentEventId;
    }

    public void setCurrentEventId(String eventId) {
        this.currentEventId = eventId;
    }

    public Integer getCurrentMatchId() {
        return currentMatchId;
    }

    public void setCurrentMatchId(Integer currentMatchId) {
        this.currentMatchId = currentMatchId;
    }

    public Boolean isProxyEnabled() {
        return proxyEnabled;
    }

    public void setProxyEnabled(Boolean proxyEnabled) {
        this.proxyEnabled = proxyEnabled;
    }
    
    public String getProxyAddress() {
        return proxyAddress;
    }

    public void setProxyAddress(String proxyAddress) {
        this.proxyAddress = proxyAddress;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

//    public String getProxyProtocol() {
//        return proxyProtocol;
//    }
//
//    public void setProxyProtocol(String proxyProtocol) {
//        this.proxyProtocol = proxyProtocol;
//    }
}
