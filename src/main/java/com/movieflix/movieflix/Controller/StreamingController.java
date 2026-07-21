package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Controller.request.StreamingRequest;
import com.movieflix.movieflix.Controller.response.StreamingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(
        name = "Streaming",
        description = "Gerenciamento dos serviços de streaming dos filmes."
)
public interface StreamingController {


    @Operation(summary = "Listar serviços de streaming")
    ResponseEntity<List<StreamingResponse>> findAll();


    @Operation(summary = "Buscar streaming por ID")
    ResponseEntity<StreamingResponse> findById(Long id);


    @Operation(summary = "Criar serviço de streaming")
    ResponseEntity<StreamingResponse> createStreming(StreamingRequest request);


    @Operation(summary = "Excluir serviço de streaming")
    ResponseEntity<Void> deleteById(Long id);

}