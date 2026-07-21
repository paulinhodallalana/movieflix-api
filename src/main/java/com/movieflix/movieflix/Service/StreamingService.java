package com.movieflix.movieflix.Service;

import com.movieflix.movieflix.Repository.StreamingRepository;
import com.movieflix.movieflix.entity.Streaming;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StreamingService {

    public final StreamingRepository repository;

   //listar

    public List<Streaming> allStreaming(){
        return repository.findAll();
    }

    //procurar por id
    public Optional<Streaming> findById(Long id){
        return repository.findById(id);
    }



    //criar
    public Streaming creatStreaming(Streaming streaming){
        return repository.save(streaming);
    }

    //deletar
    public void deleteById(Long id){
         repository.deleteById(id);
    }





}
