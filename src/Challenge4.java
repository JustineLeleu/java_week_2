import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge4
{
    public static List<FileLine> createList()
    {
        List<FileLine> list;
        try(InputStream inputFS = new FileInputStream("src/effects-of-covid19-on-trade.csv"); BufferedReader br = new BufferedReader(new InputStreamReader(inputFS)))
        {
            list = br.lines().skip(1).map(FileLine::new).collect(Collectors.toList());
            list.stream().filter(line -> line.getLine().contains("$")).forEach(line -> line.setLine(convertToEuro(line.getValue()), convertToEuro(line.getCumulative())));
            return list;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static String convertToEuro(String dollarValue)
    {
        long x = (long) (Long.parseLong(dollarValue) * 0.85);
        return String.valueOf(x);
    }
    public static void main (String[] args)
    {
        List<FileLine> list = createList();
        for (FileLine el : list)
        {
            el.print();
        }
    }
}