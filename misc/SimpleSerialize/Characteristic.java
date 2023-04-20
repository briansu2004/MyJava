public class Characteristic {
    private String name;
    private String value;
    private String addtionalField;

    public Characteristic(String name) {
        this.name = name;
    }

    public Characteristic(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Characteristic(String name, String value, String addtionalField) {
        this.name = name;
        this.value = value;
        this.addtionalField = addtionalField;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getAddtionalField() {
        return addtionalField;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setAddtionalField(String addtionalField) {
        this.addtionalField = addtionalField;
    }

    // @Override
    // public String toString() {
    // return "{'name': '" + name + "', 'value': '" + value + "'}";
    // }
    @Override
    public String toString() {
        return "{'name': '" + name + "', 'value': '" + value + "', 'addtionalField': '" + addtionalField + "'}";
    }
}
