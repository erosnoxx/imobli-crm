package com.erosnox.imobli.core.shared.values;

public class Contact {
    private Email email;
    private Phone phone;

    public Contact(String email, String phone) {
        changeEmail(email);
        changePhone(phone);
    }

    public void changeEmail(String email) {
        this.email = new Email(email);
    }

    public void changePhone(String phone) {
        this.phone = new Phone(phone);
    }

    public String getEmail() {
        return email.getValue();
    }

    public String getPhone() {
        return phone.getValue();
    }
}
