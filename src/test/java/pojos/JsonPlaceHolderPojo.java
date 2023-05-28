package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //actual datadan gelicek Id yi bu sekilde ignore ettik ki hata almayalim
public class JsonPlaceHolderPojo {
    //1: private variable lar olustururz
    private Integer userId;
    private String title;
    private Boolean completed;

//2: Parametreli ve Parametresiz constructor olustururuz
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
        //bos constructor i deSerialization yaparken kullanmak icin olusturuyoruz.
        // cunku parametreli constructor olusturduktan sonra default olan silinir. bu yuzden biz bos constructor olusturmak zorundayiz

    }

    //3 getter ve setter

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    //4: toString


    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
