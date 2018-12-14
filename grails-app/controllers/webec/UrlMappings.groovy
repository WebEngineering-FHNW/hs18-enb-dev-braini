package webec

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/indexGrails"(view:"/indexGrails")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
