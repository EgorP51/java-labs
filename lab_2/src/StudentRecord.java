class StudentRecord {
    private final String lastName;
    private final String firstName;
    private final String birthDate;
    private final String phoneNumber;
    private final String address;

    public StudentRecord(String lastName, String firstName, String birthDate, String phoneNumber, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Прізвище: " + lastName +
                ",\nІм'я: " + firstName +
                ",\nДата народження: " + birthDate +
                ",\nТелефон: " + phoneNumber +
                ",\nАдреса: " + address;
    }
}