package demo;

import com.abhinav.demo.proto_gen.ping_pong.PingPongServiceGrpc;
import com.abhinav.demo.proto_gen.ping_pong.Request;
import com.abhinav.demo.proto_gen.ping_pong.Response;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@Slf4j
@GRpcService
public class PingPongGrpcController extends PingPongServiceGrpc.PingPongServiceImplBase {
    @Override
    public void ping(Request request, StreamObserver<Response> responseObserver) {
        System.out.println("Payload Received : " + request.getPayload());
        Response response = Response.newBuilder().setMessage("Hey!").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}