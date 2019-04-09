package service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class SysOneService {

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
            }
        }
        return list;
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }
}
