package jamshedpur.nit.culfest.com.culfest17.Util;

public class Celebrity {

    private  int imageId;
    private  String name;
    private  String date;
    private  String time;
    private  String venue;
    private  String description;
    private  String imageLink;

    public Celebrity(int imageId, String name, String date, String time, String venue, String description,String imageLink) {
        this.imageId = imageId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.description = description;
        this.imageLink=imageLink;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public String getImageLink() { return imageLink; }

    public String getDescription() {
        return description;
    }
}
