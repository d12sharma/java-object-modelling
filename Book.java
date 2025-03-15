import java.util.ArrayList;


class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }
	
	
	 public static void main(String[] args) {
        
        Book b1 = new Book("Pride and Prejudice","Jane Austen");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b3 = new Book("1984", "Geroge Orwell");

        
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("Chitkara Library");

       
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        
        lib1.displayBooks();
        lib2.displayBooks();
    
}
}


class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("\nLibrary: " + name);
        for (int i = 0; i < books.size(); i++) {
            books.get(i).display();
        }
    }
}



   