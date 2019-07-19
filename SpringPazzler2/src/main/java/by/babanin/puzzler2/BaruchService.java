package by.babanin.puzzler2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BaruchService {
    @Autowired
    @BaruchQualifier
    public List<String> list;

    @PostConstruct
    public void print() {
        System.out.println("----- BaruchService -----");
        list.forEach(System.out::println);
    }
}
