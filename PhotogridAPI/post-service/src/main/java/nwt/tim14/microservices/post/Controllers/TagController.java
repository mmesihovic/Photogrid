package nwt.tim14.microservices.post.Controllers;

import nwt.tim14.microservices.post.Entities.Tag;
import nwt.tim14.microservices.post.Repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {

    @Autowired
    private ITagRepository tagRepository;

    @RequestMapping(value="/posts/tags", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @RequestMapping(value="/posts/tags", method = RequestMethod.POST)
    public void addTag(@RequestBody Tag tag) {
        System.out.print(tag);
        tagRepository.save(tag);
    }

    @RequestMapping(value = "/posts/tags/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tag getTagById(@PathVariable Long id) {
        return tagRepository.findOne(id);
    }

    @RequestMapping(value = "/posts/tags/{id}", method = RequestMethod.DELETE)
    public void deleteTag(@PathVariable Long id) {
        tagRepository.delete(id);
    }

    @RequestMapping(value ="/posts/tags/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Tag updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        Tag newTag = tagRepository.findOne(id);
        newTag.setName(tag.getName());
        tagRepository.save(newTag);
        return newTag;
    }

}
