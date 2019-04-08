package controller;

import controller.dto.candidate.CandidateOutDTO;
import controller.dto.compress.CompressInDTO;
import controller.dto.compress.CompressOutDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by C.CLAGOM on 4/5/2019.
 */
@RestController
public class SysOneController {


    @RequestMapping(value = "/compress",
            produces = {"application/json"},
            method = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping(path="/compress")
    public ResponseEntity<CompressOutDTO> compressString(@RequestParam ("value") String value) {
        CompressOutDTO resultado = null;
        CompressInDTO compressInDTO = new CompressInDTO();
        compressInDTO.setValue(value);
        if (!compressInDTO.getValue().isEmpty()) {
            resultado = new CompressOutDTO();
            List<String> list = convertStringToList(compressInDTO.getValue());
            StringBuffer stringbuffer = compress(list);
            resultado.setValue(compressInDTO.getValue());
            resultado.setCompressed(stringbuffer.toString());
        }

        if (resultado == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(resultado);
        }
    }


    public StringBuffer compress(List<String> items) {
        String prev = "";
        String next = "";
        StringBuffer strinbuffer= new StringBuffer();
        long count = 1;
        ListIterator<String> listIterator = items.listIterator();
        if (listIterator.hasNext()) {
            prev = listIterator.next();
            while (listIterator.hasNext()){
                next = listIterator.next();
                if (next.equals(prev)) {
                    count++;
                } else {
                    strinbuffer.append(count + prev);
                    count = 1;
                }
                prev = next;
                if (!listIterator.hasNext()) {
                    strinbuffer.append(count + prev);
                }
            }
        }
        return strinbuffer;
    }


    public List<String> convertStringToList(String value) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            list.add(String.valueOf(value.charAt(i)).toUpperCase());
        }
        return list;
    }


    @RequestMapping(value = "/candidate",
            produces = {"application/json"},
            method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping(path="/candidate")
    public ResponseEntity<CandidateOutDTO> candidate() {
        CandidateOutDTO resultado = new CandidateOutDTO();
        resultado.setValue("Claudio Gomez Caballero");
        return ResponseEntity.ok(resultado);
    }

}



