package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ShopRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopRepositoryTest {
    @Test
    public void testRemoveExistingProduct() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        shopRepository.add(product1);
        shopRepository.add(product2);

        shopRepository.removeById(1);

        Product[] actualProducts = shopRepository.findAll();
        Product[] expectedProducts = {product2};

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void testRemoveNonExistingProduct() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        shopRepository.add(product1);
        shopRepository.add(product2);

        assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(3);
        });
    }
}
