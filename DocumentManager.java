import java.io.*;
import java.util.*;

public class DocumentManager {

    private List<Document> documents;
    private final String FILE_NAME = "documents.txt";

    // Constructor
    public DocumentManager() {
        documents = new ArrayList<>();
        loadFromFile();
    }

    // Add document
    public void addDocument(Document doc) {
        documents.add(doc);
        saveToFile();
    }

    // View all documents
    public void viewDocuments() {
        if (documents.isEmpty()) {
            System.out.println("No documents found.");
            return;
        }

        for (Document doc : documents) {
            doc.display();
        }
    }

    // Search document
    public void searchDocument(int id) {
        for (Document doc : documents) {
            if (doc.getId() == id) {
                doc.display();
                return;
            }
        }
        System.out.println("Document not found.");
    }

    // Delete document
    public void deleteDocument(int id) {
        boolean removed = documents.removeIf(doc -> doc.getId() == id);

        if (removed) {
            System.out.println("Document deleted.");
        } else {
            System.out.println("Document not found.");
        }

        saveToFile();
    }

    // Save to file
    private void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Document doc : documents) {
                writer.write(doc.toString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    // Load from file
    private void loadFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = reader.readLine()) != null) {
                documents.add(Document.fromString(line));
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("No previous records found.");
        }
    }
}