package rusvslizards.server;
import io.grpc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {
    String Phrase;
    String flag;

    @GetMapping(value="/home")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/RequestToRuss", method = RequestMethod.GET)
    public String RequestToRuss() throws IOException, InterruptedException {
        String targer = "localhost:9090";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(targer).usePlaintext().build();
        russvslizards.server.ServiceGrpc.ServiceBlockingStub stub = russvslizards.server.ServiceGrpc.newBlockingStub(channel);
        russvslizards.server.Request request = russvslizards.server.Request.newBuilder().build();
        russvslizards.server.Response response = stub.phrase(request);
        System.out.println(response.getPhrase());
        this.Phrase = response.getPhrase();
        this.flag =  "1";
        return "redirect:/send";
    }

    @RequestMapping("/send")
    public ResponseEntity<String> sendLizs() {
        System.out.println("test");
        return ResponseEntity.ok(this.Phrase + "," + this.flag);
    }

    @RequestMapping(value = "/RequestToLizards", method = RequestMethod.GET)
    public String RequestToLizards() throws IOException, InterruptedException {
        String targer = "localhost:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(targer).usePlaintext().build();
        russvslizards.server.ServiceGrpc.ServiceBlockingStub stub = russvslizards.server.ServiceGrpc.newBlockingStub(channel);
        russvslizards.server.Request request = russvslizards.server.Request.newBuilder().build();
        russvslizards.server.Response response = stub.phrase(request);
        System.out.println(response.getPhrase());
        this.Phrase = response.getPhrase();
        this.flag = "0";
        return "redirect:/send";
    }
}
