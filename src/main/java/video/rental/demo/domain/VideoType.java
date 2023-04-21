package video.rental.demo.domain;

public enum VideoType {

  VHS(1, 5),
  CD(2, 3),
  DVD(3, 2);

  final int penalty;
  final int limit;

  VideoType(int penalty, int limit) {
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
    switch (videoType) {
      case 1:
        return VideoType.VHS;
      case 2:
        return VideoType.CD;
      case 3:
        return VideoType.DVD;
    }
    throw new IllegalArgumentException("Invalid type " + videoType);
  }

}
