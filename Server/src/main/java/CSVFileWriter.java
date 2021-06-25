import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileWriter {
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String[] FILE_HEADER = {"name", "surname", "phone", "email", "address", "age"};

    public static void writeCSVFile(List<User> users, String fileName) {
        FileWriter fileWriter = null;
        CSVPrinter csvFilePrinter = null;
        try {
            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
            fileWriter = new FileWriter(fileName);
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
            csvFilePrinter.printRecord(FILE_HEADER);
            for (int i = 0; i < users.size(); i++) {
                List<String> list = new ArrayList<>();
                list.add(users.get(i).getName());
                list.add(users.get(i).getSurname());
                list.add(users.get(i).getPhone());
                list.add(users.get(i).getEmail());
                list.add(users.get(i).getAddress());
                list.add(users.get(i).getAge());
                csvFilePrinter.printRecord(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }
    }
}
