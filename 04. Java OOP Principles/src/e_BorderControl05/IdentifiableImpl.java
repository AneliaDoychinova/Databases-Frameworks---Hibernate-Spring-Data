package e_BorderControl05;

public abstract class IdentifiableImpl implements Identifiable {
    private String id;

    public IdentifiableImpl(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}