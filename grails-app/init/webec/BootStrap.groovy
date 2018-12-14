package webec

class BootStrap {
    def init = { servletContext ->
        Lecturer ribeaud  = new Lecturer(lastname:'Ribeaud', firstname:'Christian', email:'christian.ribeaud@fhnw.ch').save()
        Lecturer weck     = new Lecturer(lastname:'Weck', firstname:'Wolfgang', email:'wolfgang.weck@fhnw.ch').save()
        Lecturer scheuner = new Lecturer(lastname:'Scheuner', firstname:'Barbara', email:'barbara.scheuner@fhnw.ch').save()

        User winter = new User(lastname:'Winter', firstname:'Markus', email:'markus.winter@studnets.fhnw.ch').save()
        User hundt  = new User(lastname:'Hundt', firstname:'Thierry', email:'thierry.hundt@studnets.fhnw.ch').save()

        Module webec = new Module(name:'webeC', semester:3, location:'5.2H14', lecturer:ribeaud, user:hundt).save()
        Module aldg1 = new Module(name:'aldg1', semester:3, location:'6.1H07', lecturer:weck, user:hundt).save()
        Module p3p4  = new Module(name:'p3/p4', semester:3, location:'5.4.H06', lecturer:scheuner, user:winter).save()

        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-09 08:15:00"), weighting:40, grade: 4.5, module:p3p4).save()
        new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-01-15 15:15:00"), weighting:60, module:p3p4).save()
    }
    def destroy = {
    }
}
