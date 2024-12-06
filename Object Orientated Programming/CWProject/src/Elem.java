import java.util.ArrayList;

public abstract class Elem {
    private ArrayList<Attrib> attribs = new ArrayList<>();
    protected String content = "";

    public abstract String getTag();

    protected final Attrib newAttrib(String key, String val) {
        Attrib attrib = new Attrib(key, val);
        attribs.add(attrib);
        return attrib;
    }

    protected final Attrib newAttrib(String key) {
        return newAttrib(key, "");
    }

    public final void addContent(Elem e) {
        content += e.toString() + "\n";
    }

    public final void clearContent() {
        content = "";
    }

    protected void updateAttribs() {
        // Implementation in subclasses only
    }

    @Override
    public String toString() {
        updateAttribs();
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(getTag());
        for (Attrib attrib : attribs) {
            sb.append(" ").append(attrib.toString());
        }
        if (content.isEmpty()) {
            sb.append(" />");
        } else {
            sb.append(">").append(content).append("</").append(getTag()).append(">");
        }
        return sb.toString();
    }
}