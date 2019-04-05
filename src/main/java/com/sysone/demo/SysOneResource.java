package com.sysone.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.rest.dto.InDTO;
import web.rest.dto.OutDTO;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by C.CLAGOM on 4/5/2019.
 */
@RestController
@RequestMapping("/sysone")
public class SysOneResource {


    @RequestMapping(value = "/compress",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @GetMapping(value = "/compress")
    public ResponseEntity<OutDTO> compressString(@Valid @RequestBody InDTO inDTO) {
        OutDTO resultado = new OutDTO();

        List<String> list = convertStringToList(inDTO.getValue());

        StringBuffer stringbuffer = compress(list);

        resultado.setValue(inDTO.getValue());
        resultado.setCompressed(stringbuffer.toString());

        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    public StringBuffer compress(List<String> items) {
        String next = "";
        String previous = "";
        StringBuffer strinbuffer= new StringBuffer();
        long count = 0;
            ListIterator<String> listIterator = items.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.hasPrevious()) {
                    previous = listIterator.previous();
                }
                next = listIterator.next();
                if (next.equals(previous)){
                    count ++;
                }else{
                    strinbuffer.append(count+next);
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


    @RequestMapping(value = "/canditate",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @GetMapping(value = "/candidate")
    public ResponseEntity<OutDTO> candidate(@Valid @RequestBody InDTO inDTO) {
        OutDTO resultado = new OutDTO();
        resultado.setValue("Claudio Gomez Caballero");
        return ResponseEntity.ok(resultado);
    }

}



