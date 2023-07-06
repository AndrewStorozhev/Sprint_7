package actions;

import constants.PathAPI;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.Order;

import static io.restassured.RestAssured.given;


public class OrderClient extends BaseAPI {

    public OrderClient() {

    }

    @Step("Метод для шага Создать заказ")
    @Description("POST на ручку api/v1/orders")

    public Response createOrder(Order order) {
        return given(requestSpecification())
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(PathAPI.ORDER_BASE_URL);
    }

    @Step("Метод для шага Получить заказы")
    @Description("GET  на ручку api/v1/orders")

    public Response getOrder() {
        return given(requestSpecification())
                .get(PathAPI.ORDER_BASE_URL);
    }

}