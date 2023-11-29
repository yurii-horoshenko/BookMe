package com.gorosoft.bookme.now.network_manager.Remote

class UserRemoteFlow {
}


//GET:  base_url/user/login
//Header: “Authorization” : {access_token}
//
//Response:
//{
//    “fullname”: “Daniel Austin”,
//    “phone”: “+1111467378399”,
//    “gender”: “male”,
//    “birthday”: 567602526000,
//    “success”: true
//}


//GET:  base_url/user/validation
//Header: “Authorization” : {static_JTW_auth_token}
//Body:
//{
//    “facebook_token”: “{token}”
//}
//
//Response:
//{
//    “fullname”: “Daniel Austin”,
//    “phone”: “+1111467378399”,
//    “gender”: “male”,
//    “birthday”: 567602526000,
//    “is_exist”: true
//    “success”: true
//}