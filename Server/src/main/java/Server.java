import com.google.gson.Gson;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            List<String> jsons = (List<String>) objectInputStream.readObject();
            ArrayList<User> users = new ArrayList<>();
            Gson gson = new Gson();
            for (String json : jsons) {
                User user = gson.fromJson(json, User.class);
                users.add(user);
            }
            CSVFileWriter.writeCSVFile(users, "users.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
