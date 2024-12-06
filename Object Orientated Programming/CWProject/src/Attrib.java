public class Attrib {
    private String key;
    private String val;

    // Constructor to initialize key and value
    public Attrib(String key, String val) {
        this.key = key;
        this.val = val;
    }

    // Convert to string in form key="val"
    @Override
    public String toString() {
        return key + "=\"" + val + "\"";
    }
}