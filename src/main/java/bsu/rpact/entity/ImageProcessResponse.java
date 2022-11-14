package bsu.rpact.entity;

public class ImageProcessResponse {
    private byte[] img;

    public ImageProcessResponse(byte[] img) {
        this.img = img;
    }

    public ImageProcessResponse() {
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
