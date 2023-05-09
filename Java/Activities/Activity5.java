package activities;
    abstract class Book{
        String title;
        abstract void setTitle(String s);
        String getTitle() {
            return title;
        }
    }
    class MyBook extends Book {
        public void setTitle(String s) {
            title = s;
        }
    }
    public class Activity5 {
        public static void main(String[] args) {
            String title="Real Hero";
            Book book1=new MyBook();
            book1.setTitle(title);
            System.out.println("Title of the book is "+ book1.getTitle());
        }
}
