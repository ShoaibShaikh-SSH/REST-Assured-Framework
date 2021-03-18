package DataCreationFromModel;

import DataModel.UserPojo;
import com.github.javafaker.Faker;

public class UserDataCreator
{
    public static UserPojo user = new UserPojo();
    public static Faker fake = new Faker();

    public UserPojo DataForUSerCreation()
    {
        user.setId(fake.number().randomDigitNotZero());
        user.setUsername(fake.name().username());
        user.setFirstName(fake.name().firstName());
        user.setLastName(fake.name().lastName());
        user.setEmail(fake.internet().emailAddress());
        user.setPassword(fake.internet().password());
        user.setPhone(fake.phoneNumber().phoneNumber());
        user.setUserStatus("1");
        return user;
    }
}
