package webec

/**
 * Load some usefull demodata
 */
class BootStrap {
    def init = { servletContext ->
        /* Lecturers*/
        def ribeaud   = new Lecturer(lastname:'Ribeaud', firstname:'Christian', email:'christian.ribeaud@fhnw.ch').save()
        def weck      = new Lecturer(lastname:'Weck', firstname:'Wolfgang', email:'wolfgang.weck@fhnw.ch').save()
        def scheuner  = new Lecturer(lastname:'Mall', firstname:'Daniel', email:'daniel.mall@fhnw.ch').save()

        /* User Roles */
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole  = new Role(authority: 'ROLE_USER').save()

        /* Users */
        def mwinter    = new User(username:'markus.winter@students.fhnw.ch', password: 'markus87', lastname:'Winter', firstname:'Markus').save()
        def thundt     = new User(username: 'thierry.hundt@students.fhnw.ch', password: 'thundt', lastname:'Hundt', firstname:'Thierry').save()

        /* Set User Roles */
        if(!mwinter.authorities.contains(adminRole)) UserRole.create(mwinter, adminRole, true)
        if(!thundt.authorities.contains(adminRole)) UserRole.create(thundt, userRole, true)

        /* Modules*/
        def aldg1 = new Module(name:'aldg1', semester:3, location:'6.1H07', lecturer:weck, user:mwinter).save()
        def eti   = new Module(name:'eti', semester:3, location:'5.4.H06', lecturer:scheuner, user:mwinter).save()
        def webec = new Module(name:'webeC', semester:3, location:'5.2H14', lecturer:ribeaud, user:mwinter).save()

        /* Exams */
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-09 08:15:00"), description:'Zwischenprüfung', grade: 4.5, module:aldg1).save()
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2019-01-15 15:15:00"), description:'MSP', grade: 5.25, module:aldg1).save()

        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-09 08:15:00"), description:'Kurztest 1', grade: 3.4, module:eti).save()
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-23 08:15:00"), description:'Kurzstest 2', grade: 3.57, module:eti).save()
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-23 08:15:00"), description:'Zwischenprüfung', grade: 4.2, module:eti).save()

        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-09 08:15:00"), description:'Zwischenprüfung 1', grade: 4.87, module:webec).save()
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-23 08:15:00"), description:'Zwischenprüfung 2', grade: 3.6, module:webec).save()
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-23 08:15:00"), description:'Modulpraktikum', grade: 5.42, module:webec).save()
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2019-01-15 15:15:00"), description:'MSP', module:webec).save()
    }

    def destroy = { }
}
