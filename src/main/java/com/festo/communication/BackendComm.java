package com.festo.communication;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class BackendComm {
    
    static private HttpClient httpClient = HttpClient.newHttpClient();

    static String baseUri = "http://springschool-lb-54580289.eu-central-1.elb.amazonaws.com/api/";

    static public int moveRobot(String robot, Direction d) {
        try {
            String uri = baseUri + "bot/" + robot + "/move/" + d.toString().toLowerCase();
            System.out.println(uri);
            HttpRequest req = HttpRequest.newBuilder(new URI(uri)).PUT(BodyPublishers.noBody()).build();
            HttpResponse<String> res = httpClient.send(req, BodyHandlers.ofString());
            System.out.println("StatusCode: " + res.statusCode());
            return res.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 400;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return 400;
        }
    }

    static public int resetRobot(String robot) {
        try {
            String uri = baseUri + "james/" + robot + "/reset";
            System.out.println(uri);
            HttpRequest req = HttpRequest.newBuilder(new URI(uri)).PUT(BodyPublishers.noBody()).build();
            HttpResponse<String> res = httpClient.send(req, BodyHandlers.ofString());
            System.out.println("StatusCode: " + res.statusCode());
            return res.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 400;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return 400;
        }
    }
    
    static public int pickItem(String robot) {
        try {
            String uri = baseUri + "bot/" + robot + "/pick";
            System.out.println(uri);
            HttpRequest req = HttpRequest.newBuilder(new URI(uri)).PUT(BodyPublishers.noBody()).build();
            HttpResponse res = httpClient.send(req, BodyHandlers.ofString());
            System.out.println("StatusCode: " + res.statusCode());
            return res.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 400;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return 400;
        }
    }

    static public int dropItem(String robot) {
        try {
            String uri = baseUri + "bot/" + robot + "/place";
            System.out.println(uri);
            HttpRequest req = HttpRequest.newBuilder(new URI(uri)).PUT(BodyPublishers.noBody()).build();
            HttpResponse res = httpClient.send(req, BodyHandlers.ofString());
            System.out.println("StatusCode: " + res.statusCode());
            return res.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 400;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return 400;
        }
    }
    /*
     * Calls the "get info" for a robot. 
     * Only returns the status code.
     */
    static public int getInfo(String robot) {
        try {
            String uri = baseUri + "bot/" + robot;
            System.out.println(uri);
            HttpRequest req = HttpRequest.newBuilder(new URI(uri)).GET().build();
            HttpResponse<String> res = httpClient.send(req, BodyHandlers.ofString());
            System.out.println("StatusCode: " + res.statusCode());
            return res.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 400;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return 400;
        }
    }
}
