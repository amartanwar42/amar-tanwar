package apiAutomation.entity.pet;

import apiAutomation.entity.BaseResponse;

public class CreatePetResponse extends BaseResponse {
    private String[] photoUrls;

    private String id;

    private String[] tags;

    private String status;

    public String[] getPhotoUrls ()
    {
        return photoUrls;
    }

    public void setPhotoUrls (String[] photoUrls)
    {
        this.photoUrls = photoUrls;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String[] getTags ()
    {
        return tags;
    }

    public void setTags (String[] tags)
    {
        this.tags = tags;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [photoUrls = "+photoUrls+", id = "+id+", tags = "+tags+", status = "+status+"]";
    }
}
