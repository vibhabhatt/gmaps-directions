package org.loginext.gmaps;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://maps.google.com";
        String from = "Riddhi Gardens Banjar Pada";
        String to = "91 Springboard, Vikhroli";

        ExportLocation exportLocation = new ExportLocation();
        exportLocation.exportToSheet(url, from, to);
    }
}