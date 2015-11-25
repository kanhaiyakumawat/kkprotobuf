# kkprotobuf
This example project is to explore the Java RPC Server using Protocol Buffer (protobuf). 
Initially I am trying to create a Java RPC ProtoBuf Server and trying to connect it from Java RPC ProtoBuf Client. In later phase I would create a C++ Protocol Buffer Based Client to connect the same.

## Current Status of this repo
Currently its building fine and server is starting. But when I am trying to connect the server using the ProtoBuf client getting exception like
'''
Exception in thread "main" java.lang.UnsupportedOperationException: This is supposed to be overridden by subclasses.
	at com.google.protobuf.GeneratedMessage.getUnknownFields(GeneratedMessage.java:263)
	at com.googlecode.protobuf.socketrpc.SocketRpcProtos$Request.getSerializedSize(SocketRpcProtos.java:301)
	at com.google.protobuf.AbstractMessageLite.writeDelimitedTo(AbstractMessageLite.java:86)
	at com.googlecode.protobuf.socketrpc.SocketConnection.sendProtoMessage(SocketConnection.java:70)
	at com.googlecode.protobuf.socketrpc.RpcChannelImpl.sendRpcRequest(RpcChannelImpl.java:179)
	at com.googlecode.protobuf.socketrpc.RpcChannelImpl.callMethod(RpcChannelImpl.java:79)
	at com.kanhaiyakumawat.protobuf.generated.SumProtos$KKProtBufServ$Stub.getSum(SumProtos.java:1072)
	at com.kanhaiyakumawat.kkprotobuff.ProtoClient.main(ProtoClient.java:44)
'''
I will try to fix this asap.
