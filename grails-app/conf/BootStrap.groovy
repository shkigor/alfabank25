import ua.kiev.alfabank.User

class BootStrap {

    def init = { servletContext ->
        new User(login: 'user', password: 'user').save(failOnError: true, flush: true)
    }
    def destroy = {
    }
}
