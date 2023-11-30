import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Challenge6
{
    public static List<FileLine> createList(String country, String year)
    {
        List<FileLine> list = new ArrayList<>();
        try(InputStream inputFS = new FileInputStream("src/effects-of-covid19-on-trade.csv"); BufferedReader br = new BufferedReader(new InputStreamReader(inputFS)))
        {
            list = br.lines()
                    .skip(1)
                    .filter(line -> Objects.equals(line.split(",")[0], "Exports") && Objects.equals(line.split(",")[1], year) && Objects.equals(line.split(",")[4], country) && Objects.equals(line.split(",")[5], "All") && Objects.equals(line.split(",")[6], "All"))
                    .map(FileLine::new)
                    .collect(Collectors.toList());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return list;
    }

    public static Long getSum(List<FileLine> list)
    {
        long sum = 0L;
        for (FileLine el : list)
        {
            sum += Long.parseLong(el.getValue());
        }
        return sum;
    }

    public static FileLine getMax(List<FileLine> list)
    {
        FileLine MaxLine;
        try
        {
            MaxLine = list.stream()
                    .max(Comparator.comparing(FileLine -> Long.parseLong(FileLine.getValue())))
                    .orElseThrow(Exception::new);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return MaxLine;
    }
    public static void main (String[] args)
    {
        List<FileLine> list = createList("China", "2019");
        FileLine max = getMax(list);
        max.print();
        System.out.println("sum = " + getSum(list));
    }
}