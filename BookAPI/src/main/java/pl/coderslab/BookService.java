package pl.coderslab;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> allBooks();
    public Optional <Book> findBook(long id);
    public void add(Book book);
    public void update(Book book);
    public void delete(long id);
}
