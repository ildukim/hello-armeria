package hello;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

// asynchronous
public class MyHelloService implements HelloService.AsyncIface {
    @Override
    public void hello(String name, AsyncMethodCallback resultHandler) throws TException {
        resultHandler.onComplete("Hello, " + name);
    }
}

// synchronous
//public class MyHelloService implements HelloService.Iface {
//    @Override
//    public String hello(String name) throws TException {
//        return "Hello, " + name + '!';
//    }
//}