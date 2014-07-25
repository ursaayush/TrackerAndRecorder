package com.aayush.trackerandrecorder.configuration;

import com.aayush.trackerandrecorder.jabber.IncomingPacketListener;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.aayush.trackerandrecorder")
@Import(DatasourceConfig.class)
public class AppConfig {

    @Bean(name = "packetListener")
    public IncomingPacketListener incomingPacketListener(){
        return new IncomingPacketListener();
    }

}
