import com.google.gson.Gson;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> jsons = getJsons();
        try (Socket socket = new Socket("localhost", 8080)) {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(jsons);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> getJsons() {
        ArrayList<User> users = (ArrayList<User>) GenerateUser.generateUsersArray();
        Gson gson = new Gson();
        ArrayList<String> jsons = new ArrayList<>();
        users.stream().forEach(each->jsons.add(gson.toJson(each)));
        return jsons;
    }
}
