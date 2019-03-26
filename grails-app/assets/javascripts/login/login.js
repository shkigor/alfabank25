var triggerValidateAndXmlAjaxSend = function (ajaxUrl) {
    console.log(ajaxUrl);
    var login = $('#loginId').val();
    var password = $('#password').val();
    if (isValidateForm(login, password)) {
        var xml_string = '<?xml version="1.0" encoding="UTF-8"?><login><username>' + login + '</username><password>' + password + '</password></login>';
        $.ajax({
            url: ajaxUrl,
            data: xml_string,
            type: 'POST',
            contentType: "text/xml",
            dataType: "text",
            success: parseResponseXml,
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(thrownError);
            }
        });
    }
    return false;
};

var parseResponseXml = function (response) {
    var status = $(response).find("status").text();
    var userLoginName = $(response).find("name").text();
    if (status == 'Success') {
        window.location.href = homeUrl + '?userLoginName=' + userLoginName;
    } else if (status == 'Fail') {
        $(".validate-content").html('<p>Authorization Error. Please input valid username and password.</p>');
        $('#password').val('');
    }
};

var isValidateForm = function (login, password) {
    if (login.length == 0 && password.length == 0) {
        $(".validate-content").html('<p>Login and password could not be empty</p>');
        return false;
    }
    return true;
};

var newHandle = function doSomething(e) {
    // if (!e) var e = window.event;
    // e.cancelBubble = true;
    // if (e.stopPropagation) e.stopPropagation();
    alert('Click on div');
};

$(function () {
    // window.event.cancelBubble = true;
   var divEventTest = document.getElementById('eventTest');
   // divEventTest.onclick = function () {
   //     alert('Click on div');
   // };
   // divEventTest.addEventListener("click", doSomething);
   divEventTest.addEventListener("click", newHandle);

    // divEventTest.firstElementChild.addEventListener("click", function () {
    //     alert('Click on p');
    // });
});