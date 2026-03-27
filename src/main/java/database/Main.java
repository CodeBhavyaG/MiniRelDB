import storage.*;
import query.*;

public class Main {

    public static void main(String[] args) {

        try {
            DiskManager dm = new DiskManager("data/database.db");
            HeapFile heapFile = new HeapFile(dm);

            Executor executor = new Executor(heapFile);


            
            // Simulating INSERT query
            executor.executeInsert(new InsertQuery(1, "Alice Smith"));
            executor.executeInsert(new InsertQuery(2, "Bob Johnson"));
            executor.executeInsert(new InsertQuery(3, "Charlie Brown"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}