package lesson8;

import lesson8.Apps.ClientApp;
import lesson8.Apps.ServerApp;

/**
 * Java Core. Advanced level. Lesson 8
 *
 * @author Malkhaz Khubulovi
 * @version dated Mart 27, 2023
 */
//   Task
//    1. Разобраться с кодом.
//    2. Добавить отключение неавторизованных пользователей по таймауту
//    (120 сек. ждем после подключения клиента. Если он не авторизовался за это время, закрываем соединение).

public class Main {
    public static void main(String[] args) {
        new ClientApp();
        new ServerApp();
    }
}
