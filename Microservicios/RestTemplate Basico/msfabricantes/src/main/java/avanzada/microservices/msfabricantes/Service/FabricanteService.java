package avanzada.microservices.msfabricantes.Service;

import avanzada.microservices.msfabricantes.Repository.FabricanteRepository;
import avanzada.microservices.msfabricantes.Model.FabricanteResponse;
import avanzada.microservices.msfabricantes.Model.FabricanteDTO;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
public class FabricanteService {

    @Autowired
    private FabricanteRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    public FabricanteResponse findFabricanteByJugueteCodigo(String codigoJuguete) {
        Optional<FabricanteDTO> fabricanteByjugueteCodigo
                = repositorio.findFabricanteByJugueteCodigo(codigoJuguete);
        FabricanteResponse addressResponse
                = mapper.map(fabricanteByjugueteCodigo, FabricanteResponse.class);
        return addressResponse;
    }

    @CrossOrigin
    public FabricanteDTO saveFabricante(FabricanteDTO fabricante) {
        return repositorio.save(fabricante);
    }

    @CrossOrigin
    public ResponseEntity<FabricanteDTO> saveUnFabricante(FabricanteDTO fabricante) {
        repositorio.save(fabricante);
        //se retorna el juguete guardada
        return ResponseEntity.ok(fabricante);
    }

    @CrossOrigin
    public List<FabricanteDTO> getAllFabricantes() {
        return repositorio.findAll();
    }
}
