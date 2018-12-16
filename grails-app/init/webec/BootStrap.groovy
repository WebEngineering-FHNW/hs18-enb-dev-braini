package webec

class BootStrap {
    def init = { servletContext ->
        def ribeaud  = new Lecturer(lastname:'Ribeaud', firstname:'Christian', email:'christian.ribeaud@fhnw.ch').save()
        def weck     = new Lecturer(lastname:'Weck', firstname:'Wolfgang', email:'wolfgang.weck@fhnw.ch').save()
        def scheuner = new Lecturer(lastname:'Scheuner', firstname:'Barbara', email:'barbara.scheuner@fhnw.ch').save()

        //User winter = new User(lastname:'Winter', firstname:'Markus', email:'markus.winter@studnets.fhnw.ch').save()
        //User§ hundt  = new User(lastname:'Hundt', firstname:'Thierry', email:'thierry.hundt@studnets.fhnw.ch').save()

        // security
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()

        def admin = new User(username:'markus.winter@students.fhnw.ch', password: 'markus87', lastname:'Winter', firstname:'Markus').save()
        def user = new User(username: 'thierry.hundt@students.fhnw.ch', password: 'thundt', lastname:'Hundt', firstname:'Thierry').save()

        if(!admin.authorities.contains(adminRole)){
            UserRole.create(admin, adminRole, true)
        }

        if(!user.authorities.contains(adminRole)){
            UserRole.create(user, userRole, true)
        }

        def webec = new Module(name:'webeC', semester:3, location:'5.2H14', lecturer:ribeaud, user:user).save()
        def aldg1 = new Module(name:'aldg1', semester:3, location:'6.1H07', lecturer:weck, user:user).save()
        def p3p4  = new Module(name:'p3/p4', semester:3, location:'5.4.H06', lecturer:scheuner, user:admin).save()

        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-09 08:15:00"), description:'Zwischenprüfung 1', grade: 3.5, module:webec).save()
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-23 08:15:00"), description:'Zwischenprüfung 2', grade: 4.57, module:webec).save()
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2019-01-15 15:15:00"), description:'MSP', module:webec).save()
    }
    def destroy = {
    }
}
