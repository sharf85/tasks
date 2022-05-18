package com.example.spring_load_balancer;

import com.example.spring_load_balancer.thread.Cleaner;
import com.example.spring_load_balancer.thread.UdpGatewaySender;
import com.example.spring_load_balancer.thread.UdpServerListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Balancer implements CommandLineRunner {

    private final Cleaner cleaner;
    private final UdpGatewaySender gatewaySender;
    private final UdpServerListener serverListener;

    public Balancer(Cleaner cleaner, UdpGatewaySender gatewaySender, UdpServerListener serverListener) {
        this.cleaner = cleaner;
        this.gatewaySender = gatewaySender;
        this.serverListener = serverListener;
    }

    @Override
    public void run(String... args) throws Exception {
        cleaner.run();
        gatewaySender.run();
        serverListener.run();
    }
}
