package com.kanhaiyakumawat.kkprotobuff;

import com.googlecode.protobuf.socketrpc.RpcServer;
import com.googlecode.protobuf.socketrpc.ServerRpcConnectionFactory;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;
import java.util.concurrent.Executors;

public class ProtoServer
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ServerRpcConnectionFactory rpcConnectionFactory = SocketRpcConnectionFactories.createServerRpcConnectionFactory(4446);
        RpcServer server = new RpcServer(rpcConnectionFactory, Executors.newFixedThreadPool(5), true);
        server.registerService(new KKProtBufServImpl());
        server.run();
    }    
}
