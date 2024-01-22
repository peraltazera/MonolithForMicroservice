package memelandia.memes.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class Categoria {

    @Autowired
    private HWCategoria hwCategoria;

    @FeignClient(name = "memelandiaCategoria", path = "/categoria")
    interface HWCategoria {

        @GetMapping("/{id}")
        Optional<Object> findById(@PathVariable String id);
    }

    public Boolean FindById(String id){
        return !hwCategoria.findById(id).isEmpty();
    }
}
