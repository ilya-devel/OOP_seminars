package sem2.tsk1;

public class TestFirst implements GetNums{
    int start;
    int val;


    @Override
    public int getNext() {
        val += 2;
        return val;
    }

    @Override
    public void reset() {
        start = 0;
        val = 0;
    }

    @Override
    public void setStart(int x) {
        start = x;
        val = x;
    }

    int getPreview() {
        return val -= 2;
    }
}
