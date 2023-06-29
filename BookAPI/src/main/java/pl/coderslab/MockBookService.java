package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class MockBookService implements BookService {

    private static Long nextId = 4L;
    private List<Book> list;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }
    @Override
    public List<Book> allBooks(){
        return list;
    }
    @Override
    public Optional <Book> findBook(long id) {
     return list.stream().filter(e->e.getId().equals(id)).findFirst();
    }
    @Override
    public void add(Book book){
        book.setId(nextId);
        list.add(book);
        nextId += 1;
    }

    @Override
    public void update(Book book) {
        if(this.findBook(book.getId()).isPresent()){
            int index = list.indexOf(findBook(book.getId()).get());
            list.set(index,book);
        }
    }

    @Override
    public void delete(long id) {
        if(findBook(id).isPresent()){
            list.remove(findBook(id).get());
        }

    }
}
