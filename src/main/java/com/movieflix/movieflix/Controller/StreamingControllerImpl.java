package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Controller.request.StreamingRequest;
import com.movieflix.movieflix.Controller.response.StreamingResponse;
import com.movieflix.movieflix.Mapper.StreamingMapper;
import com.movieflix.movieflix.Service.StreamingService;
import com.movieflix.movieflix.entity.Streaming;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingControllerImpl implements StreamingController {


    private final StreamingService streamingService;



    //listar
    @GetMapping
      public ResponseEntity<List<StreamingResponse>> findAll(){
           List<StreamingResponse> stremings = streamingService.allStreaming()
                   .stream()
                   .map(StreamingMapper::toStreamingResponse)
                   .toList();
           return ResponseEntity.ok(stremings);



    }

    //listar por id
       @GetMapping("/{id}")
       public ResponseEntity<StreamingResponse> findById(@PathVariable Long id){
            return streamingService.findById(id)
                    .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                    .orElse(ResponseEntity.notFound().build());


       }

       //criar
    @PostMapping
    public ResponseEntity<StreamingResponse> createStreming(@Valid @RequestBody StreamingRequest request){
          Streaming newstreaming = StreamingMapper.toStreaming(request);
          Streaming saveStreming = streamingService.creatStreaming(newstreaming);
          return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(saveStreming));

      }




  //deletar por id
  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
          streamingService.deleteById(id);
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }





}
