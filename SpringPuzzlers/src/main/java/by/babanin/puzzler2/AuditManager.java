package by.babanin.puzzler2;

import org.springframework.stereotype.Component;

@Component
public class AuditManager {
    public void audit() {
        System.out.println("AuditManager.audit()");
    }
}
