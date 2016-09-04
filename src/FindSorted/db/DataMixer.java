package FindSorted.db;

import FindSorted.actors.Client;
import FindSorted.actors.ContactInfo;

import java.util.Random;

/**
 * Создание рандомных тестовых данных
 */
public class DataMixer {
    private final static Random random = new Random();

    private final static char[] pnoneDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private final static int phoneNumberLength = 7;

    private final static char[] correctEmailCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static int emailLength = (3 + random.nextInt(12));


    /**
     * for name
     */
    public static String createFullName() {


        String[] name = {"Vasa", "Petya", "Sidor", "Inokentiy", "Petr", "Kolya", "Andrey"};
        String[] secondname = {"Vasechkin", "Petrov", "Sidorov", "Pyatochkin", "Gagarin", "Lenin", "Shevchenko"};

        String randName = name[(int) (Math.random() * name.length)];
        String randSurname = secondname[(int) (Math.random() * secondname.length)];

        return randName + " " + randSurname;
    }


    /**
     * for ContactInfo class
     */
    public static ContactInfo createContactInfo() {

        String[] city = {"Kiev", "Lvov", "Odessa", "Nikolaev", "IvanoFrankovsk", "Vinnica", "Chernigov"};
        String[] street = {"Persha Str", "Druga Str", "Tretya Str", "Chet Str", "Myru Str", "Peremogy Str", "Sadova Str"};

        String randCity = city[(int) (Math.random() * city.length)];
        String randPhoneNamber = createPhoneNumber(pnoneDigits, phoneNumberLength);
        String randEmail = emailGenerator(correctEmailCharacters, emailLength);

        return new ContactInfo(randCity, randPhoneNamber, randEmail);
    }

    //random phoneNumber generator
    public static String createPhoneNumber(char[] chars, int phoneNumberLength) {

        Random rand = new Random();

        String[] operator = {"050", "063", "067", "044", "093", "099", "095"};
        String randOper = operator[(int) (Math.random() * operator.length)];

        StringBuilder randomPhoneNumber = new StringBuilder(randOper + " ");
        for (int i = 0; i < phoneNumberLength; i++) {
            randomPhoneNumber.append(chars[rand.nextInt(chars.length)]);
        }
        return randomPhoneNumber.toString();
    }

    //random email generator
    public static String emailGenerator(char[] chars, int emailLength) {

        Random rand = new Random();

        String[] mails = {"@mail.ru", "@gmail.com", "@yandex.ru", "@i.ua", "@mail.ua"};
        String randMail = mails[(int) (Math.random() * mails.length)];

        StringBuilder randomEmail = new StringBuilder();
        for (int i = 0; i < emailLength; i++) {
            randomEmail.append(chars[rand.nextInt(chars.length)]);

        }
        String createdEmail = randomEmail + randMail;
        return createdEmail.toString();
    }

    /**
     * for Admin Class
     */
    /*public static Admin createAdmin() {
        String fullName = createFullName();
        ContactInfo contactInfo = createContactInfo();

        return new Admin(fullName, contactInfo);

    }*/

    /**
     * for Manager Class
     */
    /*public static Manager createManager() {
        String fullName = createFullName();
        ContactInfo contactInfo = createContactInfo();

        return new Manager(fullName, contactInfo);

    }*/


 /*   *//**
     * for Worker Class
     *//*
    public static Worker createWorker() {
        String fullName = createFullName();
        ContactInfo contactInfo = createContactInfo();

        List<Service> sevices = Arrays.asList(createService(), createService(), createService());
        List<Comment> comments = Arrays.asList(createComment(), createComment());

        return new Worker(fullName, contactInfo, sevices, comments);

    }*/

    /**
     * for Client class
     */
    public static Client createClient() {
        String fullName = createFullName();
        ContactInfo contactInfo = createContactInfo();
        //List<Comment> comments = Arrays.asList(createComment(), createComment());
        return new Client(fullName, contactInfo);
    }

    /**
     * for Comment class
     */
   /* public static Comment createComment(User author) {
        String autor = author.getFullName();
        double rate = random.nextInt(5);

        String[] firsWord = {"Все", "Я думаю это", "Ваще"};
        String[] secondWord = {"ништяк", "писец", "отлично"};
        String randfirsWord = firsWord[(int) (Math.random() * firsWord.length)];
        String rendomsecondWord = secondWord[(int) (Math.random() * secondWord.length)];

        String feedback = randfirsWord + "" + rendomsecondWord;

        return new Comment(autor, rate, feedback);
    }

    //  public static Comment createComment(String comAuthor) {
    public static Comment createComment() {
        //String autor = comAuthor;
        double rate = random.nextInt(5);

        String[] firsWord = {"Все", "Я думаю - это", "Ваще"};
        String[] secondWord = {"ништяк!", "писец!", "отлично!"};
        String randfirsWord = firsWord[(int) (Math.random() * firsWord.length)];
        String rendomsecondWord = secondWord[(int) (Math.random() * secondWord.length)];

        String feedback = randfirsWord + " " + rendomsecondWord;

        return new Comment(rate, feedback);
    }

    //service creation
    public static Service createService() {
        String[] title = {"Title1", "Title2", "Title3", "Title4", "Title15"};
        String[] description = {"description1", "description2", "description3", "description4", "description5"};
        String randTitle = title[(int) (Math.random() * title.length)];
        String randDescription = description[(int) (Math.random() * description.length)];


        return new Service(randTitle, randDescription);
    }

    *//**
     * for Company
     *//*
    public static Company createCompany() {
        String[] companyName = {"Company1", "Company2", "Company3", "Company4", "Company5"};
        String randomCompanyName = companyName[(int) (Math.random() * companyName.length)];

        ContactInfo contactInfo = createContactInfo();


        List<Service> services = Arrays.asList(createService(), createService(), createService());

        List<Worker> workers = Arrays.asList(createWorker(), createWorker(), createWorker());


        return new Company(randomCompanyName, contactInfo, services, workers);
    }

*/
}
