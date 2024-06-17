package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void RemoveWhenProductExist() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Ручка", 72);
        Product product2 = new Product(2, "Карандаш", 43);
        Product product3 = new Product(3, "Альбом", 258);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldThrowNotFoundException() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Ручка", 72);
        Product product2 = new Product(2, "Карандаш", 43);
        Product product3 = new Product(3, "Альбом", 258);
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.removeById(5)
        );
    }
}
