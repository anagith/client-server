import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            List<User> users = (List<User>) objectInputStream.readObject();
            CSVFileWriter.writeCSVFile(users, "users.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
