package com.nttdata.steps;

import com.nttdata.model.Order;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import org.junit.Assert;


public class MascotaStep {

    private String GET_ORDER = "https://petstore.swagger.io/v2";
    private String CREATE_STORE = "https://petstore.swagger.io/v2/store/order";
    private Order orderMascota;


    public void crearOrderPets(String id, String peId, String quantity, String shipDate, String status, String complete) {
        given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\":" + id + ",\n" +
                        "  \"petId\": " + peId + ",\n" +
                        "  \"quantity\":" + quantity + ",\n" +
                        "  \"shipDate\": \"" + shipDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": " + complete + "\n" +
                        "}")
                .log().all()
                .post(CREATE_STORE)
                .then()
                .log().all()
        ;
    }

    public void consultaOrderMascota(String id) {
        orderMascota = given()
                .baseUri(GET_ORDER)
                .log()
                .all()
                .when()
                .get("/store/order/" + id)
                // .then().log().all();
                .as(Order.class);

    }

    public void validoCodigoRespuesta(int codigo) {

        System.out.println("El codigo de Respuesta es : " + lastResponse().statusCode());
        assertThat(lastResponse().statusCode(), is(codigo));
    }
    public void validId(String Id) {

        System.out.println("El Id de Respuesta es :" + lastResponse().getBody().path("id"));
        assertThat(lastResponse().getBody().path("id"), equalTo(Integer.parseInt(Id)));
    }
    public void validpetId(String petId) {

        System.out.println("El  petId de Respuesta es :" + lastResponse().getBody().path("petId"));
        assertThat(lastResponse().getBody().path("petId"), equalTo(Integer.parseInt(petId)));
    }

    public void validQuantity(String quantity) {

        System.out.println("El quantity de Respuesta es :" + lastResponse().getBody().path("quantity"));
        assertThat(lastResponse().getBody().path("quantity"), equalTo(Integer.parseInt(quantity)));
    }

    public void validStatus(String status) {

        System.out.println("El status de Respuesta es :" + lastResponse().getBody().path("status"));
        assertThat(lastResponse().getBody().path("status"), equalTo(status));
    }
    public void validComplete(String complete) {

        System.out.println("El complete de Respuesta es :" + lastResponse().getBody().path("complete"));
        assertThat(lastResponse().getBody().path("complete"), equalTo(Boolean.parseBoolean(complete)));
    }
    public void validarBody(){

        System.out.println("El ID:"+ orderMascota.getId());
        System.out.println("El PetId: "+ orderMascota.getPetId());
        System.out.println("El Quantity: "+ orderMascota.getQuantity());
        System.out.println("El ShipDate: "+ orderMascota.getShipDate());
        System.out.println("El Status: "+ orderMascota.getStatus());
        System.out.println("El Complete: "+ orderMascota.isComplete());
    }
}
