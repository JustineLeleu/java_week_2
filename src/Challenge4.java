import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge4
{
    public static List<FileLine> createList(float change, char currency)
    {
        List<FileLine> list;
        try(InputStream inputFS = new FileInputStream("src/effects-of-covid19-on-trade.csv"); BufferedReader br = new BufferedReader(new InputStreamReader(inputFS)))
        {
            list = br.lines()
                    .skip(1)
                    .map(FileLine::new)
                    .collect(Collectors.toList());
            list.stream()
                    .filter(line -> line.getLine().contains("$")).forEach(line -> line.setLine(convert(line.getValue(), change), convert(line.getCumulative(), change), currency));
            return list;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static String convert(String dollarValue, float value)
    {
        long x = (long) (Long.parseLong(dollarValue) * value);
        return String.valueOf(x);
    }
    public static void main (String[] args)
    {
        List<FileLine> list = createList(0.85f, '€');
        for (FileLine el : list)
        {
            el.print();
        }
    }
}