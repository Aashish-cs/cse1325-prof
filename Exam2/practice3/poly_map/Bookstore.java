import java.util.HashMap;
import java.util.Iterator;

import java.util.Objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

abstract class Book {
    public Book(String title, long isbn) {
        this.title = title;
        this.isbn = isbn;
    }
    public Book(BufferedReader br) throws IOException {
        this(br.readLine(), Long.parseLong(br.readLine()));
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(title + '\n');
        bw.write("" + isbn + '\n');
    }
    @Override
    public String toString() {
        return title + "(ISBN " + isbn + ", ";
    }
    protected String title;
    protected long isbn;
}


class Paperback extends Book {
    public Paperback(String title, long isbn, double weight) {
        super(title, isbn);
        this.weight = weight;
    }
    public Paperback(BufferedReader br) throws IOException{
        super(br);
        this.weight = Double.parseDouble(br.readLine());
    }
    @Override
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write("" + weight + '\n');
    }
    @Override
    public String toString() {
        return super.toString() + "paperback, " + weight + " kg)";
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;   
        if(o == null || o.getClass() != this.getClass()) return false; 
        Paperback pb = (Paperback) o;  
        return pb.title.equals(title)  
            && pb.isbn == isbn
            && pb.weight == weight;
    }
    @Override
    public int hashCode() { 
        return Objects.hash(title, isbn, weight); 
    }
    private double weight;
}

class eBook extends Book {
    public eBook(String title, long isbn, int kilobytes) {
        super(title, isbn);
        this.kilobytes = kilobytes;
    }
    public eBook(BufferedReader br) throws IOException {
        super(br);
        this.kilobytes = Integer.parseInt(br.readLine());
    }
    @Override
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write("" + kilobytes + '\n');
    }
    @Override
    public String toString() {
        return super.toString() + "digital, " + kilobytes + " kb)";
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        eBook eb = (eBook) o;
        return eb.title.equals(title)
            && eb.isbn == isbn
            && eb.kilobytes == kilobytes;
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, isbn, kilobytes);
    }
    private int kilobytes;
}

public class Bookstore {
    public Bookstore() { }
    public Bookstore(BufferedReader br) throws IOException {
        int pairs = Integer.parseInt(br.readLine());
        Book book;
        while(pairs-- > 0) {
            if(br.readLine().equals("eBook")) book = new eBook(br);
            else book = new Paperback(br);
            priceList.put(book, Double.parseDouble(br.readLine()));
        }
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + priceList.size() + '\n');
        for(Book book : priceList.keySet()) {
            bw.write(book.getClass().getName() + '\n');
            book.save(bw);
            bw.write("" + priceList.get(book) + '\n');
        }
    }
    public void addBook(Book book, double price) {
        priceList.put(book, price);
    }
    @Override
    public String toString() {  
        String catalog = "";
        Iterator<Book> it = priceList.keySet().iterator();
        while(it.hasNext()) {
            Book b = it.next();
            catalog += String.format("%-50s $%6.2f\n", b, priceList.get(b)); 
        }
        return catalog;
    }
    
    public static void main(String[] args) {
        Bookstore store1 = new Bookstore();
        store1.addBook(new Paperback("The Martian", 9780553418026L, 0.3), 8.99);
        store1.addBook(new eBook("The Martian", 9780553418026L,  3693), 7.99);
        System.out.println(store1);
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("test.books"))) {
            store1.save(bw);
        } catch(IOException e) {
            System.err.println("Failed to write test.books: " + e);
            System.exit(-1);
        }
        
        Bookstore store2 = null;
        try(BufferedReader br = new BufferedReader(new FileReader("test.books"))) {
            store2 = new Bookstore(br);
        } catch(IOException e) {
            System.err.println("Failed to read test.books: " + e);
            System.exit(-2);
        }
        System.out.println(store2);
    }
    private HashMap<Book, Double> priceList = new HashMap<>(); 
}


