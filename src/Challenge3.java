import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Challenge3
{
    public static List<FileLine> createList(String country, String year)
    {
        List<FileLine> list = new ArrayList<>();
        try(InputStream inputFS = new FileInputStream("src/effects-of-covid19-on-trade.csv"); BufferedReader br = new BufferedReader(new InputStreamReader(inputFS)))
        {
            list = br.lines()
                    .skip(1)
                    .filter(line -> (Objects.equals(line.split(",")[1], year) && Objects.equals(line.split(",")[4], country)))
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
        List<FileLine> list = createList("All", "2016");
        for (FileLine el : list)
        {
            el.print();
        }
    }
}