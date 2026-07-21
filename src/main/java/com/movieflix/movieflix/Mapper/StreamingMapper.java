package com.movieflix.movieflix.Mapper;

import com.movieflix.movieflix.Controller.request.StreamingRequest;
import com.movieflix.movieflix.Controller.response.StreamingResponse;
import com.movieflix.movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request){
        return Streaming.builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
