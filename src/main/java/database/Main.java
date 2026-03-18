import storage.*;

public class Main {

    public static void main(String[] args) {

        try {
            DiskManager dm = new DiskManager("data/database.db");
            
            //  - Test Page (Phase 1)
            // Step 1: Create a page
            Page page = new Page(0);

            // Step 2: Put some data
            byte[] data = page.getData();
            String text = "Hello MiniRelDB!";
            byte[] textBytes = text.getBytes();

            System.arraycopy(textBytes, 0, data, 0, textBytes.length);

            // Step 3: Write to disk
            dm.writePage(page);
            System.out.println("Page written!");

            // Step 4: Read from disk
            Page readPage = dm.readPage(0);

            // Step 5: Convert bytes back to string
            String result = new String(readPage.getData()).trim();
            System.out.println("Read from DB: " + result);


            // 🔹 Test HeapFile (Phase 2)
            HeapFile heapFile = new HeapFile(dm);

            heapFile.insertRecord(new DBRecord(1, "Alice"));
            heapFile.insertRecord(new DBRecord(2, "Bob"));
            heapFile.insertRecord(new DBRecord(3, "Charlie"));                

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    
}