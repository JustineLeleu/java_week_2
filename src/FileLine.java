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

    public void setLine(String value, String cumulative, char currency)
    {
        String[] temp = this.line.split(",");
        temp[temp.length - 3] = String.valueOf(currency);
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

    public long getLongValue()
    {
        return Long.parseLong(getValue());
    }

    public String getMonth()
    {
        String date = this.line.split(",")[2];
        return date.split("/")[1];
    }
}