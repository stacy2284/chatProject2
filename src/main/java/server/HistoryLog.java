package server;

import java.io.*;
import java.security.PublicKey;

/**
 * Created by Java_1 on 01.08.2019.
 */
public class HistoryLog {
    private File path;
    private BufferedWriter out;
    private BufferedReader in;
    public HistoryLog() throws IOException {
        path = new File("target", "history.txt");
        path.createNewFile();
        out = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        path), 450)));
        in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(
                                        path))));
    }
    public void log(String message){
        try {
            out.write(message);
            out.newLine();
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHistory(){
        try {
            StringBuffer history = new StringBuffer("");
            String line = in.readLine();
            while(line != null){
               history.append(line+ System.lineSeparator());
               line = in.readLine();
            }
            return history.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void closeFile() throws IOException {
        out.close();
        in.close();

    }

}