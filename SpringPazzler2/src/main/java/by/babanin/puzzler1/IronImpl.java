package by.babanin.puzzler1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IronImpl implements Iron {
    @Override
    public void heat() {
        System.out.println("разогревать...");
    }

    @Autowired
    public void heatWater(Water water) {
        System.out.println(water + " греть...");
    }
}
