package healthcalc;

public class PersonImpl implements Person {
    private final float weight;
    private final int height;
    private final int age;
    private final Gender gender;


    public PersonImpl(float weight, int height, int age, Gender gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }


    @Override
    public float weight() {
        return weight;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public int age() {
        return age;
    }

    @Override
    public Gender gender() {
        return gender;
    }
}

