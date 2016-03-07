package com.firefly.rxnetty;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.RxNetty;
import io.reactivex.netty.protocol.http.client.HttpClientResponse;
import io.reactivex.netty.protocol.http.server.HttpServer;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import rx.Observable;
import rx.functions.Action1;

/**
 * 类RxNettyTest.java的实现描述：rx netty test case，虽然我也不知道这货做什么的
 * 
 * @author walter 2016年3月4日 上午12:44:28
 */
public class RxNettyTest {

    public static void main(String[] args) {
        RxNettyTest test = new RxNettyTest();
        HttpServer<ByteBuf, ByteBuf> server = test.createServer().start();
        RxNetty.createHttpGet("http://localhost:8080/").toBlocking().forEach(new Action1<HttpClientResponse<ByteBuf>>() {

            @Override
            public void call(HttpClientResponse<ByteBuf> t1) {
                System.out.println(t1.getContent());
                System.out.println(t1.getStatus() + "=============");

            }
        });
        try {
            server.shutdown();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 创建不知道啥玩意的服务
     */
    public HttpServer<ByteBuf, ByteBuf> createServer() {

        HttpServer<ByteBuf, ByteBuf> server = RxNetty.createHttpServer(8080, new RequestHandler<ByteBuf, ByteBuf>() {

            @Override
            public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
                System.out.println("Server===>request:" + request.getUri());
                try {
                    if (request.getUri().matches("^.*/error.*")) {
                        throw new RuntimeException("forced error!");
                    }

                    if (request.getUri().matches("^.*/data.*")) {
                        response.writeString("data test!");
                    }
                    response.setStatus(HttpResponseStatus.OK);
                } catch (Exception e) {
                    System.err.println("Server => Error [" + request.getPath() + "] => " + e);
                    response.setStatus(HttpResponseStatus.BAD_REQUEST);
                    response.writeString("Error 500!");

                }
                return response.close();
            }
        });
        return server;
    }

}
