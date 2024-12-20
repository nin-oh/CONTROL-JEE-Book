package org.xproce.book.service;


import org.xproce.book.dto.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO saveBook(BookDTO bookDTO);
    List<BookDTO> saveBooks(List<BookDTO> bookDTOS);
    List<BookDTO> getBookByTitle(String title);
}
