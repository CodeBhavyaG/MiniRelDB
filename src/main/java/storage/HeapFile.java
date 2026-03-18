// We need: DiskManager dm;  Because HeapFile does NOT directly talk to disk — it uses DiskManager.

package storage;

import java.io.IOException;

public class HeapFile {
    
    private DiskManager diskManager;
    private int nextPageId;

    public HeapFile(DiskManager diskManager) {
        this.diskManager = diskManager;
        this.nextPageId = 0;
    }

    public void insertRecord(DBRecord record) throws IOException {

        // Create a new page for the record
        Page page = new Page(nextPageId);

        // Serialize the record (convert it to bytes)
        byte[] recordBytes = record.toBytes();

        // Copy record into page
        System.arraycopy(recordBytes, 0, page.getData(), 0, recordBytes.length);

        // Write page to disk
        diskManager.writePage(page);

        System.out.println("Inserted record into page " + nextPageId);

        // Move to next page
        nextPageId++;

    }
}


