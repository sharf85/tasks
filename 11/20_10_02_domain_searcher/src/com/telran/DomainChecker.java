package com.telran;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DomainChecker {

    private final List<String> zones;

    public DomainChecker(List<String> zones) {
        this.zones = new ArrayList<>(zones);
    }

    public List<String> getFreeDomains(String line) {
        return zones.stream()
                .map(zone -> line + "." + zone)
                .filter(this::isFree)
                .collect(Collectors.toList());
    }

    /**
     * Domain name of the second level plus zone
     *
     * @param domainName something like "tel-ran.de"
     * @return true if the domain is not occupied
     */
    private boolean isFree(String domainName) {
        String urlString = "http://" + domainName;
        try {
            URL url = new URL(urlString);

            URLConnection urlConn = url.openConnection();
            urlConn.setConnectTimeout(3000);
            urlConn.setReadTimeout(3000);
            urlConn.connect();
        } catch (UnknownHostException e) {
            return true;
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return false;
    }
}
