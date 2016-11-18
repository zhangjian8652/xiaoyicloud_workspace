package url1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by zhangjian on 2016/11/3.
 */
public class TestURL {

    @Test
    public void test1() throws IOException {
        String urlName = "http://java.sun.com";

        //step 1. create a URL
        URL url = new URL(urlName);
        URLConnection connection = url.openConnection();

        //step 2. Connect to the server
        connection.connect();

        //print header fields;
        int n =1;
        String key;

        while ((key = connection.getHeaderFieldKey(n)) != null) {
            String value = connection.getHeaderField(n);
            System.out.println(key + ":" + value);

            n++;
        }

        //print convenience functions

        System.out.println("------------------");
        System.out.println("getContentType:" + connection.getContentType());
        System.out.println("getContentLength:" + connection.getContentLength());
        System.out.println("getContentEncoding:" + connection.getContentEncoding());
        System.out.println("getDate:" + connection.getDate());
        System.out.println("getExpiration:" + connection.getExpiration());
        System.out.println("getLastModified:" + connection.getLastModified());
        System.out.println("------------------");


        //step 3. and 4. Get an InputStream and encapsulate it

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        //print first ten lines of contents
        String line = null;
        n = 1;

        //step 5 Read info from the stream
        while ((line = br.readLine()) != null && n <= 10) {
            System.out.println(line);
            n++;
        }

        if(line != null){
            System.out.println("....");
        }

    }
}
