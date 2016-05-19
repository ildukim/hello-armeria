package hello;

import com.linecorp.armeria.client.ClientBuilder;
import com.linecorp.armeria.client.Clients;
import com.linecorp.armeria.client.logging.LoggingClient;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {
    @Test
    public void testHello() {
        /*// client pattern 1
        HelloService.Iface helloService = Clients.newClient(
                "tjson+http://127.0.0.1:9090/hello",
                HelloService.Iface.class);*/

        // client pattern 2
        HelloService.Iface helloService = new ClientBuilder("tjson+http://127.0.0.1:9090/hello")
                .responseTimeoutMillis(10000)
                .decorator(LoggingClient::new)
                .build(HelloService.Iface.class);

        try {
            String greeting = helloService.hello("ildukim");
            assertEquals(greeting, "?");
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
