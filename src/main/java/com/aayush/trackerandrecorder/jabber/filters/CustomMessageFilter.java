package com.aayush.trackerandrecorder.jabber.filters;


import org.apache.log4j.Logger;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

public class CustomMessageFilter implements PacketFilter{

    static final Logger _logger = Logger
            .getLogger(CustomMessageFilter.class.getName());

    private String address;

    public CustomMessageFilter(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Parameter cannot be null.");
        }
        this.address = address.toLowerCase();
    }

    public boolean accept(Packet packet) {
        if (packet.getFrom() == null) {
            return false;
        } else {
            try {
                String packetFrom = packet.getFrom();
                String address[] = packetFrom.split("/");
                if (address[0].equalsIgnoreCase(this.address)) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

    public String toString() {
        return "CustomMessageFilter: " + address;
    }
}
