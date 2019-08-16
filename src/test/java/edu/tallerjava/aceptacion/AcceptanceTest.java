package edu.tallerjava.aceptacion;

import edu.tallerjava.modelo.Category;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AcceptanceTest {

    @LocalServerPort
    private int port;
    protected String url;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Before
    public void init(){
        url = "http://localhost:" + port;
    }

    /**
     * Permite obtener como respuesta de un get un List tipado
     * @param uri path del servicio
     * @param responseType un wrapper de una lista parametrizada
     * @param <T> el tipo de datos de los objetos de la lista resultado
     * @return Una lista de objetos del tipo T
     */
    protected <T> List<T> getForObject(String uri, ParameterizedTypeReference<List<T>> responseType) {
        return restTemplate.exchange(uri, HttpMethod.GET, null, responseType).getBody();
    }


}
