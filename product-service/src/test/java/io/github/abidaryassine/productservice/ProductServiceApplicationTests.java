package io.github.abidaryassine.productservice;

import io.github.abidaryassine.productservice.entity.ProductEntity;
import io.github.abidaryassine.productservice.repository.ProductRepository;
import io.github.abidaryassine.productservice.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Collections;

import static io.github.abidaryassine.productservice.util.TestUtils.getDto;
import static io.github.abidaryassine.productservice.util.TestUtils.getEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceApplicationTests {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;
    @Captor
    ArgumentCaptor<ProductEntity> productEntityArgumentCaptor;


    @Test
    public void shouldAddNewProductToDb() {
        // given
        final var productDto = getDto();
        given(productRepository.save(any(ProductEntity.class))).willReturn(getEntity());
        // when
        productServiceImpl.save(productDto);
        // then
        verify(productRepository, times(1)).save(productEntityArgumentCaptor.capture());
        final var productEntityArgumentCaptorValue = productEntityArgumentCaptor.getValue();
        assertEquals(productDto.libelle(), productEntityArgumentCaptorValue.getLibelle());
        assertEquals(productDto.description(), productEntityArgumentCaptorValue.getDescription());
        assertEquals(productDto.price(), productEntityArgumentCaptorValue.getPrice());
    }

    @Test
    public void shouldReturnSearchResult() {
        given(mongoTemplate.find(any(Query.class), any())).willReturn(Collections.singletonList(getEntity()));
        // when
        final var result = productServiceImpl.search("keyword");
        // then
        assertEquals(1, result.size());
    }

}
