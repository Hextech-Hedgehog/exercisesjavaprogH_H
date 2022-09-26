package enumm;

public enum Gender {
    MALE(new String[]{"he", "him", "his", "his", "himself"}, "M"),
    FEMALE(new String[]{"she", "her", "her", "hers", "herself"}, "F"),
    OTHER(new String[]{"they", "them", "their", "theirs", "themself"}, "X");

    private String[] pronouns;
    private String abbreviation;

    private Gender(String[] pronouns, String abbreviation) {
        this.pronouns = pronouns;
        this.abbreviation = abbreviation;
    }

    public String[] getPronouns() {
        return pronouns;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
