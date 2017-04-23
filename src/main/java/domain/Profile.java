package domain;

import javax.persistence.*;
import java.util.Date;
/**
 * Describes user's profile
 * @author KostyaHrishenko
 */
public class Profile {
    public enum Sex{
        M("M"),F("F");
        private String name;
        Sex(String  name) {
            this. name = name;
        }

        public String getName() {
            return  name;
        }
    };
    public Profile(){

    }
    /**
     * Can't be changed after creation
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @Column(name = "login", length = 32)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "registertime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationTime;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private Sex sex;
    @ManyToOne
    @JoinColumn(name="profilecategories_id", insertable=false, updatable=false)
    private ProfileCategory category;
    @Column(name = "email")
    private String email;

    /**
     *
     * @return user's login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Change user's login
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return user's password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Change users password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Change users name
     * @param name
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
     * @param registrationTime
     */

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    /**
     *
     * @return user's sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Change users sex
     * @param sex
     */

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     *
     * @return profiles id
     */

    public int getId() {
        return id;
    }

    /**
     *
     * @return user's email
     */

    public String getEmail() {
        return email;
    }

    /**
     * Change profile email
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Contain information about user's sex
     * @author KostyaHrishenko
     */


    /**
     * Counstruct new user's profile with given parameters
     * @param id
     * @param login
     * @param password
     * @param registrationTime
     * @param name
     * @param sex
     * @param eMail
     * @param category
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
     * @return profile category
     */
    public ProfileCategory getCategory() {
        return category;
    }

    /**
     * Change profile category
     * @param category
     */
    public void setCategory(ProfileCategory category) {
        this.category = category;
    }

    /**
     * @return String representation of user's  profile
     */
    @Override
    public String toString(){
      return id+ " "+login+" "+password+" "+registrationTime+" "+name+" "+sex+" "+email+" "+category;
    }

}
