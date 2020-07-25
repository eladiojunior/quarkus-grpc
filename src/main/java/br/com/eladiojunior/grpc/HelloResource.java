package br.com.eladiojunior.grpc;

import io.quarkus.grpc.runtime.annotations.GrpcService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/ola")
public class HelloResource {

    @Inject
    @GrpcService("ola-service")
    private OlaServiceGrpc.OlaServiceBlockingStub olaService;

    @Inject
    @GrpcService("ola-service")
    private MutinyOlaServiceGrpc.MutinyOlaServiceStub olaServiceMutiny;

    @GET
    @Path("/block/{nome}")
    public String getBlock(@PathParam("nome") String nome) {
        OlaRequest request = OlaRequest.newBuilder().setNome(nome).build();
        OlaResponse response = olaService.digaOla(request);
        return "["+response.getQuantidadeRequests()+"] " + response.getMensagem();
    }

    @GET
    @Path("/reativo/{nome}")
    public Uni<String> getReativo(@PathParam("nome") String nome) {
        OlaRequest request = OlaRequest.newBuilder().setNome(nome).build();
        Uni<OlaResponse> response = olaServiceMutiny.digaOla(request);
        return response.onItem().apply(i -> "["+i.getQuantidadeRequests()+"] " + i.getMensagem());
    }
}