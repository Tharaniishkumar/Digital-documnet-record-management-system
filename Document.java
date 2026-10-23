public class Document {
    private int id;
    private String title;
    private String author;
    private String date;


    public Document(int id, String title, String author, String date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    // Convert object to string (for file saving)
    public String toString() {
        return id + "," + title + "," + author + "," + date;
    }

    // Convert string to object (for file loading)
    public static Document fromString(String data) {
        String[] parts = data.split(",");
        return new Document(
            Integer.parseInt(parts[0]),
            parts[1],
            parts[2],
            parts[3]
        );
    }

    // Display document
    public void display() {
        System.out.println("\nID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Date: " + date);
        System.out.println("------------------------");
    }
}