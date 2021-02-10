public class FootballClub {

    private final String country;

    private final String name;

    private final int achievedPoint;

    public FootballClub(String country, String name, int achievedPoint) {
        this.country = country;
        this.name = name;
        this.achievedPoint = achievedPoint;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public int getAchievedPoint() {
        return achievedPoint;
    }
}

//TODO Есть список команд. Необходимо расположить команды по принципу: страны в алфавитном порядке и количество набранных
//очков.
