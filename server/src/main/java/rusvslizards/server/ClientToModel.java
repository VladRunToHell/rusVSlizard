package rusvslizards.server;

import ch.qos.logback.core.net.server.Client;
import io.grpc.Channel;

public class ClientToModel {

    private russvslizards.server.ServiceGrpc.ServiceBlockingStub blockingStub;

    public ClientToModel(Channel channel) { blockingStub = russvslizards.server.ServiceGrpc.newBlockingStub(channel); }

    public russvslizards.server.Response sendRequestToModel(russvslizards.server.Request request) {
        russvslizards.server.Request requestToModel = russvslizards.server.Request.newBuilder().build();
        russvslizards.server.Response response;
        response = blockingStub.phrase(requestToModel);
        return response;
    }
}
