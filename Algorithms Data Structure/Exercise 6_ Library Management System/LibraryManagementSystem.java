import java.util.Arrays;
import java.util.Scanner;

class Book {
    int bookid;
    String title;
    String author;

    public Book(int id, String title, String auth) {
        this.bookid = id;
        this.title = title;
        this.author = auth;
    }

    public int getbookID() {
        return bookid;
    }

    public String getTitle() {
        return title;
    }

    public String getAuth() {
        return author;
    }

    @Override
    public String toString() {
        return "[Book id=" + bookid + ", Title=" + title + ", Author=" + author + "]";
    }
}

class LinearSearch {
    public static Book linearsearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }
}

class BinarySearch {
    public static Book binarysearch(int low, int high, Book[] books, String targetTitle) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}

public class libraryMNGMNTSystem {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "1984", "George Orwell"),
            new Book(3, "To Kill a Mockingbird", "Harper Lee"),
            new Book(4, "The Catcher in the Rye", "J.D. Salinger")
        };

        System.out.println("Initial Book List:");
        for (Book book : books) {
            System.out.println(book);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title to search:");
        String targetTitle = scanner.nextLine();

        // Linear Search
        Book result1 = LinearSearch.linearsearch(books, targetTitle);
        System.out.println("Linear Search Result:");
        System.out.println(result1 != null ? result1 : "Book not found");

        // Sorting books for Binary Search
        Arrays.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));

        // Binary Search
        Book result2 = BinarySearch.binarysearch(0, books.length - 1, books, targetTitle);
        System.out.println("Binary Search Result:");
        System.out.println(result2 != null ? result2 : "Book not found");

        scanner.close();
    }
}
