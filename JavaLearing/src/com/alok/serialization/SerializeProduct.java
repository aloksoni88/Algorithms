package com.alok.serialization;
import java.io.Serializable;

public class SerializeProduct implements Serializable{
	private static final long serialVersionUID = 1234567L;
	 
    private String headphonePort;
    private String thunderboltPort;
    private String lighteningPort;
    
    
	/**
	 * @return the headphonePort
	 */
	public String getHeadphonePort() {
		return headphonePort;
	}
	/**
	 * @param headphonePort the headphonePort to set
	 */
	public void setHeadphonePort(String headphonePort) {
		this.headphonePort = headphonePort;
	}
	/**
	 * @return the thunderboltPort
	 */
	public String getThunderboltPort() {
		return thunderboltPort;
	}
	/**
	 * @param thunderboltPort the thunderboltPort to set
	 */
	public void setThunderboltPort(String thunderboltPort) {
		this.thunderboltPort = thunderboltPort;
	}
	/**
	 * @return the lighteningPort
	 */
	public String getLighteningPort() {
		return lighteningPort;
	}
	/**
	 * @param lighteningPort the lighteningPort to set
	 */
	public void setLighteningPort(String lighteningPort) {
		this.lighteningPort = lighteningPort;
	}
	
    
	
    
}
