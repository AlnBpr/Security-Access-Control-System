package finalsystem.model;

public class Resource {
    private final String name;
    private final AccessScope scope;
    private String data;

    public Resource(String name, AccessScope scope, String data) {
        this.name = name;
        this.scope = scope;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public AccessScope getScope() {
        return scope;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Resource{name='" + name + "', scope=" + scope + "}";
    }
}