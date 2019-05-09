package Day13;

/**
 * 自定义枚举类
 */

public class SeasonEnumDefine {;

    // 1. 给类的对象声明，要求属性声明为private final
    private final String SEASON_NAME;
    private final String SEASON_DESC;

    // 2. 私有化构造器，并给常量赋值
    SeasonEnumDefine(String SEASON_NAME, String SEASON_DESC) {
        this.SEASON_NAME = SEASON_NAME;
        this.SEASON_DESC = SEASON_DESC;
    }

    // 3. 提供当前枚举类的对象
    public static final SeasonEnumDefine SPRING = new SeasonEnumDefine("春天","Spring");
    public static final SeasonEnumDefine SUMMER = new SeasonEnumDefine("夏天","Summer");
    public static final SeasonEnumDefine AUTUMN = new SeasonEnumDefine("秋天","Autumn");
    public static final SeasonEnumDefine WINTER = new SeasonEnumDefine("冬天","Winter");

    public String getSEASON_NAME() {
        return SEASON_NAME;
    }

    public String getSEASON_DESC() {
        return SEASON_DESC;
    }

    @Override
    public String toString() {
        return "SeasonEnumDefine{" +
                "SEASON_NAME='" + SEASON_NAME + '\'' +
                ", SEASON_DESC='" + SEASON_DESC + '\'' +
                '}';
    }
}
