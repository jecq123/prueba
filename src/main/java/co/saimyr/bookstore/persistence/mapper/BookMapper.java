package co.saimyr.bookstore.persistence.mapper;

import co.saimyr.bookstore.domain.BookDomain;
import co.saimyr.bookstore.domain.dto.BookDTO;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDomain bookEntityToDomain(BookEntity bookEntity);
    BookDTO bookDomainToDTO(BookDomain bookDomain);
    BookDomain bookDTOToDomain(BookDTO bookDTO);
    BookEntity bookDomainToEntity(BookDomain bookDomain);
    List<BookEntity> domainListToEntity(List<BookDomain> bookDomains);
    List<BookDomain> dtoListToDomain(List<BookDTO> bookDTOS);
    List<BookDomain> entityListToDomain(List<BookEntity> bookEntities);
    List<BookDTO> domainListToDTO(List<BookDomain> bookDomains);
}
