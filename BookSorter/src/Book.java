public class Book implements Comparable<Book> {
    private String bookName;
    private String authorName;
    private int pageNumber;
    private int publishDate;

    public Book(String bookName,int pageNumber) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;

    }
    @Override
    public int compareTo(Book o) {
        return bookName.compareTo(o.bookName);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }



}
