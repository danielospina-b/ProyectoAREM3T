package edu.eci.arem.facturacion.Parser;

import java.io.*;
import java.nio.charset.Charset;

import org.json.JSONException;//http://bit.ly/12O4D2w


public class Parser extends Thread {

    private final String path;
    
    public Parser() {
        this.path = "./procesados";
    }

    public void procesar() throws JSONException {
        
        try {
            File[] files = selectFiles();
            for (File f : files) {
                String json = readFile(path + "/json/" + f.getName());
                String xml = convert(json, "factura");
                writeFile(path + "/xml/" + f.getName().substring(0, f.getName().length() - 5) + ".xml", xml);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public String convert(String json, String root) throws JSONException {
        org.json.JSONObject jsonFileObject = new org.json.JSONObject(json);
        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<" + root + ">"
                + org.json.XML.toString(jsonFileObject) + "</" + root + ">";
        return xml;
    }

    public String readFile(String filepath) throws IOException {

        StringBuilder sb = new StringBuilder();
        InputStream in = new FileInputStream(filepath);
        Charset encoding = Charset.defaultCharset();

        Reader reader = new InputStreamReader(in, encoding);

        int r = 0;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            sb.append(ch);
        }

        in.close();
        reader.close();

        return sb.toString();
    }

    public void writeFile(String filepath, String output) throws IOException {
        FileWriter ofstream = new FileWriter(filepath);
        try (BufferedWriter out = new BufferedWriter(ofstream)) {
            out.write(output);
        }
    }

    public static File[] selectFiles() {
        File f = new File("./procesados/json");
        File[] matchingFiles = f.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("json");
            }
        });
        return matchingFiles;
    }

}
