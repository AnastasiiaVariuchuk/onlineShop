package onlineShop.patterns.factory;

public class ServiceManagerFactory {
    public ServiceManager getServiceManager(String serviceManager) {
        if (serviceManager == null) {
            return null;
        }
        if (serviceManager.equalsIgnoreCase("Registration")) {
            return new RegistrationMethod();
        } else if (serviceManager.equalsIgnoreCase("SingUp")) {
            return new SingUpMethod();
        }
        return null;
    }
}
