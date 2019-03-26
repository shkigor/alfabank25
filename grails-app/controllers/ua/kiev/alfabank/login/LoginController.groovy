package ua.kiev.alfabank.login

import ua.kiev.alfabank.User

class LoginController {

    static allowedMethods = [ajaxCheckUser:'POST']

    def loginService

    def index() { }

    /**
     * Action get XML with login and password
     * @return XML with success or fail login status
     */
    def ajaxCheckUser() {
        String xmlRequest = request.reader.text
        User authorisedUser = loginService.getAuthorisedUser(xmlRequest)
        if (authorisedUser) {
            render(text: loginService.getSuccessXmlWithUserName(authorisedUser.login), contentType: "text/xml", encoding: "UTF-8")
        } else {
            render(text: LoginService.FAIL_XML, contentType: "text/xml", encoding: "UTF-8")
        }
    }
}
