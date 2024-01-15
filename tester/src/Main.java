import arduino.Arduino;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serial;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Arduino arduino = new Arduino("COM4", 9600);
        boolean connected = arduino.openConnection();
        System.out.println("Соединение установлено: " + connected);
        Thread.sleep(2000);

        while (arduino.openConnection()) {
            int flag = 0;
            if(arduino.serialRead(1).contains("left")) {
                flag = 1;
            }
            if(arduino.serialRead(1).contains("right")) {
                flag = 2;
            }

            switch (flag) {
                case 1 -> {
                    Runtime.getRuntime().exec("curl POST localhost:8080/RequestToRuss");
                }
                case 2 -> {
                    Runtime.getRuntime().exec("curl POST localhost:8080/RequestToLizards");
                }
                default -> {
                }
            }
        }
    }
}