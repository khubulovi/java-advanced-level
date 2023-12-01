package lesson7;

import lesson6.Server;
import lesson7.Apps.ClientApp;

/**
 * Java Core. Advanced level. Lesson 7
 *
 * @author Malkhaz Khubulovi
 * @version dated Mart 27, 2023
 */


//   Task
//   1. Разобраться с кодом.
//   2. *Реализовать личные сообщения так: если клиент пишет «/w nick3 Привет», то только клиенту с ником nick3 должно прийти сообщение «Привет».

public class Main {
    public static void main(String[] args) {
        new ServerApp();
        new ClientApp();
    }

}
