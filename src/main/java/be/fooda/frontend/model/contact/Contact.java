package be.fooda.frontend.model.contact;

public class Contact {

    private Long id;

    private ContactUser user;

    private String firstName;

    private String familyName;

    private String companyName;

    private String mobilePhoneNumber;

    private String linePhoneNumber;

    private String email;

    private Boolean canCall;

    private String title;

    private Boolean isCurrent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactUser getUser() {
        return user;
    }

    public void setUser(ContactUser user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getLinePhoneNumber() {
        return linePhoneNumber;
    }

    public void setLinePhoneNumber(String linePhoneNumber) {
        this.linePhoneNumber = linePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCanCall() {
        return canCall;
    }

    public void setCanCall(Boolean canCall) {
        this.canCall = canCall;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCurrent() {
        return isCurrent;
    }

    public void setCurrent(Boolean current) {
        isCurrent = current;
    }
}
