public class MyObj {
    private String province;

    public MyObj(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "MyObj [province=" + province + "]";
    }
}
