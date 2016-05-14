package me.psychopunch.spring.demo.security

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/books')
class BookController {

    @RequestMapping(path='public', method=RequestMethod.GET)
    def publicBooks() {
        return [new Book(title: 'Public Book', author: 'John Smith')]
    }

    @RequestMapping(path='secured', method=RequestMethod.GET)
    @PreAuthorize('authenticated')
    def securedBooks() {
        return [new Book(title: 'Secured Book', author: 'John Doe')]
    }

}
