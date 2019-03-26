package ua.kiev.alfabank

class User {

    String login
    String password

    static constraints = {
        login unique: true, nullable: false
        password nullable: false
    }
}
