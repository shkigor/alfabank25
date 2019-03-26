package ua.kiev.alfabank.login

import grails.transaction.Transactional
import ua.kiev.alfabank.User

@Transactional
class LoginService {

    public static final String FAIL_XML = '<xml><user><status>Fail</status></user></xml>'
    public static final String SUCCESS_XML = '<xml><user><status>Success</status><name></name></user></xml>'

    /**
     * Parse XML and find user
     * @param xmlRequest XML with login and password
     * @return grant user or null if user couldn't be found
     */
    User getAuthorisedUser(String xmlRequest) {
        Node loginNode = new XmlParser().parseText(xmlRequest)
        String userName = loginNode.username.text()
        String password = loginNode.password.text()
        return User.findByLoginAndPassword(userName, password)
    }

    /**
     * Add loginName value to XML 'name' node
     * @param loginName
     * @return XML with loginName
     */
    String getSuccessXmlWithUserName(String loginName) {
        SUCCESS_XML.replace('<name></name>', "<name>${loginName}</name>")
    }
}
