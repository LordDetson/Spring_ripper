package by.babanin.puzzler3;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
Rollback произойдет на все методы, хотя можно было подумать, что только на методе infoBankManager.

Не происходит проксирование метода, который вызываеться в методе тогоже класса.

Решение - самовпрыскивание! (@SelfAutowired)


 */
@JokerConfTransactional
public class JokerConfService {
    /*
    Евгений Борисов — Spring – Глубоко и не очень
    JPoint 2017
    С версии 4.3 @Autowired работает также, как и @SelfAutowired
     */
    @SelfAutowired
    private JokerConfService proxy;

    public void transferMoney() {
        proxy.withdraw();
        proxy.deposit();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void withdraw() {

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deposit() {
        proxy.infoBankManager();
    }

    private void infoBankManager() {
        //генерит exception
    }
}
