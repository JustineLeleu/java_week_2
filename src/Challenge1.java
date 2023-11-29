import javax.swing.*;

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

    public static float calculateSurface(float l, float w, float lConversion, float wConversion)
    {
        return (float) (Math.round(((l * lConversion) * ( w * wConversion)) * 100.0) / 100.0);
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

    public static void main(String[] args)
    {
        String length = JOptionPane.showInputDialog("Enter length:");
        String width = JOptionPane.showInputDialog("Enter width:");

        try
        {
            String lValue = getData(length, true);
            String lMeasurement = getData(length, false);
            Measurement lMeasure = getMeasurement(lMeasurement);

            String wValue = getData(width, true);
            String wMeasurement = getData(width, false);
            Measurement wMeasure = getMeasurement(wMeasurement);

            float surface = calculateSurface(Float.parseFloat(lValue), Float.parseFloat(wValue), lMeasure.conversion, wMeasure.conversion);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,"Surface of " + length + " and " + width + " = " + surface + " m");
        }
        catch (NullPointerException e)
        {
            System.out.println("Inputs not valid try again");
        }
    }
}