package video.rental.demo.domain;

import java.util.Arrays;

public enum VideoType {

  VHS(1, 1, 5),
  CD(2, 2, 3),
  DVD(3, 3, 2);

  private final int code;
  private final int penalty;
  private final int limit;

  VideoType(int code, int penalty, int limit) {
    this.code = code;
    this.penalty = penalty;
    this.limit = limit;
  }

  public int getLateReturnPointPenalty() {
    return penalty;
  }

  public int getDaysRentedLimit() {
    return limit;
  }

  public static VideoType from(int videoType) {
    return Arrays.stream(VideoType.values())
        .filter(type -> type.code == videoType)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid type " + videoType));
  }

  @Override
  public String toString() {
    return String.valueOf(code);
  }

}
