package healthcalc;

public class CardiovascularMetrics {
    public double idealWeight(Person person) throws InvalidHeightException, InvalidGenderException {

        float height = person.height();         
        Gender gender = person.gender();

        if (height <= 0 || height > 230) {
            throw new InvalidHeightException("Invalid height: " + height);
        }

        if (gender == null) {
            throw new InvalidGenderException("Gender cannot be null");
        }

        switch (gender) {
            case MALE:
                if (height < 84) {
                    throw new InvalidHeightException("Height must be >= 84 cm for men. Provided: " + height);
                }
                return height - 100 - (height - 150) / 4f;
            case FEMALE:
                if (height < 67) {
                    throw new InvalidHeightException("Height must be >= 67 cm for women. Provided: " + height);
                }
                return height - 100 - (height - 150) / 2.5f;
            default:
                throw new InvalidGenderException("Unrecognized gender");
        }
    }

}
