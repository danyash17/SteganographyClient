package bsu.rpact.entity;

public class ImageProcessRequest {
    private byte[] arr;
    private int bitLayer;
    private String rgb;
    private String text;

    public ImageProcessRequest(byte[] arr, int bitLayer, String rgb, String text) {
        this.arr = arr;
        this.bitLayer = bitLayer;
        this.rgb = rgb;
        this.text = text;
    }

    public ImageProcessRequest() {
    }

    public byte[] getArr() {
        return arr;
    }

    public void setArr(byte[] arr) {
        this.arr = arr;
    }

    public int getBitLayer() {
        return bitLayer;
    }

    public void setBitLayer(int bitLayer) {
        this.bitLayer = bitLayer;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
