/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arem.facturacion.procesador;

import edu.eci.arem.facturacion.Parser.Parser;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;


public class FacturaExtractor extends Thread {

    private final String urlPath = "http://localhost:8080/api/factura";
    private final String usrPass = "admin:1234";


    @Override
    public void start() {
        while (true) {
            try {
                //Se revisa nuevasFacturas para determinar si hay nuevas por procesar
                URL url = new URL(urlPath + "/nuevasFacturas");
                String encoding = Base64.getEncoder().encodeToString(usrPass.getBytes("UTF-8"));

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoOutput(true);
                connection.setRequestProperty("Authorization", "Basic " + encoding);
                InputStream content = (InputStream) connection.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(content));
                String line;
                String output = new String("");
                while ((line = in.readLine()) != null) {
                    output = output + line;
                }

                if (!output.equals("[]")) {
                    output = output.replace("[", "");
                    output = output.replace("]", "");
                    String[] facturasID = output.split(",");
                    for (int i = 0; i < facturasID.length; i++) {
                        URL url2 = new URL(urlPath + "/getAndDelete");
                        String encoding2 = Base64.getEncoder().encodeToString(usrPass.getBytes("UTF-8"));

                        HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
                        connection2.setRequestMethod("DELETE");
                        connection2.setDoInput(true);
                        connection2.setDoOutput(true);
                        connection2.setRequestProperty("Authorization", "Basic " + encoding2);
                        connection2.setRequestProperty("Content-Type", "text/plain");
                        OutputStreamWriter out = new OutputStreamWriter(connection2.getOutputStream());
                        out.write(facturasID[i]);
                        out.close();
                        InputStream content2 = (InputStream) connection2.getInputStream();
                        BufferedReader in2 =
                                new BufferedReader(new InputStreamReader(content2));
                        String line2;
                        String output2 = new String("");
                        while ((line2 = in2.readLine()) != null) {
                            //System.out.println(line2);
                            output2 = output2 + line2;
                        }
                        PrintWriter writer = new PrintWriter("procesados/json/factura" + facturasID[i] + ".json");
                        writer.println(output2);
                        writer.close();
                    }
                Parser parser = new Parser();
                parser.procesar();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
