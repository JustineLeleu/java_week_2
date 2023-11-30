import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Challenge5
{
    public static List<FileLine> createList(String direction, String year)
    {
        List<FileLine> list = new ArrayList<>();
        try(InputStream inputFS = new FileInputStream("src/effects-of-covid19-on-trade.csv"); BufferedReader br = new BufferedReader(new InputStreamReader(inputFS)))
        {
            list = br.lines()
                    .skip(1)
                    .filter(line -> (Objects.equals(line.split(",")[1], year) && Objects.equals(line.split(",")[0], direction)) && Objects.equals(line.split(",")[4], "All") && Objects.equals(line.split(",")[5], "All") && Objects.equals(line.split(",")[6], "All"))
                    .sorted(Comparator.comparing(line -> line.split(",")[line.split(",").length - 2]))
                    .map(FileLine::new)
                    .collect(Collectors.toList());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return list;
    }
    public static void main (String[] args)
    {
        List<FileLine> list = createList("Imports", "2018");
        for (FileLine el : list)
        {
            el.print();
        }
    }
}