package com.aayush.trackerandrecorder.jabber;


import org.apache.log4j.Logger;
import org.jivesoftware.smack.*;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IncomingPacketListener implements PacketListener{

    static final Logger _logger = Logger.getLogger(IncomingPacketListener.class
            .getName());

    XMPPConnection xmppConnection;

    // Use a thread pool executor for handling incoming requests.
    private static ExecutorService threadExecutorPool = Executors.newCachedThreadPool();

    public void processPacket(Packet packet) {
        // process the packet here.

        // Do something with the incoming packet here.
        Message msg = (Message) packet;

        System.out.println("Received " + msg.getBody());

        Chat chat = xmppConnection.getChatManager().createChat(
                packet.getFrom(), new MessageListener() {
                    @Override
                    public void processMessage(Chat chat, Message message) {}});

        PacketCollector col = chat.createCollector();
        msg = (Message) col.nextResult(10000);
        if(msg.equals("ronnie")){
            try {
                chat.sendMessage("correct");
            } catch (XMPPException e) {
                e.printStackTrace();
            }
        }else{
            try {
                chat.sendMessage("incorrect");
            } catch (XMPPException e) {
                e.printStackTrace();
            }
        }
        String input = msg.getBody();
        if (input == null)
            return;
//        try {
//            //chat.sendMessage("Hoyo Boi");
//        } catch (XMPPException e) {
//            e.printStackTrace();
//        }

    }
    public void setXmppConnection(XMPPConnection xmppConnection) {
        this.xmppConnection = xmppConnection;
    }
}
