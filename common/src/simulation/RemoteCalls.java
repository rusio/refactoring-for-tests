package simulation;

/**
 * A utility class to simulate program execution
 * remote calls, I/O stuff and all things that
 * are accessed beyond the process boundary.
 */
public final class RemoteCalls {

  public static final long SLEEP_MILLIS = 2000L;

  private RemoteCalls() {
    // utility class
  }

  public static void perform() {
    try {
      Thread.sleep(SLEEP_MILLIS);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }
}
