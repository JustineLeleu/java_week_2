import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Challenge3
{
    public static List<Line> createList(String country, String year)
    {
        List<Line> list = new ArrayList<>();
        try(InputStream inputFS = new FileInputStream("src/effects-of-covid19-on-trade.csv"); BufferedReader br = new BufferedReader(new InputStreamReader(inputFS)))
        {
            list = br.lines().skip(1).filter(line -> (Objects.equals(line.split(",")[1], year) && Objects.equals(line.split(",")[4], country))).map(Line::new).collect(Collectors.toList());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return list;
    }
    public static void main (String[] args)
    {
        List<Line> list = createList("All", "2016");
        for (Line el : list)
        {
            el.print();
        }
    }
}

class Line
{
    private final String line;

    Line(String line)
    {
        this.line = line;
    }

    public void print()
    {
        System.out.println(line);
    }
}