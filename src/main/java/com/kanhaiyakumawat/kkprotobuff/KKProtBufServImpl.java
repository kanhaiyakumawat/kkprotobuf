package com.kanhaiyakumawat.kkprotobuff;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.kanhaiyakumawat.protobuf.generated.SumProtos.KKProtBufServ;
import com.kanhaiyakumawat.protobuf.generated.SumProtos.SumRequest;
import com.kanhaiyakumawat.protobuf.generated.SumProtos.SumResponse;


public class KKProtBufServImpl extends KKProtBufServ {

	@Override
	public void getSum(RpcController controller, SumRequest request, RpcCallback<SumResponse> done) {
		SumResponse response = null;
		
		response = SumResponse.newBuilder().setSum(request.getParam1() + request.getParam2()).build();
		done.run(response);

	}

}
