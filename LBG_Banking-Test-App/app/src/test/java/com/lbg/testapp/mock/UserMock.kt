package com.lbg.testapp.mock

import com.lbg.testapp.data.entity.NameModel
import com.lbg.testapp.data.entity.PictureModel
import com.lbg.testapp.data.entity.UserModel
import com.lbg.testapp.domain.entity.Name
import com.lbg.testapp.domain.entity.Picture
import com.lbg.testapp.domain.entity.User

/**
 * Created by Siva kumar boddu 
 */
object UserMock {

    val oneUser: User get() = User(
        id = 1L,
        gender = "",
        name = Name("", "", ""),
        email = "String",
        picture = Picture("", "", ""),
        favourite = false
    )

    val oneUserModel: UserModel get() = oneUser.toModel()

    private fun User.toModel() = UserModel(
        id = id,
        gender = gender,
        name = NameModel("", "", ""),
        email = email,
        picture = PictureModel("", "", ""),
        favourite = favourite
    )


}