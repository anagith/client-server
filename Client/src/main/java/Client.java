import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<User> users = (ArrayList<User>) GenerateUser.generateUsersArray();
        try (Socket socket = new Socket("localhost", 8080)){
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(users);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
