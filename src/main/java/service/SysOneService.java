package service;

import com.sysone.demo.DemoApplication;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

@Service
public class SysOneService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DemoApplication.class);

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
            if (!isNumeric(String.valueOf(value.charAt(i)))){
                list.add(String.valueOf(value.charAt(i)).toUpperCase());
            } else {
                logger.debug("numeros no! ("+String.valueOf(value.charAt(i)+")"));
            }
        }
        return list;
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }
}
