package com.globallogic.Feign;

import com.globallogic.Entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface Service {
    @GetMapping("ratings/users/{id}")
    public List<Rating> getRatingsUsingfeign(@PathVariable String id);

}
