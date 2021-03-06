package webec

/**
 * URL Mappings
 */
class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"module")
        "500"(view:'/error')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
