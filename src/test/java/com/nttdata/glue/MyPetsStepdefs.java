package com.nttdata.glue;

import com.nttdata.steps.MascotaStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MyPetsStepdefs {
    @Steps
    MascotaStep mascota;

    @Given("que estoy en el servicio de PETS")
    public void queEstoyEnElServicioDePETS() {
    }

    @When("hare un post para crear el order con los datos de id:{string},petId:{string}, quantity:{string},shipDate:{string},status:{string},complete:{string}")
    public void hareUnPostParaCrearElOrderConLosDatosDeIdPetIdQuantityShipDateStatusComplete(String id, String peId, String quantity, String shipDate, String status, String complete) {
        mascota.crearOrderPets(id, peId, quantity, shipDate, status, complete);
    }

    @Then("valido que el codigo de respuesta sea {int}")
    public void validoQueElCodigoDeRespuestaSea(int arg0) {
        mascota.validoCodigoRespuesta(arg0);
    }

    @When("consulto el order de un pet con id {string}")
    public void consultoElOrderDeUnPetConId(String id) {
        mascota.consultaOrderMascota(id);
    }

    @And("valido el body de respuesta con respecto al petId {string}")
    public void validoElBodyDeRespuestaConRespectoAlPetId(String arg0) {
        mascota.validpetId(arg0);

    }

    @And("valido el body de respuesta con respecto al id {string}")
    public void validoElBodyDeRespuestaConRespectoAlId(String arg0) {
        mascota.validId(arg0);
    }

    @And("valido el body de respuesta con respecto al quantity {string}")
    public void validoElBodyDeRespuestaConRespectoAlQuantity(String arg0) {
        mascota.validQuantity(arg0);
    }


    @And("valido el body de respuesta con respecto al status {string}")
    public void validoElBodyDeRespuestaConRespectoAlStatus(String arg0) {
        mascota.validStatus(arg0);
    }

    @And("valido el body de respuesta con respecto al complete {string}")
    public void validoElBodyDeRespuestaConRespectoAlComplete(String arg0) {
        mascota.validComplete(arg0);
    }

    @And("verifico el body de respuesta")
    public void verificoElBodyDeRespuesta() {
       mascota.validarBody();
    }
}
