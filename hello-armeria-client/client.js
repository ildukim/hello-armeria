
var thrift = require('thrift');
var HelloService = require('./gen-nodejs/HelloService');

var options = {
  transport:  thrift.TBufferedTransport,
  protocol: thrift.TBinaryProtocol,
  path: '/hello',
  headers: {'Connection': 'Close'}
};

var connection = thrift.createHttpConnection('127.0.0.1', 9090, options);
var client = thrift.createHttpClient(HelloService, connection);

client.hello("nodejs", (err, greeting) => {
  console.log(greeting);
});