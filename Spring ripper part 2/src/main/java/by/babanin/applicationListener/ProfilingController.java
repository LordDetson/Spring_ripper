package by.babanin.applicationListener;

/*
ProfilingControllerMBean - интерфейс, который позволит
менять параметры класса ProfilingController на лету (в любое время)
с помощью JMX console.
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
