package fountainOfObjects;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import java.net.URI;

public class DadJoke{
	public String getDadJoke(){
		HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://icanhazdadjoke.com/"))
		.header("Accept", "text/plain") 
		//.header("User-Agent:", "My Library(https://github.com/Lailaismyname/playersguide)")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
	HttpResponse<String> response = null;
	try{
		response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	} catch (IOException err) {
		err.printStackTrace();
	} catch(InterruptedException err){
		err.printStackTrace();
	}
	return response.body();
	}
}