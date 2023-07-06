package org.example;

import actions.OrderClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrdersTest {
    private final Order order;

    OrderClient orderClient = new OrderClient();

    public CreateOrdersTest(Order order) { // создали конструктор тестового класса
        this.order = order;
    }

    @Parameterized.Parameters
    public static Object[][] getTestDataForColor() {
        return new Object[][]{
                {new RandomOrders(new String[]{"BLACK"})},
                {new RandomOrders(new String[]{"GREY"})},
                {new RandomOrders(new String[]{"BLACK", "GREY"})},
                {new RandomOrders(null)},
        };
    }

    @Test
    @DisplayName("Проверяем код и тело ответа в случае валидного запроса")
    @Description("Ожидаемый результат: код 201, заказ создан, тело запроса содержит track")

    public void checkCreateValidOrder() {
        orderClient.createOrder(order)
                .then()
                .assertThat()
                .statusCode(201)
                .and()
                .body("track", notNullValue());
    }

}