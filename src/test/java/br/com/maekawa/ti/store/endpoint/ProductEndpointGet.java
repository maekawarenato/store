package br.com.maekawa.ti.store.endpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.given;
import static org.springframework.http.HttpStatus.OK;
gic
@RunWith(SpringRunner.class)
@Sql(scripts = "/sql/clean-all.sql")
@Sql(scripts = "/sql/inserts.sql")
public class ProductEndpointGet {
    private int port = 8080;

    @Test
    public void shouldReturnOkWhenGetProduct(){
        given().port(this.port)
                .contentType("application/vnd.resource+json;charset=utf-8")
                .get("/rs/pruduct")
                .then()
                .statusCode(OK.value());
    }
}
