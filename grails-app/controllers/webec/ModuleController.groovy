package webec

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*


/**
 * Controller for Module
 */
@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class ModuleController {

    ModuleService moduleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    /**
     * Lists all modules
     * @param max number of records
     * @return
     */
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond moduleService.list(params), model:[moduleCount: moduleService.count()]
    }

    /**
     * Lists one module
     * @param id from module
     * @return
     */
    def show(Long id) {
        respond moduleService.get(id)
    }

    /**
     * Creates a new module
     * @return
     */
    def create() {
        respond new Module(params)
    }

    /**
     * Saves the given module
     * @param module
     * @return
     */
    def save(Module module) {
        if (module == null) {
            notFound()
            return
        }

        try {
            moduleService.save(module)
        } catch (ValidationException e) {
            respond module.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'module.label', default: 'Module'), module.id])
                redirect module
            }
            '*' { respond module, [status: CREATED] }
        }
    }

    /**
     * Edits an module
     * @param id from module
     * @return
     */
    def edit(Long id) {
        respond moduleService.get(id)
    }

    /**
     * Updates the given module
     * @param module
     * @return
     */
    def update(Module module) {
        if (module == null) {
            notFound()
            return
        }

        try {
            moduleService.save(module)
        } catch (ValidationException e) {
            respond module.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'module.label', default: 'Module'), module.id])
                redirect module
            }
            '*'{ respond module, [status: OK] }
        }
    }

    /**
     * Deletes the given module
     * @param id from module
     * @return
     */
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        moduleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'module.label', default: 'Module'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    /**
     * Not found message
     */
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'module.label', default: 'Module'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
