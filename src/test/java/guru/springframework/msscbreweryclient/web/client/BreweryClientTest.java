package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().name("NEW BEER").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        log.info(uri + " <- uri");
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().name("UPDATED BEER").build();

        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customer = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("NEW CUSTOMER").build();

        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);
    }

    @Test
    void updateCustomerById() {
        CustomerDto customer = CustomerDto.builder().name("UPDATED CUSTOMER").build();

        client.updateCustomerById(UUID.randomUUID(), customer);
    }

    @Test
    void deleteCustomerById() {
        client.deleteCustomerById(UUID.randomUUID());
    }
}