package rusvslizards.server;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

@org.springframework.stereotype.Service
public class ServiceLizards extends russvslizards.server.ServiceGrpc.ServiceImplBase{

    @Override public void phrase(russvslizards.server.Request request, StreamObserver<russvslizards.server.Response> responseObserver) {
        try {
            responseObserver.onNext(responseToClient(request));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        responseObserver.onCompleted();
    }

    public russvslizards.server.Response responseToClient(russvslizards.server.Request request) throws InterruptedException {
        String target = "localhost:50051";
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        ClientToModel client = new ClientToModel(channel);
        russvslizards.server.Response response = client.sendRequestToModel(request);
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        return response;
    }
}
