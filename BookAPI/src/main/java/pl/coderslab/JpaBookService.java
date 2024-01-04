package pl.coderslab;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Primary
@Service
public class JpaBookService implements BookService{
    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBook(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);

    }
    @Override
    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}
