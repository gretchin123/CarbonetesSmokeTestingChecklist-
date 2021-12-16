package xpaths;

public class RegistrationXpaths {

        public String RegistrationFields;

        public String hereLink() {
            return this.RegistrationFields = "//a[contains(text(),'here')]";
        }

        public String FirstNameTextField() {
            return this.RegistrationFields = "//input[@aria-label='First Name']";
        }

        public String LastNameTextField() {
            return this.RegistrationFields = "//input[@aria-label='Last Name']";
        }

        public String EmailTextField() {
            return this.RegistrationFields = "//input[@aria-label='Email']";
        }

        public String PasswordTextField() {
            return this.RegistrationFields = "//input[@aria-label='Password']";
        }

        public String ConfirmPasswordTextField() {
            return this.RegistrationFields = "//input[@aria-label='Confirm Password']";
        }

        public String CompanyTextField() {
            return this.RegistrationFields = "//input[@aria-label='Company']";
        }

        public String PhoneNumberTextField() {
            return this.RegistrationFields = "//input[@aria-label='Phone Number']";
        }

        public String RegisterButton() {
            return this.RegistrationFields = "//div[@class='v-btn__content']";
        }

        public String RequiredFieldErrorMessage(){
            return this.RegistrationFields = "//div[contains(text(),'First Name is required')]";
        }

        public String InvalidEmailErrorMessage(){
            return this.RegistrationFields = "//div[@class='v-messages__message']";
        }

        public String RegistrationSuccessMessage(){
            return this.RegistrationFields = "//h3[contains(text(),'Registration Successful!')]";
        }
}
