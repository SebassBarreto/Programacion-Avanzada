package avanzada.microservices.msjuguetes.Controller;

import avanzada.microservices.msjuguetes.Domain.JugueteResponse;
import avanzada.microservices.msjuguetes.Domain.JugueteDTO;
import avanzada.microservices.msjuguetes.Service.JugueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JugueteController {

    @Autowired
    private JugueteService servicios;

    public JugueteController(JugueteService js) {
        servicios = js;
    }

    @RequestMapping(value = "/buscarjuguete/{codigoJuguete}", method = RequestMethod.GET)
    public ResponseEntity<JugueteResponse> getJugueteDetalles(@PathVariable String codigoJuguete) {
        JugueteResponse juguete = servicios.getJugueteByCodigo(codigoJuguete);
        return ResponseEntity.status(HttpStatus.OK).body(juguete);
    }
    
    @RequestMapping(value = "/juguete", method = RequestMethod.GET)
    public JugueteDTO Juguete() {
        JugueteDTO juguete = new JugueteDTO("1","Bob el Constructor");
        return servicios.saveJuguete(juguete);
    }
}
