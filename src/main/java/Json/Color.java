package Json;

public class Color {
    private String color;
    private String value;

    public Color(String colorType, String value) {
        this.color = colorType;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Color{" +
                "colorType='" + color + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
