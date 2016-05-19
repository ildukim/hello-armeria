package hello;

import com.linecorp.armeria.common.SerializationFormat;
import com.linecorp.armeria.common.SessionProtocol;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.server.thrift.ThriftService;

public class MyServer {
    public static void main(String[] args) {
        HelloService.AsyncIface helloHandler = new MyHelloService();

        ServerBuilder sb = new ServerBuilder();
        sb.port(9090, SessionProtocol.HTTP);
        sb.serviceAt(
                "/hello",
                ThriftService.of(helloHandler, SerializationFormat.THRIFT_BINARY)
                        .decorate(LoggingService::new)).build();

        Server server = sb.build();
        server.start();
    }
}
