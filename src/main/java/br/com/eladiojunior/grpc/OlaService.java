package br.com.eladiojunior.grpc;

import br.com.eladiojunior.grpc.OlaRequest;
import br.com.eladiojunior.grpc.OlaResponse;
import br.com.eladiojunior.grpc.OlaServiceGrpc;
import io.grpc.stub.StreamObserver;
import io.smallrye.mutiny.Uni;

import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
/*
public class OlaService extends OlaServiceGrpc.OlaServiceImplBase {
    private AtomicInteger count = new AtomicInteger();
    @Override
    public void digaOla(OlaRequest request, StreamObserver<OlaResponse> responseObserver) {
        String nome = request.getNome();
        responseObserver.onNext(OlaResponse.newBuilder()
                .setMensagem("Olá " + nome)
                .setQuantidadeRequests(count.getAndIncrement()+1).build());
        responseObserver.onCompleted();
    }

}
*/
public class OlaService extends MutinyOlaServiceGrpc.OlaServiceImplBase {
    private AtomicInteger count = new AtomicInteger();
    @Override
    public Uni<OlaResponse> digaOla(OlaRequest request) {
        OlaResponse response = OlaResponse.newBuilder()
                .setMensagem("[Mutiny] Olá " + request.getNome())
                .setQuantidadeRequests(count.getAndIncrement()+1).build();
        return Uni.createFrom().item(response);
    }
}