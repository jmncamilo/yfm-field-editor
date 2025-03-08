package models;

public class ConvertValues {
    public static byte convertIncrease(String fieldValue) {
        return (byte) (Integer.parseInt(fieldValue) / 10);
    }

    public static byte convertDecrease(String fieldValue) {
        return (byte) (Integer.parseInt(fieldValue) / -10);
    }
}
