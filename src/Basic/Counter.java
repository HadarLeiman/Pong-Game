package Basic;

/**
 * The type Basic.Counter.
 */
public class Counter {
    private Integer counter;

    /**
     * Instantiates a new Basic.Counter.
     */
    public Counter() {
        this.counter = 0;
    }

    /**
     * Instantiates a new Basic.Counter.
     *
     * @param startFrom the start from number
     */
    public Counter(Integer startFrom) {
        this.counter = startFrom;
    }

    /**
     * Increase.
     * add number to current count.
     *
     * @param number the number
     */
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * Decrease.
     * subtract number from current count.
     *
     * @param number the number
     */
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * Gets value.
     * get current count.
     *
     * @return the value
     */
    public int getValue() {
        return this.counter;
    }
}
