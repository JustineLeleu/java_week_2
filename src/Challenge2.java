import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge2
{
    public static List<String> createList(int index)
    {
        List<String> list = new ArrayList<>();
        try(InputStream inputFS = new FileInputStream("src/effects-of-covid19-on-trade.csv"); BufferedReader br = new BufferedReader(new InputStreamReader(inputFS)))
        {
            list = br.lines()
                    .skip(1)
                    .map(line -> line.split(",")[index])
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
        List<String> columnOne = createList(0);
        List<String> columnTwo = createList(1);
        List<String> columnThree = createList(2);
        List<String> columnFour = createList(3);
        List<String> columnFive = createList(4);
        List<String> columnSix = createList(5);
        List<String> columnSeven = createList(6);
        List<String> columnEight = createList(7);
        List<String> columnNine = createList(8);
        List<String> columnTen = createList(9);
        for (String el : columnTen)
        {
            System.out.println(el);
        }
    }
}