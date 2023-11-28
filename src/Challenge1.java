import java.util.Arrays;
import java.util.Scanner;

public class Challenge1
{
    public enum Measurement
    {
        METERS(1f, "m"),
        CENTIMETERS(0.01f, "cm"),
        MILLIMETERS(0.001f, "mm");

        final float conversion;
        final String name;

        Measurement(float conversion, String name)
        {
            this.conversion = conversion;
            this.name = name;
        }
    }

    public static float calculateSurface(float a, float b)
    {
        return a * b;
    }

    public static String getData(String data, boolean numeric)
    {
        if (numeric) return (!data.replaceAll("[^0-9.]", "").isEmpty()) ? data.replaceAll("[^0-9.]", "") : null;
        else return (!data.replaceAll("[0-9. ]", "").isEmpty()) ? data.replaceAll("[0-9. ]", "") : null;
    }

    public static Measurement getMeasurement(String measurement)
    {
        for (Measurement measure : Measurement.values())
        {
            if (measurement.equals(measure.name)) return measure;
        }

        return null;
    }

    public static boolean checkData(String value, String measure, Measurement measurement)
    {
        return value != null && measure != null && measurement != null;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length:");
        String length = scanner.nextLine();
        System.out.println("Enter width:");
        String width = scanner.nextLine();

        System.out.println("length: " + length + " and width: " + width);

        String lValue = getData(length, true);
        String lMeasurement = getData(length, false);
        Measurement lMeasure = getMeasurement(lMeasurement);

        String wValue = getData(width, true);
        String wMeasurement = getData(width, false);
        Measurement wMeasure = getMeasurement(wMeasurement);

        if (checkData(wValue, wMeasurement, wMeasure) && checkData(lValue, lMeasurement, lMeasure))
        {
            System.out.println("OK");
            float surface = calculateSurface(Float.parseFloat(lValue), Float.parseFloat(wValue));
            System.out.println("Surface of " + length + " and " + width + " = " + surface);
        }
    }
}