package sem2.tsk3;

public interface MyIf {
    int getUserID();
    default int getAdminID() {
        return 0;
    }
    static int getUniversalID() {
        return Integer.MAX_VALUE;
    }
}
