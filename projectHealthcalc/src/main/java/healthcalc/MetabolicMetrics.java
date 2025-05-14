package healthcalc;

public class MetabolicMetrics {
    public float basalMetabolicRate(Person person)
            throws InvalidValueException, InvalidGenderException {

        int height = person.height();         
        Gender gender = person.gender();
        float weight = person.weight();
        int age = person.age();

        if (weight <= 0 || weight > 300) {
            throw new InvalidValueException("Invalid weight: " + weight);
        }

        if (height <= 0 || height > 230) {
            throw new InvalidValueException("Invalid height: " + height);
        }

        if (age <= 0 || age > 120) {
            throw new InvalidValueException("Invalid age: " + age);
        }

        if (gender == null) {
            throw new InvalidGenderException("Gender cannot be null");
        }

        float bmr = switch (gender) {
            case MALE -> 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
            case FEMALE -> 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
        };

        if (bmr < 0) {
            throw new InvalidValueException("Calculated BMR is negative: " + bmr);
        }
    
        return bmr;
    }
}
