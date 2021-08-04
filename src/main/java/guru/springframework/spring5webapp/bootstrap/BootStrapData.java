package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author Amir = new Author("Amir", "Abedi");
        Book amirsBook = new Book("OCA Java SE 8", "1064");
        Amir.getBooks().add(amirsBook);
        amirsBook.getAuthors().add(Amir);

        authorRepository.save(Amir);
        bookRepository.save(amirsBook);

        Author Armin = new Author("Armin", "Noori");
        Book arminsBook = new Book("OCP Java SE 8", "1064");
        Armin.getBooks().add(arminsBook);
        arminsBook.getAuthors().add(Armin);

        authorRepository.save(Armin);
        bookRepository.save(arminsBook);

        System.out.println("Started In BootStrap");
        System.out.println("Number of Books : " + bookRepository.count());
    }
}
