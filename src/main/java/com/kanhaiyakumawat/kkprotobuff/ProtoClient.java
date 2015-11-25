package com.kanhaiyakumawat.kkprotobuff;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcChannel;
import com.google.protobuf.RpcController;
import com.googlecode.protobuf.socketrpc.RpcChannels;
import com.googlecode.protobuf.socketrpc.RpcConnectionFactory;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;
import com.googlecode.protobuf.socketrpc.SocketRpcController;
import com.kanhaiyakumawat.protobuf.generated.SumProtos;
//import com.kanhaiyakumawat.kkprotobuff.SumProtos.KKProtBufServ;
//import com.kanhaiyakumawat.kkprotobuff.SumProtos.SumResponse;
import com.kanhaiyakumawat.protobuf.generated.SumProtos.KKProtBufServ;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class ProtoClient
{
    public static void main(String[] args)
    {
        // Create a thread pool
        ExecutorService threadPool = Executors.newFixedThreadPool(1);


// Create channel
        String host = "127.0.0.1";
        int port = 4446;
        RpcConnectionFactory connectionFactory = 
        		SocketRpcConnectionFactories.createRpcConnectionFactory(host, port);
        RpcChannel channel = RpcChannels.newRpcChannel(connectionFactory, threadPool);


// Call service
        KKProtBufServ.Stub myService = KKProtBufServ.newStub(channel);
        RpcController controller = new SocketRpcController();
        SumProtos.SumRequest.Builder cr = SumProtos.SumRequest.newBuilder();
        
        cr.setParam1(100);
        cr.setParam2(100);
        
       myService.getSum(controller, cr.build(),
                           new RpcCallback<SumProtos.SumResponse>()
        {
            public void run(SumProtos.SumResponse myResponse)
            {
                System.out.println("Received Response: " + myResponse);
            }
        });
// Check success
       System.out.println("after call");
        if (controller.failed())
        {
            System.err.println(String.format("Rpc failed %s ", controller.errorText()));
        }
    }
}