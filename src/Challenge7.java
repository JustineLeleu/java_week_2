import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Challenge7
{
    public static HashMap<String, Long> createMap(String year, String country)
    {
        HashMap<String, Long> map;
        try(InputStream inputFS = new FileInputStream("src/effects-of-covid19-on-trade.csv"); BufferedReader br = new BufferedReader(new InputStreamReader(inputFS)))
        {
            List<FileLine> list = br.lines()
                                    .skip(1)
                                    .filter(line -> Objects.equals(line.split(",")[0], "Exports") && Objects.equals(line.split(",")[1], year) && Objects.equals(line.split(",")[4], country))
                                    .map(FileLine::new)
                                    .collect(Collectors.toList());

            map = (HashMap<String, Long>) list.stream()
                    .collect(Collectors.groupingBy(FileLine::getMonth, Collectors.summingLong(FileLine::getLongValue)));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return map;
    }
    public static void  main (String[] args)
    {
        HashMap<String, Long> map2019 = createMap("2019", "European Union (27)");
        HashMap<String, Long> map2020 = createMap("2020", "European Union (27)");

        for (int i = 1; i <= 12; i++)
        {
            NumberFormat formatter = new DecimalFormat("00");
            String month = formatter.format(i);
            System.out.println("Month:" + month + " 2019:" + map2019.get(month) + " 2020:" + map2020.get(month));
        }
    }
}