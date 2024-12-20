package org.xproce.book.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.xproce.book.dao.entities.Book;
import org.xproce.book.dao.repository.BookRepository;
import org.xproce.book.dto.BookDTO;
import org.xproce.book.mapper.BookMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class BookManager implements BookService{
    private BookMapper bookMapper;
    private BookRepository bookRepository;
    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.fromBookDtoToBook(bookDTO);
       book=bookRepository.save(book);
      bookDTO=bookMapper.fromBookToBookDto(book);
      return bookDTO;
    }

    @Override
    public List<BookDTO> saveBooks(List<BookDTO> bookDTOS) {
        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOS) {
            books.add(bookMapper.fromBookDtoToBook(bookDTO));
        }

        books = bookRepository.saveAll(books);

        bookDTOS = new ArrayList<>();
        for (Book book : books) {
            bookDTOS.add(bookMapper.fromBookToBookDto(book));
        }
        return bookDTOS;
    }


    @Override
    public List<BookDTO> getBookByTitle(String title) {
        List<Book> books = bookRepository.findByTitre(title);

        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            bookDTOS.add(bookMapper.fromBookToBookDto(book));
        }
        return bookDTOS ;

}
}
