package sem2.tsk1;

public class TestSecond extends TestFirst {
    @Override
    public int getNext() {
        val += 3;
        return val;
    }

    @Override
    int getPreview() {
        return val -= 3;
    }
}
