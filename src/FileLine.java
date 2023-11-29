public class FileLine
{
    private String line;

    FileLine(String line)
    {
        this.line = line;
    }

    public void print()
    {
        System.out.println(line);
    }

    public String getLine()
    {
        return this.line;
    }

    public void setLine(String value, String cumulative)
    {
        String[] temp = this.line.split(",");
        temp[temp.length - 3] = "€";
        temp[temp.length - 2] = value;
        temp[temp.length - 1] = cumulative;
        this.line = String.join(",", temp);
    }

    public String getValue()
    {
        String[] temp = this.line.split(",");
        return temp[temp.length - 2];
    }

    public String getCumulative()
    {
        String[] temp = this.line.split(",");
        return temp[temp.length - 1];
    }
}