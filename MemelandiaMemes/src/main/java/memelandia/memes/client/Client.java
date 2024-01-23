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
public class Client {

    @Autowired
    private HWUsuario hwUsuario;

    @Autowired
    private HWCategoria hwCategoria;

    @FeignClient(name = "memelandiaUsuario", path = "/usuario")
    interface HWUsuario {

        @GetMapping("/{id}")
        Optional<Object> findById(@PathVariable String id);
    }

    @FeignClient(name = "memelandiaCategoria", path = "/categoria")
    interface HWCategoria {

        @GetMapping("/{id}")
        Optional<Object> findById(@PathVariable String id);
    }
    public Boolean FindByIdCategoria(String id){
        return !hwCategoria.findById(id).isEmpty();
    }

    public Boolean FindByIdUsuario(String id){
        return !hwUsuario.findById(id).isEmpty();
    }
}
