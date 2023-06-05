import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", 430);
        Book book2 =new Book("The Da Vinci Code", 500);
        Book book3 = new Book("The Hobbit", 350);
        Book book4 = new Book("The Little Prince", 250);
        Book book5 =   new Book("The Hunger Games", 370);
        TreeSet<Book> bookName = new TreeSet<>();
        bookName.add(book1);
        bookName.add(book2);
        bookName.add(book3);
        bookName.add(book4);
        bookName.add(book5);
        for (Book order : bookName){
            System.out.println(order.getBookName());
        }

        System.out.println("Books Sorted By Page Number");
        TreeSet<Book> bookPage = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber() - o2.getPageNumber();
            }
        });

        bookPage.add(book1);
        bookPage.add(book2);
        bookPage.add(book3);
        bookPage.add(book4);
        bookPage.add(book5);

        for (Book order : bookPage){
            System.out.println(order.getBookName() + " : " + order.getPageNumber());
        }






}}