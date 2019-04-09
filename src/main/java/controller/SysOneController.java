package controller;

import service.SysOneService;
import com.sysone.demo.DemoApplication;
import controller.dto.candidate.CandidateOutDTO;
import controller.dto.compress.CompressOutDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by C.CLAGOM on 4/5/2019.
 */
@RestController
public class SysOneController {

    @Autowired
    private SysOneService sysOneService;

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @RequestMapping(value = "/compress",
            produces = {"application/json"},
            method = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping(path="/compress")
    public ResponseEntity<CompressOutDTO> compressString(@RequestParam ("value") String value) {
        logger.info("servicio /compress - inicio ejecucion");
        CompressOutDTO resultado = null;
        if (!value.isEmpty()) {
            resultado = new CompressOutDTO();
            List<String> list = sysOneService.convertStringToList(value);
            StringBuffer stringbuffer = sysOneService.compress(list);
            resultado.setValue(value);
            resultado.setCompressed(stringbuffer.toString());
        }
        if (resultado == null) {
            return ResponseEntity.noContent().build();
        } else {
            logger.info("servicio /compress - ejecucion exitosa");
            logger.info("servicio /compress - resultado: " + resultado.toString());
            return ResponseEntity.ok(resultado);
        }
    }


    @RequestMapping(value = "/candidate",
            produces = {"application/json"},
            method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping(path="/candidate")
    public ResponseEntity<CandidateOutDTO> candidate() {
        CandidateOutDTO resultado = new CandidateOutDTO();
        resultado.setValue("Claudio Gomez Caballero");
        logger.info("/candidate - ejecucion finalizada");
        return ResponseEntity.ok(resultado);
    }

}



