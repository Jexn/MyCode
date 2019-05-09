package Day13;

/**
 * enum关键字定义枚举
 */

public enum SeasonEnum {
    SPRING("春天", "Spring"),
    SUMMER("夏天", "Summer"),
    AUTUMN("秋天", "Autumn"),
    WINTER("冬天", "Winter");

    private final String SEASON_NAME;
    private final String SEASON_DESC;

    private SeasonEnum(String SEASON_NAME, String SEASON_DESC) {
        this.SEASON_NAME = SEASON_NAME;
        this.SEASON_DESC = SEASON_DESC;
    }

    @Deprecated
    public String getSEASON_NAME() {
        return SEASON_NAME;
    }

    public String getSEASON_DESC() {
        return SEASON_DESC;
    }

    @Override
    public String toString() {
        return "SeasonEnum{" +
                "SEASON_NAME='" + SEASON_NAME + '\'' +
                ", SEASON_DESC='" + SEASON_DESC + '\'' +
                '}';
    }}
