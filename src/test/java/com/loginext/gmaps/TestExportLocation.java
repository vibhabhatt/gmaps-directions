package com.loginext.gmaps;

import org.junit.Assert;
import org.junit.Test;
import org.loginext.gmaps.ExportLocation;

import java.io.File;

public class TestExportLocation {

    @Test
    public void testExportDirections() throws InterruptedException {
        String url = "https://maps.google.com";
        String from = "Riddhi Gardens Banjar Pada";
        String to = "91 Springboard, Vikhroli";

        ExportLocation exportLocation = new ExportLocation();
        exportLocation.exportToSheet(url, from, to);
        String fileNameExcel = "directions.xlsx";
        String fileNameScreenShot = "destination.png";
        File fileExcel = new File(fileNameExcel);
        Assert.assertTrue("File should exist", fileExcel.exists());
        File fileDest = new File(fileNameScreenShot);
        Assert.assertTrue("File should exist", fileDest.exists());
    }
}
