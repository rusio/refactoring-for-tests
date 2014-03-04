package common;

/**
 * A utility class to simulate program execution
 * through the 'happy path' in the examples.
 */
public final class Chances {

  public static final double FAILURE_THRESHOLD = 0.01;

  private Chances() {
    // utility class
  }

  public static boolean isHappyPath() {
    return Math.random() > FAILURE_THRESHOLD;
  }
}
