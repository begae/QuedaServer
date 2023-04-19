package com.whoasys.quedaserver

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HtmlController {

    @RequestMapping("/address")
    fun blog(model: Model): String {
        return "AddressSearch"
    }
}