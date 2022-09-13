public enum Gender {
    MALE(new String[]{"he", "him", "his"}),
    FEMALE(new String[]{"she", "her", "hers"}),
    OTHER(new String[]{"they", "them", "theirs"});

    public String[] pronouns;

    private Gender(String[] pronouns) {
        this.pronouns = pronouns;
    }
}
