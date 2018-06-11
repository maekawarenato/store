package br.com.maekawa.ti.store.endpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@Sql(scripts = "/sql/clean-all.sql")
@Sql(scripts = "/sql/inserts.sql")
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ProductEndpointGet {
    @LocalServerPort
    private int port;

    @Test
    public void shouldReturnFirstProducts(){
        given().port(this.port)
                .get("/rs/product")
                .then()
                .log().all()
                .statusCode(OK.value());
    }

    @Test
    public void shouldReturnOneProduct(){
        given().port(this.port)
                .get("/rs/product/1")
                .then()
                .log().all()
                .statusCode(OK.value());
    }
}



