package models;


public class Tip {
    private String writtenBy;
    private String content;
    private int rating;
    private int parkId;
    private int id;

    public Tip(String writtenBy, String content, int rating, int parkId) {
        this.writtenBy = writtenBy;
        this.content = content;
        this.rating = rating;
        this.parkId = parkId;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tip tip = (Tip) o;

        if (rating != tip.rating) return false;
        if (parkId != tip.parkId) return false;
        if (id != tip.id) return false;
        if (writtenBy != null ? !writtenBy.equals(tip.writtenBy) : tip.writtenBy != null) return false;
        return content != null ? content.equals(tip.content) : tip.content == null;
    }

    @Override
    public int hashCode() {
        int result = writtenBy != null ? writtenBy.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + parkId;
        result = 31 * result + id;
        return result;
    }
}
