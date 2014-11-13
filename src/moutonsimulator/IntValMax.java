package moutonsimulator;

public class IntValMax {

    private int val;
    private int max;

    public IntValMax(int max) {
        this.val = max;
        this.max = max;
    }

    public IntValMax(int val, int max) {
        this.val = val;
        this.max = max;
    }

    public boolean incremente() {
        this.val++;
        return this.val == this.max;
    }

    public boolean decremente() {
        this.val--;
        return this.val == 0;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
