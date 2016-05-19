@echo off

thrift-0.9.2.exe --gen java --out hello-armeria-server/src/main/java hello.thrift
thrift-0.9.2.exe --gen js:node --out hello-armeria-client/gen-nodejs hello.thrift

pause
