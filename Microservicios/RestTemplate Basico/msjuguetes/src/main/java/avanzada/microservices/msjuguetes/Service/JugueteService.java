package avanzada.microservices.msjuguetes.Service;

import avanzada.microservices.msjuguetes.Domain.JugueteResponse;
import avanzada.microservices.msjuguetes.Domain.JugueteDTO;
import avanzada.microservices.msjuguetes.Domain.FabricanteResponse;
import avanzada.microservices.msjuguetes.Repository.JugueteRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@Component
public class JugueteService {

    @Autowired
    //permite describir que esta variable se va a inyectar a jugueteService
    private JugueteRepository repositorio;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RestTemplate restTemplate;

    public JugueteService(JugueteRepository jr){
    repositorio=jr;
    }
    
    public JugueteResponse getJugueteByCodigo(String codigoJuguete) {
        JugueteDTO juguete = repositorio.findByCodigo(codigoJuguete);
        JugueteResponse jugueteResponse = mapper.map(juguete, 
                JugueteResponse.class);
        
        FabricanteResponse fabricanteResponse =restTemplate.getForObject(
                "http://localhost:8091/fabricante/buscarfabricante/{codigo}",
                FabricanteResponse.class, codigoJuguete);
        jugueteResponse.setFabricanteResponse(fabricanteResponse);
        return jugueteResponse;
    }
    
    @CrossOrigin
    public JugueteDTO saveJuguete(JugueteDTO juguete) {
        return repositorio.save(juguete);
    }

    @CrossOrigin
    public ResponseEntity<JugueteDTO> saveUnJuguete(JugueteDTO juguete) {
        repositorio.save(juguete);
        //se retorna el juguete guardada
        return ResponseEntity.ok(juguete);
    }

    @CrossOrigin
    public List<JugueteDTO> getAllJuguetes() {
        return repositorio.findAll();
    }
}