package dalton.gray.personalphoto;

public class Friend {
    private String firstName;
    private Integer photoResource;

    public Friend(String name, Integer photo) {
        firstName = name;
        photoResource = photo;
    }

    public String getFirstName(){
        return firstName;
    }

    public Integer getPhotoResource() {
        return photoResource;
    }
}
