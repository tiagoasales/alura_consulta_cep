import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainSearchZipCode {
    /* Ceps: 70655032 | 71670220 | 71060275 */
    public static void main(String[] args) {

        try {
            Scanner readerInput = new Scanner(System.in);
            FileWriter writer = new FileWriter("zipcodes.json");

            String url = "https://viacep.com.br/ws/";

            System.out.println("Type a brazilian zipcode or \"exit\" to leave.");
            var searchedZipCode = readerInput.nextLine();

            if (!searchedZipCode.equalsIgnoreCase("exit"))
                writer.write("[");

            while (!searchedZipCode.equalsIgnoreCase("exit")) {

                url += searchedZipCode + "/json/";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    String json = response.body();
                    writer.write(json);
                    System.out.println("Zipcode successfully added!!!\n");
                    System.out.println("----------------------------------------------");
                } else {
                    System.out.println("Zipcode error!!!\n");
                    System.out.println("----------------------------------------------");
                }

                System.out.println("Type a brazilian zipcode, please:");
                searchedZipCode = readerInput.nextLine();

                if (!searchedZipCode.equalsIgnoreCase("exit")) {
                    if (response.statusCode() == 200)
                        writer.write(",\n");
                        
                    url = "https://viacep.com.br/ws/";
                }
            }

            writer.write("]");

            readerInput.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}