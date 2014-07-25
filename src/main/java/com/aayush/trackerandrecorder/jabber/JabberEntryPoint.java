package com.aayush.trackerandrecorder.jabber;


import com.aayush.trackerandrecorder.configuration.AppContextHelper;
import com.aayush.trackerandrecorder.jabber.filters.CustomMessageFilter;
import org.apache.log4j.Logger;
import org.jivesoftware.smack.*;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.packet.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class JabberEntryPoint {
    public void connect(String server, int port, String s) throws Exception {
        ConnectionConfiguration config = new ConnectionConfiguration(server,
                port, s);
        if (s.equalsIgnoreCase("gmail.com")) {
            config.setSASLAuthenticationEnabled(false);
        }
        xmppConnection = new XMPPConnection(config);
        xmppConnection.connect();
    }

    public void disconnect() {
        if (xmppConnection != null) {
            xmppConnection.disconnect();
        }
    }

    public void sendChat(String userId, String message) {
        Chat chat = xmppConnection.getChatManager().createChat(userId,
                new MessageListener() {
                    public void processMessage(Chat chat, Message message) {
                        // do nothing. Only one way chat.

                    }
                });

        try {
            chat.sendMessage(message);
        } catch (XMPPException e) {
            _logger.debug("Sending chat failed.");
        }
    }

    public void login(String username, String password) throws Exception {
        String service = "";
        if ("".contains("google")) {
            service = "gmail.com";
        } else {
            service = "gmail.com";
        }
        connect("talk.google.com", 5222, service);
        xmppConnection.login(username, password);
    }

    public void run() {
        try {
            login("pmaapplication", "aayushJAIN");
            System.out.println("Login successful");
            listeningForMessages();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public JabberEntryPoint() {
        run();
    }

    @Autowired
    private IncomingPacketListener listener;

    public void listeningForMessages() {

        OrFilter orFilter = new OrFilter();
        //TODO :
        String[] addresses = new String("ursaayush@gmail.com").split(",");
        for (int i = 0; i < addresses.length; i++) {
            // remove all white spaces
            String address = addresses[i].replaceAll("\\s", "");
            orFilter.addFilter(new CustomMessageFilter(address));
            if (_logger.isDebugEnabled()) {
                System.out.println("Accepting chat messages from : " + address);
                _logger.debug("Accepting chat messages from : " + address);
            }
        }
        PacketCollector collector = xmppConnection
                .createPacketCollector(orFilter);
        if (this.listener == null) {
            System.out.println("setting coz listener null");
           this.listener = (IncomingPacketListener) AppContextHelper.getApplicationContext().getBean("packetListener");
            if (this.listener == null) {
                System.out.println("Still null");
            } else {
                System.out.println("Not null");
            }
        }
        this.listener.setXmppConnection(xmppConnection);

        // Register the listener.
        xmppConnection.addPacketListener(listener, orFilter);
    }

    static final Logger _logger = Logger.getLogger(JabberEntryPoint.class
            .getName());

    private XMPPConnection xmppConnection;

}
