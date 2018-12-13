package webec

import grails.gorm.services.Service

@Service(Lecturer)
interface LecturerService {

    Lecturer get(Serializable id)

    List<Lecturer> list(Map args)

    Long count()

    void delete(Serializable id)

    Lecturer save(Lecturer lecturer)

}