package domain;

import java.util.Date;
/**
 * Describes user's profile
 * @author KostyaHrishenko
 */
public class Profile {
    private  int id;
    private String login;
    private String password;
    private Date registrationTime;
    private String name;
    private Sex sex;
    private ProfileCategory category;
    private String email;

    /**
     * Counstruct new user's profile with given parameters
     * @param id - profile id
     * @param login - profile login
     * @param password - profile password
     * @param registrationTime - profile registration time
     * @param name - profile name
     * @param sex - profile sex
     * @param eMail - profile email
     * @param category - profile category
     */
    public Profile(int id,String login, String password, Date registrationTime, String name, Sex sex, String eMail,ProfileCategory category) {
        this.login = login;
        this.password = password;
        this.registrationTime = registrationTime;
        this.name = name;
        this.sex = sex;
        this.email = eMail;
        this.category = category;
        this.id = id;
    }

    /**
     * @return user's login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Change user's login
     * @param login - login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return user's password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Change users password
     * @param password - password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Change users name
     * @param name - name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return profile registration timre
     */
    public Date getRegistrationTime() {
        return registrationTime;
    }

    /**
     * Change profile registration time
     * @param registrationTime - registration time
     */

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    /**
     * @return user's sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Change users sex
     * @param sex - sex
     */

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * @return profiles id
     */

    public int getId() {
        return id;
    }

    /**
     * @return user's email
     */

    public String getEmail() {
        return email;
    }

    /**
     * Change profile email
     * @param email - email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return profile category
     */
    public ProfileCategory getCategory() {
        return category;
    }

    /**
     * Change profile category
     * @param category - profile category
     */
    public void setCategory(ProfileCategory category) {
        this.category = category;
    }

    /**
     * @return String representation of user's profile
     */
    public String toString(){
      return id+ " "+login+" "+password+" "+registrationTime+" "+name+" "+sex+" "+email+" "+category;
    }

    /**
     * All possible sexes
     */
    public enum Sex{
        M("M"),F("F");
        private String name;

        /**
         * Create new sex with given name
         * @param name - sex name
         */
        Sex(String  name) {
            this. name = name;
        }

        /**
         * @return sex name
         */
        public String getName() {
            return  name;
        }
    }

}
