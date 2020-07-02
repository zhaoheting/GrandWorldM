package web.controllers.learn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.services.learn.CollectionsService;

@RestController
@RequestMapping("/collection")
public class CollectionsController {

    private CollectionsService collectionsService;

    public CollectionsController(CollectionsService collectionsService) {
        this.collectionsService = collectionsService;
    }

    @RequestMapping("/iterator")
    public void testIterator() {
        collectionsService.removeElementEveryTwo();
    }
}
