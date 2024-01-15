package russvslizards.server;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: proto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChoiseGrpc {

  private ChoiseGrpc() {}

  public static final String SERVICE_NAME = "russvslizards.server.Choise";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<russvslizards.server.RequestV,
      russvslizards.server.ResponseV> getViborMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Vibor",
      requestType = russvslizards.server.RequestV.class,
      responseType = russvslizards.server.ResponseV.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<russvslizards.server.RequestV,
      russvslizards.server.ResponseV> getViborMethod() {
    io.grpc.MethodDescriptor<russvslizards.server.RequestV, russvslizards.server.ResponseV> getViborMethod;
    if ((getViborMethod = ChoiseGrpc.getViborMethod) == null) {
      synchronized (ChoiseGrpc.class) {
        if ((getViborMethod = ChoiseGrpc.getViborMethod) == null) {
          ChoiseGrpc.getViborMethod = getViborMethod =
              io.grpc.MethodDescriptor.<russvslizards.server.RequestV, russvslizards.server.ResponseV>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Vibor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  russvslizards.server.RequestV.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  russvslizards.server.ResponseV.getDefaultInstance()))
              .setSchemaDescriptor(new ChoiseMethodDescriptorSupplier("Vibor"))
              .build();
        }
      }
    }
    return getViborMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChoiseStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChoiseStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChoiseStub>() {
        @java.lang.Override
        public ChoiseStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChoiseStub(channel, callOptions);
        }
      };
    return ChoiseStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChoiseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChoiseBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChoiseBlockingStub>() {
        @java.lang.Override
        public ChoiseBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChoiseBlockingStub(channel, callOptions);
        }
      };
    return ChoiseBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChoiseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChoiseFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChoiseFutureStub>() {
        @java.lang.Override
        public ChoiseFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChoiseFutureStub(channel, callOptions);
        }
      };
    return ChoiseFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChoiseImplBase implements io.grpc.BindableService {

    /**
     */
    public void vibor(russvslizards.server.RequestV request,
        io.grpc.stub.StreamObserver<russvslizards.server.ResponseV> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getViborMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getViborMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                russvslizards.server.RequestV,
                russvslizards.server.ResponseV>(
                  this, METHODID_VIBOR)))
          .build();
    }
  }

  /**
   */
  public static final class ChoiseStub extends io.grpc.stub.AbstractAsyncStub<ChoiseStub> {
    private ChoiseStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChoiseStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChoiseStub(channel, callOptions);
    }

    /**
     */
    public void vibor(russvslizards.server.RequestV request,
        io.grpc.stub.StreamObserver<russvslizards.server.ResponseV> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getViborMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChoiseBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChoiseBlockingStub> {
    private ChoiseBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChoiseBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChoiseBlockingStub(channel, callOptions);
    }

    /**
     */
    public russvslizards.server.ResponseV vibor(russvslizards.server.RequestV request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getViborMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChoiseFutureStub extends io.grpc.stub.AbstractFutureStub<ChoiseFutureStub> {
    private ChoiseFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChoiseFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChoiseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<russvslizards.server.ResponseV> vibor(
        russvslizards.server.RequestV request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getViborMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VIBOR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChoiseImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChoiseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VIBOR:
          serviceImpl.vibor((russvslizards.server.RequestV) request,
              (io.grpc.stub.StreamObserver<russvslizards.server.ResponseV>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChoiseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChoiseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return russvslizards.server.Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Choise");
    }
  }

  private static final class ChoiseFileDescriptorSupplier
      extends ChoiseBaseDescriptorSupplier {
    ChoiseFileDescriptorSupplier() {}
  }

  private static final class ChoiseMethodDescriptorSupplier
      extends ChoiseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChoiseMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChoiseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChoiseFileDescriptorSupplier())
              .addMethod(getViborMethod())
              .build();
        }
      }
    }
    return result;
  }
}
