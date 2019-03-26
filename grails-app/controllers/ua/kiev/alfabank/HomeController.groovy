package ua.kiev.alfabank

class HomeController {

    def index(String userLoginName) {
        [userLoginName: userLoginName]
    }
}
