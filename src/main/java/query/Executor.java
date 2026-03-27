package query;

import storage.*;

public class Executor {

    private HeapFile heapFile;

    public Executor(HeapFile heapFile) {
        this.heapFile = heapFile;
    }

    public void executeInsert(InsertQuery query) throws Exception {

        // Convert query → DBRecord
        DBRecord record = new DBRecord(query.getId(), query.getName());

        // Insert into storage
        heapFile.insertRecord(record);
    }
}