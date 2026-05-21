package avanzada.microservices.msfabricantes.Controller;

import avanzada.microservices.msfabricantes.Service.FabricanteService;
import avanzada.microservices.msfabricantes.Model.FabricanteResponse;
import avanzada.microservices.msfabricantes.Model.FabricanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FabricanteController {

    @Autowired
    private FabricanteService servicios;

    public FabricanteController(FabricanteService js) {
        servicios = js;
    }
    
    @RequestMapping(value = "/fabricante", method = RequestMethod.GET)
    public FabricanteDTO saveFabricante() {
        FabricanteDTO fabricante = new FabricanteDTO("1","Mattel","1");
        return servicios.saveFabricante(fabricante);
    }

    @RequestMapping(value = "/buscarfabricante/{codigoJuguete}", method = RequestMethod.GET)
    public ResponseEntity<FabricanteResponse> getFabricanteByjugueteCodigo(@PathVariable String codigoJuguete) {
        FabricanteResponse fabricante = servicios.findFabricanteByJugueteCodigo(codigoJuguete);
        return ResponseEntity.status(HttpStatus.OK).body(fabricante);

    }
}