package org.example;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Main{
    public static void main(String[] args){
        String url="http://universities.hipolabs.com/search?name=bahce";
        try(CloseableHttpClient client=HttpClients.createDefault()){
            HttpGet request=new HttpGet(url);
            String jsonResponse=client.execute(request, httpResponse ->
                    EntityUtils.toString(httpResponse.getEntity()));
            System.out.println("Response from Restful service:");
            System.out.println(jsonResponse);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}