package finalsystem.capability;

public class Capability<T> {
    private final String resourceName;

    public Capability(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public boolean appliesTo(String resourceName) {
        return this.resourceName.equals(resourceName);
    }

    @Override
    public String toString() {
        return "Capability{resourceName='" + resourceName + "'}";
    }
}
