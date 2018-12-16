package webec

import grails.gorm.services.Service

/**
 * Service-Interface for Lecturer
 */
@Service(Lecturer)
interface LecturerService {

    Lecturer get(Serializable id)

    List<Lecturer> list(Map args)

    Long count()

    void delete(Serializable id)

    Lecturer save(Lecturer lecturer)

}