package pojos;

public class GorestPojo {
    private Object meta;
    private GorestDataPojo data;  //onceden olusturdugumuz inner pojo nun data tipini kullandik

    public GorestPojo(Object meta, GorestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public GorestPojo() {
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GorestDataPojo getData() {
        return data;
    }

    public void setData(GorestDataPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GorestPojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
