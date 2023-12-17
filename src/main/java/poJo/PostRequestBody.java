package poJo;

import java.util.List;

public class PostRequestBody {
    private String name;
    private  String job;
    private List<String> languages;
    private List<CityRequest> cityRequestBody;

    public List<CityRequest> getCityRequestBody() {
        return cityRequestBody;
    }

    public void setCityRequestBody(List<CityRequest> cityRequestBody) {
        this.cityRequestBody = cityRequestBody;
    }
    private String updatedAt; // Add this field

    // Existing getters and setters...

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
